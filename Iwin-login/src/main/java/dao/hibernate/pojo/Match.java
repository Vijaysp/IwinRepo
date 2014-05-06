package dao.hibernate.pojo;

import java.io.Serializable;
import java.util.Date;

public class Match implements Serializable
{
	private Date matchDate;
	private String matchid;
	private String team1;
	private String team2;
	private String venue;

	/**
	 * @return the venue
	 */
	public String getVenue()
	{
		return venue;
	}

	/**
	 * @param venue
	 *            the venue to set
	 */
	public void setVenue(String venue)
	{
		this.venue = venue;
	}

	public Date getMatchDate()
	{
		return matchDate;
	}

	public void setMatchDate(Date matchDate)
	{
		this.matchDate = matchDate;
	}

	public String getMatchid()
	{
		return matchid;
	}

	public void setMatchid(String matchid)
	{
		this.matchid = matchid;
	}

	public String getTeam1()
	{
		return team1;
	}

	public void setTeam1(String team1)
	{
		this.team1 = team1;
	}

	public String getTeam2()
	{
		return team2;
	}

	public void setTeam2(String team2)
	{
		this.team2 = team2;
	}

	public String toString()
	{
		return "Match " + matchid + " will be played between " + team1
				+ " and " + team2 + " on " + matchDate;
	}
}
