package com.iwin.domain;

public class CdsUser
{
	private String userid;
	private String password;
	private String isupport;
	private String emailId;

	public String getEmailId()
	{
		return emailId;
	}

	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}

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
}
