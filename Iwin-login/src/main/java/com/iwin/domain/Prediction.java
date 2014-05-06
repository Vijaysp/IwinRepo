package com.iwin.domain;

public class Prediction
{
	private Float matches;
	private Float average;
	private Float points;
	private String userid;
	/**
	 * @return the matches
	 */
	public Float getMatches()
	{
		return matches;
	}
	/**
	 * @param matches the matches to set
	 */
	public void setMatches(Float matches)
	{
		this.matches = matches;
	}
	/**
	 * @return the average
	 */
	public Float getAverage()
	{
		return average;
	}
	/**
	 * @param average the average to set
	 */
	public void setAverage(Float average)
	{
		this.average = average;
	}
	/**
	 * @return the points
	 */
	public Float getPoints()
	{
		return points;
	}
	/**
	 * @param points the points to set
	 */
	public void setPoints(Float points)
	{
		this.points = points;
	}
	/**
	 * @return the userid
	 */
	public String getUserid()
	{
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid)
	{
		this.userid = userid;
	}
}
