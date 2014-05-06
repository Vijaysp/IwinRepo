package dao.hibernate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.dao.DataAccessException;

import dao.hibernate.pojo.Match;
import dao.hibernate.pojo.Player;
import dao.hibernate.pojo.Prediction;
import dao.hibernate.pojo.Scorecard;
import dao.hibernate.pojo.Team;
import dao.hibernate.pojo.User;
import dao.hibernate.pojo.UserTeam;

public interface SpringHibernateDAO
{
	public boolean checkUserLogin(String strUserName, String strPassword)
			throws DataAccessException, SQLException;

	public void addUser(User obj) throws DataAccessException;
	
	public void updatePassword(User obj) throws DataAccessException,SQLException;

	public void updateUser(dao.hibernate.pojo.User obj)
			throws DataAccessException;

	public User loadUser(String id) throws DataAccessException;

	public boolean checkUserExists(String strUserid, String emailid)
			throws DataAccessException, SQLException;

	public String getUserId(String strUserid) throws DataAccessException,
			SQLException;

	public ArrayList getEligibleMatches(Date currentDate);

	public ArrayList getTeams();

	public HashMap getPlayers();

	public void addTeam(Team obj) throws DataAccessException;

	public void addMatch(Match obj) throws DataAccessException;

	public void createPrediction(Prediction obj) throws DataAccessException;

	public void createUserTeam(UserTeam obj) throws DataAccessException;
	
	public void updatePrediction(Prediction obj) throws DataAccessException;

	public void updateUserTeam(UserTeam obj) throws DataAccessException;
	
	public Prediction checkPredictionExist(String matchID, String userID);
	
	public UserTeam checkUserTeamExist(String userID);

	public ArrayList getMatches();

	public ArrayList getPredictions();

	public ArrayList getUserPredictions(String userID);

	public Long getMaxMatchID();

	public void addPlayer(Player obj);

	public ArrayList generatePointsTable();
	
	public ArrayList gnratePointsTblBasedOnAvg();

	public ArrayList getUsers();
	
	public boolean checkIfValidSave(String matchId);

	public ArrayList generateTopPredictor();
	
	public void addScoreCard(Scorecard scorecard);
	
	public ArrayList getScorecard();
	
	public ArrayList getBestPrediction(String fromDate, String toDate);
	
	public ArrayList getPlayersForPlayOff(ArrayList<String> teamsListCol);
	
	public ArrayList<UserTeam> getAllUserTeams();
	
	public ArrayList<String> getPlayersListFromUserTeams();
}
