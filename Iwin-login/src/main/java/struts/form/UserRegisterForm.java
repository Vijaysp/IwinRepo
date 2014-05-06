package struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class UserRegisterForm extends ActionForm
{
	private String action = "add";
	private String actionUpdateData;
	private String userid;
	private String password;
	private String isupport;
	private String emailId;

	public String getAction()
	{
		return action;
	}

	public String getEmailId()
	{
		return emailId;
	}

	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}

	public void setAction(String action)
	{
		this.action = action;
	}

	public String getActionUpdateData()
	{
		return actionUpdateData;
	}

	public void setActionUpdateData(String actionUpdateData)
	{
		this.actionUpdateData = actionUpdateData;
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

	public void reset(ActionMapping mapping, HttpServletRequest request)
	{
		this.userid = null;
		this.password = null;

		this.action = "add";
		this.actionUpdateData = "";
		this.isupport = null;
		this.emailId = null;
	}

	public ActionErrors validate(

	ActionMapping mapping, HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();

		return errors;
	}
}
