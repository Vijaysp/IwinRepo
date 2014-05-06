package dao.hibernate.pojo;

public class Scorecard
{
	private String matchid;
	private String matchDate;
	private String playerName;
	private Integer runsScored;
	private Integer wicketsTaken;
	private Integer catchesHeld;
	private Integer stumpings;
	private Integer sixes;
	private String isWicketKeeper;
	private String isHattrick;
	private Integer points;
	private String wonMoM;
	private String duckOrGD;
	private Integer runOuts;
	
	/**
	 * @return the runOuts
	 */
	public Integer getRunOuts()
	{
		return runOuts;
	}

	/**
	 * @param runOuts the runOuts to set
	 */
	public void setRunOuts(Integer runOuts)
	{
		this.runOuts = runOuts;
	}

	public String toString()
	{
		return "MatchId: "+matchid+", playername: "+playerName+", points: "+points;
	}
	
	/**
	 * @return the duckOrGD
	 */
	public String getDuckOrGD()
	{
		return duckOrGD;
	}

	/**
	 * @param duckOrGD the duckOrGD to set
	 */
	public void setDuckOrGD(String duckOrGD)
	{
		this.duckOrGD = duckOrGD;
	}

	/**
	 * @return the stumpings
	 */
	public Integer getStumpings()
	{
		return stumpings;
	}

	/**
	 * @param stumpings the stumpings to set
	 */
	public void setStumpings(Integer stumpings)
	{
		this.stumpings = stumpings;
	}

	public Scorecard()
	{
		super();
	}

	/**
	 * @return the runsScored
	 */
	public Integer getRunsScored()
	{
		return runsScored;
	}

	/**
	 * @param runsScored the runsScored to set
	 */
	public void setRunsScored(Integer runsScored)
	{
		this.runsScored = runsScored;
	}

	/**
	 * @return the wicketsTaken
	 */
	public Integer getWicketsTaken()
	{
		return wicketsTaken;
	}

	/**
	 * @param wicketsTaken the wicketsTaken to set
	 */
	public void setWicketsTaken(Integer wicketsTaken)
	{
		this.wicketsTaken = wicketsTaken;
	}

	/**
	 * @return the catchesHeld
	 */
	public Integer getCatchesHeld()
	{
		return catchesHeld;
	}

	/**
	 * @param catchesHeld the catchesHeld to set
	 */
	public void setCatchesHeld(Integer catchesHeld)
	{
		this.catchesHeld = catchesHeld;
	}

	/**
	 * @return the sixes
	 */
	public Integer getSixes()
	{
		return sixes;
	}

	/**
	 * @param sixes the sixes to set
	 */
	public void setSixes(Integer sixes)
	{
		this.sixes = sixes;
	}

	/**
	 * @return the isWicketKeeper
	 */
	public String getIsWicketKeeper()
	{
		return isWicketKeeper;
	}

	/**
	 * @param isWicketKeeper the isWicketKeeper to set
	 */
	public void setIsWicketKeeper(String isWicketKeeper)
	{
		this.isWicketKeeper = isWicketKeeper;
	}

	/**
	 * @return the isHattrick
	 */
	public String getIsHattrick()
	{
		return isHattrick;
	}

	/**
	 * @param isHattrick the isHattrick to set
	 */
	public void setIsHattrick(String isHattrick)
	{
		this.isHattrick = isHattrick;
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

	/**
	 * @return the playerName
	 */
	public String getPlayerName()
	{
		return playerName;
	}

	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}

	/**
	 * @return the wonMoM
	 */
	public String getWonMoM()
	{
		return wonMoM;
	}

	/**
	 * @param wonMoM the wonMoM to set
	 */
	public void setWonMoM(String wonMoM)
	{
		this.wonMoM = wonMoM;
	}

	public Integer getPoints()
	{
		return points;
	}

	public void setPoints(Integer points)
	{
		this.points = points;
	}
}
