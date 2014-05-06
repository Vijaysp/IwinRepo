package struts.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import services.ServiceFinder;
import struts.form.PointsForm;
import dao.hibernate.pojo.Prediction;
import dao.hibernate.pojo.Scorecard;

public class PointsAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		HashMap scoreCardHM = null;
		HttpSession session = request.getSession();
		PointsForm obj = (PointsForm) form;
		ArrayList predictions = null;
		ArrayList<String> momList = (ArrayList) session.getAttribute("momList");
		Iterator predItr = null;
		Prediction pred = null;
		String matchID = null;
		String chosenMatchID = (String) session.getAttribute("chosenMatchID");
		chosenMatchID = chosenMatchID.substring(0, chosenMatchID.indexOf("-"))
				.trim();
		String teamWon = obj.getTeamwon();
		String[] runs = obj.getRuns();
		String[] wickets = obj.getWickets();
		String[] stumping = obj.getStumping();
		String[] duck = obj.getDuck();
		String[] mom = obj.getMom();
		String[] catches = obj.getCatches();
		String[] isWktKeeper = obj.getIsWktKeeper();
		String[] player = obj.getPlayer();
		String[] hattrick = obj.getHattrick();
		String[] sixesCount = obj.getSixesCount();
		String[] directHits = obj.getDirectHits();
		String[] collabRunOuts = obj.getCollabRunOuts();

		int points = 0;
		int runsScored = 0;
		int wicketsTaken = 0;
		int catchesHeld = 0;
		int runOuts = 0;
		boolean isWicketKeeper = false;
		
		Scorecard scorecard = null;

		if (session.getAttribute("userID").equals("admin"))
		{
			dao.hibernate.SpringHibernateDAO springHibernateDAO = (dao.hibernate.SpringHibernateDAO) ServiceFinder
					.getContext(request).getBean("SpringHibernateDao");
			predictions = (ArrayList) session.getAttribute("allpredictions");
			
			for (int i = 0; i < momList.size() && predictions != null
					&& !predictions.isEmpty(); i++)
			{
				scoreCardHM = new HashMap();
				predItr = predictions.iterator();

				while (predItr.hasNext())
				{
					points = 0;

					pred = (Prediction) predItr.next();

					matchID = pred.getMatchid().substring(0,
							pred.getMatchid().indexOf("~"));

					scorecard = new Scorecard();

					if (chosenMatchID.equals(matchID))
					{
						if (pred.getMom().equals(player[i]))
						{
							scorecard.setMatchid(matchID);
							scorecard.setMatchDate(pred.getMatchDate());
							scorecard.setPlayerName(pred.getMom());
							scorecard.setIsHattrick("No");
							scorecard.setWonMoM("No");
							scorecard.setDuckOrGD("NA");
							
							runsScored = 0;
							wicketsTaken = 0;
							catchesHeld = 0;
							isWicketKeeper = false;

							// Runs scored
							// If a batsman scores 100 or above, with range value
							// included, he will gain a bonus of 100 points + 3
							// points for every run scored after 100.
							// E.g., If Micheal Hussey scores 100, he will fetch
							// you 100*1 + 100 = 200 points
							// If Chris Gayle scores 135, he will fetch you 100*1
							// + 100 + (135-100)*3 = 305 points

							// If a batsman scores between 50 and 99 with both
							// range values included, he will gain a bonus of 50
							// points + 2 points for every run scored after 50.
							// E.g., if Rohit Sharma scores 50, he will fetch you
							// 50*1 + 50 = 100 points
							// If Dinesh Karthick scores 72, he will fetch you
							// 50*1 + 50 + (72-50)*2 = 124 points

							// If a batsman scores between 30 and 49 with both
							// range values included, he will gain a bonus of 30
							// points.
							// E.g., if Robin Uttappa scores 45, he will fetch
							// you 45*1 + 30 = 75 points

							// If a batsman scores between 1 and 29 with both
							// range values included, he will score 1 points for
							// every run scored
							// E.g., If Adam Gilchrist scores 25, he will fetch
							// you 25*1 = 25 points.
							if (runs[i] != null && !runs[i].equals(""))
							{
								runsScored = Integer.parseInt(runs[i]);

								scorecard.setRunsScored(runsScored);
								
								if (runsScored >= 100)
								{
									points = points + 100 + 100
											+ (runsScored - 100) * 3;
								}
								else if (runsScored >= 50)
								{
									points = points + 50 + 50
											+ (runsScored - 50) * 2;
								}
								else if (runsScored >= 30)
								{
									points = points + 30 + runsScored;
								}
								else
								{
									points = points + runsScored;
								}
							}

							// Wickets taken
							// If a bolwer takes 5 wickets or above, he will
							// gain a bonus of 100 points and 60 points for
							// every wicket after 5 wickets
							// E.g., If Sunil Narine takes 5 wickets, he will
							// fetch you 5*30 + 100 = 250 points
							// If James Faulkner takes 6 wickets, he will
							// fetch you 5*30 + 100 + (6-5) * 60 = 310 points

							// If a bolwer takes either 3 or 4 wickets, he
							// will gain a bonus of 75 points
							// E.g., If R Ashwin takes 3 wickets, he will
							// fetch you 3*30 + 75 = 165 points
							// If K Cooper takes 4 wickets, he will fetch you
							// 4*30 + 75 = 195 points

							// If a bolwer takes less than 3 wickets, he will
							// score 30 points for every wicket taken
							// E.g., If R Jadeja doesn't take a wicket in a
							// match, he will not fetch you any points for
							// his bowling
							// If R Vinay Kumar takes 2 wickets, he will
							// fetch you 2*30 = 60 points

							if (wickets[i] != null && !wickets[i].equals(""))
							{
								wicketsTaken = Integer.parseInt(wickets[i]);
								
								scorecard.setWicketsTaken(wicketsTaken);
								
								if (wicketsTaken >= 5)
								{
									points = points + 100 + (5 * 30)
											+ (wicketsTaken - 5) * 60;
								}
								else if (wicketsTaken >= 3)
								{
									points = points + 75 + (wicketsTaken * 30);
								}
								else
								{
									points = points + (wicketsTaken * 30);
								}
							}

							// Catches:
							// If a wicket-keeper takes 3 or more catches, he
							// will gain a bonus of 50 + 20 points for every
							// catch
							// E.g., If MS Dhoni takes 4 catches, he will fetch
							// you 4*20 + 50 = 130 points

							// If a non wicket-keeper takes 3 or more catches, he
							// will gain a bonus of 100 + 30 points for every
							// catch
							// E.g., If Rahul Dravid takes 3 catches, he will
							// fetch you 3*30 + 100 = 190 points

							// For every catch, a wicket-keeper takes, he will be
							// awarded 20 points per catch
							// For every catch, a non wicket-keeper takes, he
							// will be awarded 30 points per catch.
							if (catches[i] != null && !catches[i].equals(""))
							{
								catchesHeld = Integer.parseInt(catches[i]);

								scorecard.setCatchesHeld(catchesHeld);
								
								if (isWktKeeper[i] != null
										&& !isWktKeeper[i].equals(""))
								{
									if ("yes".equalsIgnoreCase(
											(String)isWktKeeper[i]))
									{
										isWicketKeeper = true;
									}
								}

								if (isWicketKeeper)
								{
									scorecard.setIsWicketKeeper("Yes");
									
									if (catchesHeld >= 3)
									{
										points = points + 50
												+ (catchesHeld * 5);
									}
									else
									{
										points = points + (catchesHeld * 5);
									}
								}
								else
								{
									scorecard.setIsWicketKeeper("No");
									
									if (catchesHeld >= 3)
									{
										points = points + 50
												+ (catchesHeld * 10);
									}
									else
									{
										points = points + (catchesHeld * 10);
									}
								}
							}

							// If a wicket-keeper performs 3 or more stumping in
							// a match, he will gain a bonus of 100 points.
							if (stumping[i] != null && !stumping[i].equals(""))
							{
								int stumpingsPerformed = Integer
										.parseInt(stumping[i]);

								scorecard.setStumpings(stumpingsPerformed);
								
								if (stumpingsPerformed >= 3)
								{
									points = points + 100 + 50
											* stumpingsPerformed;
								}
								else
								{
									points = points + 50 * stumpingsPerformed;
								}
							}
							
							// Run-outs
							if (directHits[i] != null 
									&& !directHits[i].equals(""))
							{
								runOuts = Integer.parseInt(directHits[i]);
								
								points = points + 10 * Integer.
										parseInt(directHits[i]);
							}
							
							if (collabRunOuts[i] != null 
									&& !collabRunOuts[i].equals(""))
							{
								runOuts = runOuts + Integer.parseInt(
										collabRunOuts[i]);
								
								if (runOuts >= 3)
								{
									points = points + 50 + 5 * Integer.
											parseInt(collabRunOuts[i]);
								}
								else
								{
									points = points + 5 * Integer.
											parseInt(collabRunOuts[i]);
								}
							}
							scorecard.setRunOuts(runOuts);
							
							// Hattrick
							if (hattrick[i] != null && !hattrick[i].equals(""))
							{
								if ("yes".equalsIgnoreCase(
										(String)hattrick[i]))
								{
									scorecard.setIsHattrick("Yes");
									points = points + 150;
								}
							}

							// Hattrick
							if (sixesCount[i] != null
									&& !sixesCount[i].equals(""))
							{
								int sixes = Integer.parseInt(sixesCount[i]);
								
								scorecard.setSixes(sixes);
								
								points = points + (5 * sixes);
							}

							if (mom[i] != null && mom[i].equals("MoM"))
							{
								scorecard.setWonMoM("Yes");
								points = points + 100;
							}

							if (duck[i] != null)
							{
								System.err.println("points:duck->" + points);

								if ("Duck".equals(duck[i]))
								{
									scorecard.setDuckOrGD("Duck");
									System.err.println("points:duck(2)->"
											+ points);
									points = points - 25;
								}
								else if ("Golden Duck".equals(duck[i]))
								{
									scorecard.setDuckOrGD("GD");
									System.err.println("points:gduck->"
											+ points);
									points = points - 50;
								}
							}

							scorecard.setPoints(points);
							
							if (teamWon.equals(pred.getWinningTeam()))
							{
								points = points + 100;
							}
							else
							{
								points = points - 25;
							}

							pred.setPoints(points);
							System.out.println(scorecard);
							
							if (scoreCardHM.get(scorecard.
									getPlayerName()) == null)
							{
								scoreCardHM.put(scorecard.getPlayerName(), 
										scorecard);
								springHibernateDAO.addScoreCard(scorecard);
							}
							
							springHibernateDAO.updatePrediction(pred);
						}
					}
				}
			}
		}
		return mapping.findForward("success");
	}
}
