package struts.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import services.ServiceFinder;
import struts.form.UserRegisterForm;

import com.iwin.utility.MailerUtil;
import com.iwin.utility.PasswordGenerator;
import com.iwin.utility.UserAttribs;

import dao.hibernate.SpringHibernateDAO;
import dao.hibernate.pojo.User;

public class UserRegisterAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
//		final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@nttdata.com";
		final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		UserRegisterForm objForm = (UserRegisterForm) form;
		String forwardToPage = "input";
		String strError = "";
		String password = null;
		Map userHM = null;
		boolean validUsernameStatus = false;
		User pojoObj = null;
		SpringHibernateDAO springHibernateDAO = null;
		String tempEmaildress = null;
if (objForm.getEmailId()!=null && objForm.getEmailId().toLowerCase() !=null)
{
	tempEmaildress= objForm.getEmailId().toLowerCase();
}
		if (!tempEmaildress.matches(EMAIL_REGEX))
		{
			// Create object of ActionMesssages
			ActionMessages errors = new ActionMessages();

			errors.add("Please provide valid Mail Id ", new ActionMessage(
					"error.invalidEmail.invalid"));
			saveErrors(request, errors);

			return mapping.findForward("input");
		}
		
		password = PasswordGenerator.generatePassword(objForm.getEmailId());
		objForm.setEmailId(tempEmaildress);
		objForm.setPassword(password);

		try
		{
			springHibernateDAO = (SpringHibernateDAO) ServiceFinder.getContext(
					request).getBean("SpringHibernateDao");

			// Validating for duplicate Email Registration
			validUsernameStatus = springHibernateDAO.checkUserExists(null,
					objForm.getEmailId());

			System.out.println("Action -->" + objForm.getAction());
			System.out.println("ActionUpdate -- >"
					+ objForm.getActionUpdateData());
			
			// In case of form submit Add/Update the data
			if (objForm.getActionUpdateData().equals("update"))
			{
				// In case of Add, Add the data into database

				if (objForm.getAction().equals("add"))
				{
					if (!validUsernameStatus)
					{
						userHM = new HashMap();
						userHM.put(UserAttribs.EMAIL_ID, objForm.getEmailId());
						userHM.put(UserAttribs.PASSWORD, objForm.getPassword());
						userHM.put(UserAttribs.USERID, objForm.getUserid());
						
						try
						{
							System.out.println("Sending mail....");
							MailerUtil.sendMail(userHM);
							System.out.println("Mail has been sent....");
						}
						catch (Exception exp) 
						{
							ActionMessages errors = new ActionMessages();

							errors.add("Registration failed. Please try again!",
									new ActionMessage("error." +
									"registrationFailed.invalid"));
							saveErrors(request, errors);

							return mapping.findForward("input");
						}

						pojoObj = new User();

						pojoObj.setUserid(objForm.getUserid());
						pojoObj.setPassword(objForm.getPassword());
						pojoObj.setIsupport(objForm.getIsupport());
						pojoObj.setEmailId(objForm.getEmailId());
						// Add the data
						springHibernateDAO.addUser(pojoObj);

						forwardToPage = "success";
					}
					else
					{
						// Create object of ActionMesssages
						ActionMessages errors = new ActionMessages();

						errors.add("This email id is already is registered ",
								new ActionMessage(
										"error.duplicateEmailId.invalid"));
						saveErrors(request, errors);

						return mapping.findForward("input");
					}
				}
				// User updates the data, update the user details
				if (objForm.getAction().equals("update"))
				{
					pojoObj = springHibernateDAO.loadUser(objForm.getUserid());
					pojoObj.setUserid(objForm.getUserid());
					pojoObj.setPassword(objForm.getPassword());
					pojoObj.setIsupport(objForm.getIsupport());
					pojoObj.setEmailId(objForm.getEmailId());

					// Update the data
					springHibernateDAO.updateUser(pojoObj);
					forwardToPage = "updated";
				}
			}

			// In case of Edit retrieve the data from datbase and set the values
			// in the form obj
			if (objForm.getAction().equals("Edit"))
			{
				HttpSession session = request.getSession();
				String id = (String) session.getAttribute("ID");

				// Retrieve the data from database
				pojoObj = springHibernateDAO.loadUser(id);

				objForm.setUserid(pojoObj.getUserid());
				objForm.setPassword(pojoObj.getPassword());
				objForm.setIsupport(pojoObj.getIsupport());
				objForm.setEmailId(pojoObj.getEmailId());
				// for the edit form
				forwardToPage = "input";
				// Set the action to update
				objForm.setAction("update");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			forwardToPage = "input";
			strError = e.getMessage();
			System.out.println("===> Error:" + strError);
		}

		return mapping.findForward(forwardToPage);
	}
}
