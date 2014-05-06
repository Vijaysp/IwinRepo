package struts.form;

import org.apache.struts.action.ActionForm;

public class PointsForm extends ActionForm
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String teamwon;
	private String[] runs;
	private String[] wickets;
	private String[] stumping;
	private String[] duck;
	private String[] mom;
	private String[] player;
	private String[] catches;
	private String[] isWktKeeper;
	private String[] hattrick;
	private String[] sixesCount;
	private String[] directHits;
	private String[] collabRunOuts;
	
	/**
	 * @return the directHits
	 */
	public String[] getDirectHits()
	{
		return directHits;
	}

	/**
	 * @param directHits the directHits to set
	 */
	public void setDirectHits(String[] directHits)
	{
		this.directHits = directHits;
	}

	/**
	 * @return the collabRunOuts
	 */
	public String[] getCollabRunOuts()
	{
		return collabRunOuts;
	}

	/**
	 * @param collabRunOuts the collabRunOuts to set
	 */
	public void setCollabRunOuts(String[] collabRunOuts)
	{
		this.collabRunOuts = collabRunOuts;
	}

	/**
	 * @return the hattrick
	 */
	public String[] getHattrick()
	{
		return hattrick;
	}

	/**
	 * @param hattrick
	 *            the hattrick to set
	 */
	public void setHattrick(String[] hattrick)
	{
		this.hattrick = hattrick;
	}

	/**
	 * @return the sixesCount
	 */
	public String[] getSixesCount()
	{
		return sixesCount;
	}

	/**
	 * @param sixesCount
	 *            the sixesCount to set
	 */
	public void setSixesCount(String[] sixesCount)
	{
		this.sixesCount = sixesCount;
	}

	/**
	 * @return the catches
	 */
	public String[] getCatches()
	{
		return catches;
	}

	/**
	 * @param catches
	 *            the catches to set
	 */
	public void setCatches(String[] catches)
	{
		this.catches = catches;
	}

	/**
	 * @return the isWktKeeper
	 */
	public String[] getIsWktKeeper()
	{
		return isWktKeeper;
	}

	/**
	 * @param isWktKeeper
	 *            the isWktKeeper to set
	 */
	public void setIsWktKeeper(String[] isWktKeeper)
	{
		this.isWktKeeper = isWktKeeper;
	}

	public String[] getPlayer()
	{
		return player;
	}

	public void setPlayer(String[] player)
	{
		this.player = player;
	}

	public String[] getMom()
	{
		return mom;
	}

	public void setMom(String[] mom)
	{
		this.mom = mom;
	}

	public String[] getRuns()
	{
		return runs;
	}

	public void setRuns(String[] runs)
	{
		this.runs = runs;
	}

	public String[] getWickets()
	{
		return wickets;
	}

	public void setWickets(String[] wickets)
	{
		this.wickets = wickets;
	}

	public String[] getStumping()
	{
		return stumping;
	}

	public void setStumping(String[] stumping)
	{
		this.stumping = stumping;
	}

	public String[] getDuck()
	{
		return duck;
	}

	public void setDuck(String[] duck)
	{
		this.duck = duck;
	}

	public String getTeamwon()
	{
		return teamwon;
	}

	public void setTeamwon(String teamwon)
	{
		this.teamwon = teamwon;
	}
}
