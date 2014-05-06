package struts.action;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import services.ServiceFinder;
import struts.form.MyTeamForm;
import dao.hibernate.pojo.UserTeam;

public class MyTeamAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		MyTeamForm myTeam = (MyTeamForm) form;
		UserTeam userTeam = null;
		
		String msg = this.validateMyTeam(myTeam);
		
		System.out.println("Msg: "+msg);
		
		if ("Successful".equals(msg))
		{
			dao.hibernate.SpringHibernateDAO springHibernateDAO = 
					(dao.hibernate.SpringHibernateDAO) ServiceFinder
					.getContext(request).getBean("SpringHibernateDao");
			
			userTeam = springHibernateDAO.checkUserTeamExist(myTeam.getUserid());
			
			if (userTeam == null)
			{
				userTeam = new UserTeam();
				userTeam.setUserid(myTeam.getUserid());
				userTeam.setTeamName(myTeam.getTeamName());
				userTeam.setPlayer1(myTeam.getPlayer1());
				userTeam.setPlayer2(myTeam.getPlayer2());
				userTeam.setPlayer3(myTeam.getPlayer3());
				userTeam.setPlayer4(myTeam.getPlayer4());
				userTeam.setPlayer5(myTeam.getPlayer5());
				userTeam.setPlayer6(myTeam.getPlayer6());
				userTeam.setPlayer7(myTeam.getPlayer7());
				userTeam.setPlayer8(myTeam.getPlayer8());
				userTeam.setPlayer9(myTeam.getPlayer9());
				userTeam.setPlayer10(myTeam.getPlayer10());
				userTeam.setPlayer11(myTeam.getPlayer11());
				userTeam.setSubstitute(myTeam.getSubstitute());
				userTeam.setLastUpdated(new Timestamp(new Date().getTime()));
				userTeam.setVersion(1);
				springHibernateDAO.createUserTeam(userTeam);
			}
			else
			{
				userTeam.setPlayer1(myTeam.getPlayer1());
				userTeam.setPlayer2(myTeam.getPlayer2());
				userTeam.setPlayer3(myTeam.getPlayer3());
				userTeam.setPlayer4(myTeam.getPlayer4());
				userTeam.setPlayer5(myTeam.getPlayer5());
				userTeam.setPlayer6(myTeam.getPlayer6());
				userTeam.setPlayer7(myTeam.getPlayer7());
				userTeam.setPlayer8(myTeam.getPlayer8());
				userTeam.setPlayer9(myTeam.getPlayer9());
				userTeam.setPlayer10(myTeam.getPlayer10());
				userTeam.setPlayer11(myTeam.getPlayer11());
				userTeam.setSubstitute(myTeam.getSubstitute());
				userTeam.setLastUpdated(new Timestamp(new Date().getTime()));
				userTeam.setVersion(userTeam.getVersion()+1);
				
				Calendar cal = Calendar.getInstance();
				cal.set(2013, 04, 21, 19, 59, 59);
				
				System.out.println("Userid: "+myTeam.getUserid()+" - update time: "+userTeam.getLastUpdated());
				System.out.println("Play-off Start: "+cal.getTime());
				
				
				if (cal.getTime().before(userTeam.getLastUpdated()))
				{
					request.setAttribute("WARN_MSG", "Play-off matches have started. You cannot update your team hereafter!!");
					return mapping.findForward("input");
				}
				else
				{
					springHibernateDAO.updateUserTeam(userTeam);
				}
			}
			
			return mapping.findForward("success");
		}
		else
		{
			request.setAttribute("WARN_MSG", msg);
			return mapping.findForward("input");
		}
	}

	private String validateMyTeam(MyTeamForm myTeam)
	{
		HashMap<String, String> myTeamPlayers = new HashMap<String, String>();
		String tempPlayer = null;
		Set<String> keySet = null;
		Iterator keysItr = null;
		String category = null;

		int allRounder = 0;
		int bowler = 0;
		int batsman = 0;
		int wicketKeeper = 0;
		
		if (myTeam.getTeamName() == null || "".equals(myTeam.
				getTeamName().trim()))
		{
			return "Team name cannot be empty";
		}
		
		myTeamPlayers.put(myTeam.getPlayer1(), myTeam.getPlayer1());
		
		if (myTeamPlayers.containsKey(myTeam.getPlayer2()))
		{
			return "Please choose distinct players";
		}
		else
		{
			myTeamPlayers.put(myTeam.getPlayer2(), myTeam.getPlayer2());
		}
		
		if (myTeamPlayers.containsKey(myTeam.getPlayer3()))
		{
			return "Please choose distinct players";
		}
		else
		{
			myTeamPlayers.put(myTeam.getPlayer3(), myTeam.getPlayer3());
		}
		
		if (myTeamPlayers.containsKey(myTeam.getPlayer4()))
		{
			return "Please choose distinct players";
		}
		else
		{
			myTeamPlayers.put(myTeam.getPlayer4(), myTeam.getPlayer4());
		}
		
		if (myTeamPlayers.containsKey(myTeam.getPlayer5()))
		{
			return "Please choose distinct players!";
		}
		else
		{
			myTeamPlayers.put(myTeam.getPlayer5(), myTeam.getPlayer5());
		}
		
		if (myTeamPlayers.containsKey(myTeam.getPlayer6()))
		{
			return "Please choose distinct players";
		}
		else
		{
			myTeamPlayers.put(myTeam.getPlayer6(), myTeam.getPlayer6());
		}
		
		if (myTeamPlayers.containsKey(myTeam.getPlayer7()))
		{
			return "Please choose distinct players";
		}
		else
		{
			myTeamPlayers.put(myTeam.getPlayer7(), myTeam.getPlayer7());
		}
		
		if (myTeamPlayers.containsKey(myTeam.getPlayer8()))
		{
			return "Please choose distinct players";
		}
		else
		{
			myTeamPlayers.put(myTeam.getPlayer8(), myTeam.getPlayer8());
		}
		
		if (myTeamPlayers.containsKey(myTeam.getPlayer9()))
		{
			return "Please choose distinct players";
		}
		else
		{
			myTeamPlayers.put(myTeam.getPlayer9(), myTeam.getPlayer9());
		}
		
		if (myTeamPlayers.containsKey(myTeam.getPlayer10()))
		{
			return "Please choose distinct players";
		}
		else
		{
			myTeamPlayers.put(myTeam.getPlayer10(), myTeam.getPlayer10());
		}
		
		if (myTeamPlayers.containsKey(myTeam.getPlayer11()))
		{
			return "Please choose distinct players";
		}
		else
		{
			myTeamPlayers.put(myTeam.getPlayer11(), myTeam.getPlayer11());
		}
		
		keySet = myTeamPlayers.keySet();
		keysItr = keySet.iterator();
		
		while (keysItr.hasNext())
		{
			tempPlayer = (String) keysItr.next();
			
			category = tempPlayer.substring(tempPlayer.indexOf('(')+1, 
					tempPlayer.indexOf(')'));

			if ("All-rounder".equals(category))
			{
				allRounder++;
			}
			else if ("Batsman".equals(category))
			{
				batsman++;
			}
			else if ("Bowler".equals(category))
			{
				bowler++;
			}
			else if ("Wicket-keeper".equals(category))
			{
				wicketKeeper++;
			}
		}
		
		System.out.println("Count of Batsman: "+batsman);
		System.out.println("Count of All-rounders: "+allRounder);
		System.out.println("Count of Wicket-keeper: "+wicketKeeper);
		System.out.println("Count of Bowler: "+bowler);
		
		if ((batsman == 6 && allRounder == 0 && wicketKeeper == 1 && bowler == 4) 
		 || (batsman == 5 && allRounder == 0 && wicketKeeper == 1 && bowler == 5) 	
		 || (batsman == 5 && allRounder == 1 && wicketKeeper == 1 && bowler == 4)
		 || (batsman == 5 && allRounder == 2 && wicketKeeper == 1 && bowler == 3)
		 || (batsman == 4 && allRounder == 1 && wicketKeeper == 1 && bowler == 5)
		 || (batsman == 4 && allRounder == 2 && wicketKeeper == 1 && bowler == 4)
		 || (batsman == 4 && allRounder == 3 && wicketKeeper == 1 && bowler == 3))
		{
			System.out.println("Valid Combination!!");
		}
		else
		{
			return "Invalid combination! Please refer Rules for a valid combination for creating your team.";
		}
		
		return "Successful";
	}
}
