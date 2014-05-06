package dao.hibernate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.iwin.persistence.ConnectionManager;

import dao.hibernate.pojo.Match;
import dao.hibernate.pojo.Player;
import dao.hibernate.pojo.Prediction;
import dao.hibernate.pojo.Scorecard;
import dao.hibernate.pojo.User;
import dao.hibernate.pojo.UserTeam;

/**
 * Hibernate implementation of the JobModule interface.
 */
public class SpringHibernateDAOImpl extends HibernateDaoSupport implements
        SpringHibernateDAO
{
	// check Admin login
	  Connection conn= null;
	 
		
	public boolean checkUserLogin(String strUserName, String strPassword)
	        throws DataAccessException, java.sql.SQLException
	{
		boolean valid = false;
		 conn = ConnectionManager.getConnection();
		// Write JDBC code to validate the user against database
		Statement smt = conn.createStatement();
		ResultSet rs;
		// write select query for checking password

		String query = "select userid from users where userid='" + strUserName + "' and password='" + strPassword + "'";
		
		rs = smt.executeQuery(query);

		if (rs.next() == true)
		{
			valid = true;
		}
		else
		{
			valid = false;
		}

		smt.close();
		rs.close();
		conn.close();

		return valid;
	}

	public void addUser(dao.hibernate.pojo.User obj) throws DataAccessException
	{
		System.out.println("Add: Email Id: "+obj.getEmailId());
		getHibernateTemplate().save(obj);
	}
	public void updatePassword(User obj) throws DataAccessException, SQLException
	{
//		getHibernateTemplate().update(obj);
		 conn = ConnectionManager.getConnection();
		// Write JDBC code to validate the user against database
		Statement smt = conn.createStatement();
		// write select query for checking password
		
		String query = "update users set password='" + obj.getPassword() 
				+ "' where email_id='"+obj.getEmailId()+"'";
		
		  smt.executeUpdate(query);
		  smt.close();
		  conn.close();
	}
	public void updateUser(dao.hibernate.pojo.User obj)
	        throws DataAccessException
	{
		getHibernateTemplate().update(obj);
	}

	public dao.hibernate.pojo.User loadUser(String id)
	        throws DataAccessException
	{
		return (dao.hibernate.pojo.User) (getHibernateTemplate().find("from dao.hibernate.pojo.User obj where obj.userid = '" + id + "'")).get(0);
	}

	public boolean checkUserExists(String strUserid, String emailid)
	        throws DataAccessException, SQLException
	{
		boolean valid = false;
		 conn = ConnectionManager.getConnection();
		// Write JDBC code to validate the user against database
		Statement smt = conn.createStatement();
		ResultSet rs;
		// write select query for checking password
		
		String query = "select userid from users where (userid='" + strUserid 
				+ "' or email_id='"+emailid+"')";
		
		rs = smt.executeQuery(query);

		if (rs.next() == true)
		{
			valid = true;
		}
		else
		{
			valid = false;
		}

		smt.close();
		rs.close();
		conn.close();

		return valid;
	}

	// get latest jobs
	public String getUserId(String strUserid) throws DataAccessException,
	        java.sql.SQLException
	{
		 conn = ConnectionManager.getConnection();
		// Write JDBC code to validate the user against database
		Statement smt = conn.createStatement();
		ResultSet rs;
		// write select query for checking password

		String query = "select userid from users where userid='" + strUserid
		        + "'";
		rs = smt.executeQuery(query);
		rs.next();

		String id = rs.getString("userid");

		smt.close();
		rs.close();
		conn.close();
		return id;
	}

	public ArrayList getTeams()
	{
		ArrayList teamList = null;
		
		teamList = (ArrayList) (getHibernateTemplate().find("from dao.hibernate.pojo.Team obj"));
		return teamList;
	}

	public ArrayList getEligibleMatches(Date toDate)
	{
		ArrayList matches = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");

		 conn = ConnectionManager.getConnection();
		PreparedStatement prepStatement = null;
		ResultSet rs = null;
		
		try
		{
			if (null != toDate)
			{
				prepStatement = conn.prepareStatement(QueryConst.
						GET_ALL_ELIGIBLE_MATCHES_WITH_ENDDATE);
				prepStatement.setTimestamp(1, new Timestamp(new Date().getTime()));
				prepStatement.setTimestamp(2, new Timestamp(toDate.getTime()));
				System.out.println("Getting matches based on: "+QueryConst.
						GET_ALL_ELIGIBLE_MATCHES_WITH_ENDDATE);
			}
			else
			{
				prepStatement = conn.prepareStatement(QueryConst.
						GET_ALL_ELIGIBLE_MATCHES);
				prepStatement.setTimestamp(1, new Timestamp(new Date().getTime()));
				System.out.println("Getting matches based on: "+QueryConst.
						GET_ALL_ELIGIBLE_MATCHES);
			}
			
			rs = prepStatement.executeQuery();

			matches = new ArrayList();
			
			while (rs.next())
			{
				Match match = new Match();
				
				match.setMatchid(rs.getString("MATCHID"));
				match.setMatchDate(rs.getTimestamp("MATCHDATE"));
				match.setTeam1(rs.getString("TEAM1"));
				match.setTeam2(rs.getString("TEAM2"));
				match.setVenue(rs.getString("VENUE"));
				
				matches.add(match);
			}
		}
		catch (SQLException sqlExp)
		{
			sqlExp.printStackTrace();
		}
		finally 
		{
			this.closeAllResources(conn, prepStatement, rs);
		}
		
		return matches;
	}

	public boolean checkIfValidSave(String matchId)
	{
		boolean validSaveAction = true;

		 conn = ConnectionManager.getConnection();
		PreparedStatement prepStatement = null;
		ResultSet rs = null;
		
		try
		{
			prepStatement = conn.prepareStatement(QueryConst.
					CHECK_FOR_VALID_SAVE);

			prepStatement.setTimestamp(1, new Timestamp(new Date().getTime()));
			prepStatement.setString(2, matchId);
			
			rs = prepStatement.executeQuery();
			
			while (rs.next())
			{
				validSaveAction = false;
				break;
			}			
		}
		catch (SQLException sqlExp)
		{
			sqlExp.printStackTrace();
		}
		finally
		{
			this.closeAllResources(conn, prepStatement, rs);
		}
		return validSaveAction;
	}
	
	public HashMap getPlayers()
	{
		HashMap result = null;
		ArrayList<String> players = null;
		Iterator playerItr = null;
		Player player = null;
		
		players = (ArrayList) (getHibernateTemplate().find("from dao.hibernate.pojo.Player obj order by name"));

		if (players != null)
		{
			playerItr = players.iterator();
			result = new HashMap<String, ArrayList<String>>();
			ArrayList<String> playerNames = null;

			while (playerItr.hasNext())
			{
				player = (Player) playerItr.next();
				playerNames = new ArrayList<String>();
				
				if (result.get(player.getTeamname()) == null)
				{
					playerNames.add(player.getName() + " (" + player.getCategory() + ") ");
					result.put(player.getTeamname(), playerNames);
				}
				else
				{
					playerNames = (ArrayList) result.get(player.getTeamname());
					playerNames.add(player.getName() + " (" + player.getCategory() + ") ");
					result.put(player.getTeamname(), playerNames);
				}
			}
		}

		return result;
	}

	public ArrayList getPlayersForPlayOff(ArrayList<String> teamsListCol)
	{
		ArrayList<String> playerNames = null;
		int count = 0;
		
		StringBuffer querySB = new StringBuffer("SELECT * FROM PLAYER WHERE TEAMNAME IN (");
		
		for (int i = 1; i <= teamsListCol.size(); i++)
		{
			querySB.append("?");
			count ++;
			
			if (count < teamsListCol.size())
			{
				querySB.append(",");
			}
			else
			{
				querySB.append(") ORDER BY NAME");
			}
		}

		System.out.println("Finale Query: "+querySB.toString());
		
//		Connection conn = getSession().connection();
		 conn = ConnectionManager.getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		try
		{
			pStmt = conn.prepareStatement(querySB.toString());
			
			for (int i = 1; i <= teamsListCol.size(); i++)
			{
				pStmt.setString(i, teamsListCol.get(i-1));
			}
			
			rs = pStmt.executeQuery();
			playerNames = new ArrayList<String>();
			
			while (rs.next())
			{
				playerNames.add(rs.getString("NAME")+ "(" + rs.getString("CATEGORY") + ")");
			}
		}
		catch (SQLException sqlExp)
		{
			sqlExp.printStackTrace();
		}

		return playerNames;
	}	
	
	public void createPrediction(Prediction obj) throws DataAccessException
	{
		getHibernateTemplate().save(obj);
	}

	public void createUserTeam(UserTeam obj) throws DataAccessException
	{
		getHibernateTemplate().save(obj);
	}
	
	public void updatePrediction(Prediction obj) throws DataAccessException
	{
		getHibernateTemplate().update(obj);
	}

	public void addTeam(dao.hibernate.pojo.Team obj) throws DataAccessException
	{
		getHibernateTemplate().save(obj);
	}

	public void addMatch(Match obj) throws DataAccessException
	{
		getHibernateTemplate().save(obj);
	}

	public Prediction checkPredictionExist(String matchID, String userID)
	{
		Prediction prediction = null;
		ArrayList predictionList = (ArrayList) (getHibernateTemplate().find("from dao.hibernate.pojo.Prediction obj where matchid ='" + matchID + "~" + userID + "'"));

		if (predictionList != null && !predictionList.isEmpty())
		{
			prediction = (Prediction) predictionList.get(0);
		}
		return prediction;
	}

	public ArrayList getMatches()
	{
		return (ArrayList) (getHibernateTemplate().find("from dao.hibernate.pojo.Match obj"));
	}

	public ArrayList getPredictions()
	{
		return (ArrayList) (getHibernateTemplate().find("from dao.hibernate.pojo.Prediction obj order by matchdate, matchid"));
	}

	public ArrayList getUserPredictions(String userID)
	{
		return (ArrayList) (getHibernateTemplate().find("from dao.hibernate.pojo.Prediction obj where userid ='" + userID + "' order by matchdate, matchid"));
	}

	public Long getMaxMatchID()
	{
		ArrayList vij = (ArrayList) (getHibernateTemplate().find("select count(matchid) from Match obj"));
		long matchid = (Long) vij.get(0);
		return matchid + 1;
	}

	public void addPlayer(Player obj)
	{
		getHibernateTemplate().save(obj);
	}

	public ArrayList generatePointsTable()
	{
		return (ArrayList) (getHibernateTemplate()
		        .find("select new Prediction(userid, sum(points)) from Prediction group by userid order by sum(points) desc "));
	}

	public ArrayList generateTopPredictor()
	{
		return (ArrayList) (getHibernateTemplate()
				.find("select new Prediction(userid, max(points) from Prediction where matchdate = (sysdate -1) group by userid"));
	}
	public ArrayList getUsers()
	{
		return (ArrayList) (getHibernateTemplate().find("from User"));
	}
	
	public void addScoreCard(Scorecard scorecard)
	{
		getHibernateTemplate().save(scorecard);
	}
	
	public ArrayList getBestPrediction(String fromDate, String toDate)
	{
		ArrayList scoreCardCol = null;
		 conn = ConnectionManager.getConnection();
		PreparedStatement prepStatement = null;
		ResultSet rs = null;
		
		try
		{
			if (fromDate != null && toDate != null)
			{
				prepStatement = conn.prepareStatement(QueryConst.
						GET_BEST_PREDICTION_IN_SPECIFIED_RANGE);
				prepStatement.setString(1, fromDate);
				prepStatement.setString(2, toDate);
			}
			else if (fromDate != null)
			{
				prepStatement = conn.prepareStatement(QueryConst.
						GET_BEST_PREDICTION_FOR_THE_DAY);
				prepStatement.setString(1, fromDate);
			}
			else
			{
				prepStatement = conn.prepareStatement(QueryConst.
						GET_BEST_PREDICTION);
			}
				
			rs = prepStatement.executeQuery();

			scoreCardCol = new ArrayList();
			
			while (rs.next())
			{
				Scorecard scorecard = new Scorecard();
				
				scorecard.setMatchid(rs.getString("MATCHID"));
				scorecard.setMatchDate(rs.getString("MATCHDATE"));
				scorecard.setPlayerName(rs.getString("PLAYER"));
				scorecard.setRunsScored(rs.getInt("RUNS_SCORED"));
				scorecard.setWicketsTaken(rs.getInt("WICKETS_TAKEN"));
				scorecard.setCatchesHeld(rs.getInt("CATCHES_HELD"));
				scorecard.setStumpings(rs.getInt("STUMPINGS"));
				scorecard.setSixes(rs.getInt("SIXES"));
				scorecard.setIsWicketKeeper(rs.getString("ISWKTKEEPER"));
				scorecard.setIsHattrick(rs.getString("HATTRICK"));
				scorecard.setWonMoM(rs.getString("MOM"));
				scorecard.setDuckOrGD(rs.getString("DUCK_OR_GD"));
				scorecard.setPoints(rs.getInt("POINTS"));
				
				scoreCardCol.add(scorecard);
			}
		}
		catch (SQLException sqlExp)
		{
			sqlExp.printStackTrace();
		}
		finally 
		{
			this.closeAllResources(conn, prepStatement, rs);
		}
		
		return scoreCardCol;
	}
	
	public ArrayList getScorecard()
	{
		ArrayList scoreCardCol = null;
		 conn = ConnectionManager.getConnection();
		PreparedStatement prepStatement = null;
		ResultSet rs = null;
		
		try
		{
			prepStatement = conn.prepareStatement(QueryConst.
					GET_ENTIRE_SCORECARD);
				
			rs = prepStatement.executeQuery();

			scoreCardCol = new ArrayList();;
			
			while (rs.next())
			{
				Scorecard scorecard = new Scorecard();
				
				scorecard.setMatchid(rs.getString("MATCHID"));
				scorecard.setMatchDate(rs.getString("MATCHDATE"));
				scorecard.setPlayerName(rs.getString("PLAYER"));
				scorecard.setRunsScored(rs.getInt("RUNS_SCORED"));
				scorecard.setWicketsTaken(rs.getInt("WICKETS_TAKEN"));
				scorecard.setCatchesHeld(rs.getInt("CATCHES_HELD"));
				scorecard.setStumpings(rs.getInt("STUMPINGS"));
				scorecard.setSixes(rs.getInt("SIXES"));
				scorecard.setIsWicketKeeper(rs.getString("ISWKTKEEPER"));
				scorecard.setIsHattrick(rs.getString("HATTRICK"));
				scorecard.setWonMoM(rs.getString("MOM"));
				scorecard.setDuckOrGD(rs.getString("DUCK_OR_GD"));
				scorecard.setPoints(rs.getInt("POINTS"));
				
				scoreCardCol.add(scorecard);
			}
		}
		catch (SQLException sqlExp)
		{
			sqlExp.printStackTrace();
		}
		finally 
		{
			this.closeAllResources(conn, prepStatement, rs);
		}
		
		return scoreCardCol;		
	}
	
	private void closeAllResources(Connection conn, Statement stmt,
			ResultSet rs)
	{
		if (null != conn)
		{
			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		if (null != stmt)
		{
			try
			{
				stmt.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		if (null != rs)
		{
			try
			{
				rs.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	public ArrayList gnratePointsTblBasedOnAvg()
	{
		ArrayList userCol = new ArrayList();
		PreparedStatement prepStatement = null;
		ResultSet rs = null;
		 conn = ConnectionManager.getConnection();
		
		String userid = null;
		Float average = null;
		float totalpoints = 0;
		float totalmatches = 0;
		com.iwin.domain.Prediction pred = null;
		
		final String QUERY = "select userid, sum(points) totpoints, count(matchid) totmatch from Prediction where matchdate < ? group by userid";
		
		try
		{
			prepStatement = conn.prepareStatement(QUERY);
			prepStatement.setTimestamp(1, new Timestamp(new Date().getTime()));
			
			rs = prepStatement.executeQuery();
			
			while (rs.next())
			{
				userid = rs.getString("userid");
				totalpoints = rs.getInt("totpoints");
				totalmatches = rs.getInt("totmatch");
				
				DecimalFormat decFormat = new DecimalFormat("#.##");
				average = totalpoints/totalmatches;
				
				pred = new com.iwin.domain.Prediction();
				pred.setUserid(userid);
				pred.setPoints(totalpoints);
				pred.setMatches(totalmatches);
				pred.setAverage(Float.valueOf(decFormat.format(average)));
								
				userCol.add(pred);
			}
		}
		catch (SQLException sqlExp)
		{
			sqlExp.printStackTrace();
		}
		finally
		{
			this.closeAllResources(conn, prepStatement, rs);
		}
		
		return userCol;
	}

	public UserTeam checkUserTeamExist(String userID)
	{
		UserTeam userTeam = null;
		ArrayList userTeamList = (ArrayList) (getHibernateTemplate().find("from dao.hibernate.pojo.UserTeam obj where userid ='"+ userID+"'"));

		if (userTeamList != null && !userTeamList.isEmpty())
		{
			userTeam = (UserTeam) userTeamList.get(0);
		}
		return userTeam;
	}

	public void updateUserTeam(UserTeam obj) throws DataAccessException
	{
		getHibernateTemplate().update(obj);
	}
	
	public ArrayList<UserTeam> getAllUserTeams()
	{
		ArrayList<UserTeam> userTeamCol = (ArrayList<UserTeam>)getHibernateTemplate().
				find("from dao.hibernate.pojo.UserTeam obj");
		
		return userTeamCol;
	}
	
	public ArrayList<String> getPlayersListFromUserTeams()
	{
		ArrayList<String> playersCol = new ArrayList();
		
		final String QUERY = "SELECT * FROM USERTEAM";
		 conn = ConnectionManager.getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String rsFetchStr = "PLAYER";		
		
		try
		{
			pStmt = conn.prepareStatement(QUERY);
			
			rs = pStmt.executeQuery();
			
			while(rs.next())
			{
				for (int i = 1; i <= 11; i++)
				{
					if (!playersCol.contains(rs.getString((rsFetchStr+i))))
					{
						playersCol.add(rs.getString((rsFetchStr+i)));
					}
				}
				
				if (!playersCol.contains(rs.getString("SUBSTITUTE")))
				{
					playersCol.add(rs.getString("SUBSTITUTE"));
				}
			}
		}
		catch (SQLException sqlExp)
		{
			sqlExp.printStackTrace();
		}
	
		
		return playersCol;
	}
}



