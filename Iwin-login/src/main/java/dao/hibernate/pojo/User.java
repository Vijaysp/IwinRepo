package dao.hibernate.pojo;

public class User
{
	private String userid;
	private String password;
	private String isupport;
	private String emailId;

	public String getUserid()
	{
		return userid;
	}

	public void setUserid(String userid)
	{
		this.userid = userid;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getIsupport()
	{
		return isupport;
	}

	public void setIsupport(String isupport)
	{
		this.isupport = isupport;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId()
	{
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}
}
