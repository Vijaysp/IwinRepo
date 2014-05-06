/**
 * 
 */
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

/**
 * @author VSuriyakumar
 * Created On: 22-Apr-2014
 * 
 * TODO
 */
public class ForgotPasswordAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
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
		String tempEmaildress = objForm.getEmailId().toLowerCase();

		if (!tempEmaildress.matches(EMAIL_REGEX))
		{
			// Create object of ActionMesssages
			ActionMessages errors = new ActionMessages();

			errors.add("Please provide valid Mail Id ", new ActionMessage(
					"error.invalidEmail.invalid"));
			saveErrors(request, errors);

			return mapping.findForward("invalid");
		}
		
		password = PasswordGenerator.generatePassword(objForm.getEmailId());
		objForm.setPassword(password);
System.out.println("Password >>"+password);
		try
		{
			springHibernateDAO = (SpringHibernateDAO) ServiceFinder.getContext(
					request).getBean("SpringHibernateDao");

			// Validating for duplicate Email Registration
			validUsernameStatus = springHibernateDAO.checkUserExists(null,
					objForm.getEmailId());

			/*System.out.println("Action Forgot-->" + objForm.getAction());
			System.out.println("ActionUpdate -- >"
					+ objForm.getActionUpdateData());*/
			System.out.println("validUsernameStatus >>"+validUsernameStatus);
	 System.out.println("User ID >>"+objForm.getUserid());
					if (validUsernameStatus)
					{
						userHM = new HashMap();
						userHM.put(UserAttribs.EMAIL_ID, objForm.getEmailId());
						userHM.put(UserAttribs.PASSWORD, objForm.getPassword());
						userHM.put(UserAttribs.USERID, objForm.getUserid());
						
						try
						{
							System.out.println("Sending mail....");
							MailerUtil.sendMailForgotPassword(userHM);
							System.out.println("Mail has been sent....");
						}
						catch (Exception exp) 
						{
							ActionMessages errors = new ActionMessages();

							errors.add("Forgot Password failed. Please try again!",
									new ActionMessage("error." +
									"forgotpassword.invalid"));
							saveErrors(request, errors);

							return mapping.findForward("invalid");
						}
pojoObj=new User();
pojoObj.setPassword(objForm.getPassword());
pojoObj.setEmailId(objForm.getEmailId());
					/*	pojoObj = springHibernateDAO.loadUser(objForm.getEmailId());
						pojoObj.setPassword(objForm.getPassword());*/
						// Add the data
						springHibernateDAO.updatePassword(pojoObj);

						forwardToPage = "updated";
					}
					else
					{
						// Create object of ActionMesssages
						ActionMessages errors = new ActionMessages();

						errors.add("This email id is already not registered ",
								new ActionMessage(
										"error.notexistEmailId.invalid"));
						saveErrors(request, errors);

						return mapping.findForward("invalid");
					}
			 
		}
		catch (Exception e)
		{
			e.printStackTrace();
			forwardToPage = "invalid";
			strError = e.getMessage();
			System.out.println("===> Error:" + strError);
		}

		return mapping.findForward(forwardToPage);
	}

}
