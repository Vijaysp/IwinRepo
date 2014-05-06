package dao.hibernate.pojo;

public class Prediction
{
	private String matchid;
	private String matchDate;
	private String winningTeam;
	private String mom;
	private Integer points;
	private String userid;

	
	public Prediction()
	{
		super();
	}

	public Prediction(String userID, Long totPoints)
	 {
	 	this.userid = userID;
	 	this.points = Integer.parseInt(totPoints.toString());
	 }
	public Prediction(String userID, Integer totPoints)
	{
		this.userid = userID;
		this.points = totPoints;
	}

	public String getMatchid()
	{
		return matchid;
	}

	public void setMatchid(String matchid)
	{
		this.matchid = matchid;
	}

	public String getMatchDate()
	{
		return matchDate;
	}

	public void setMatchDate(String matchDate)
	{
		this.matchDate = matchDate;
	}

	public String getWinningTeam()
	{
		return winningTeam;
	}

	public void setWinningTeam(String winningTeam)
	{
		this.winningTeam = winningTeam;
	}

	public String getMom()
	{
		return mom;
	}

	public void setMom(String mom)
	{
		this.mom = mom;
	}

	public Integer getPoints()
	{
		return points;
	}

	public void setPoints(Integer points)
	{
		this.points = points;
	}

	public String getUserid()
	{
		return userid;
	}

	public void setUserid(String userid)
	{
		this.userid = userid;
	}

}
