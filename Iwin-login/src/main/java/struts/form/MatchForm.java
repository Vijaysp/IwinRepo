package struts.form;

import org.apache.struts.action.ActionForm;

public class MatchForm extends ActionForm
{
	private String firstteam;
	private String secondteam;
	private String matchdate;
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

	public String getMatchdate()
	{
		return matchdate;
	}

	public void setMatchdate(String matchdate)
	{
		this.matchdate = matchdate;
	}

	public String getFirstteam()
	{
		return firstteam;
	}

	public void setFirstteam(String firstteam)
	{
		this.firstteam = firstteam;
	}

	public String getSecondteam()
	{
		return secondteam;
	}

	public void setSecondteam(String secondteam)
	{
		this.secondteam = secondteam;
	}
}
