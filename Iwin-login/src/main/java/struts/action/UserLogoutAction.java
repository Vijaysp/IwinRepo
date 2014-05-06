/**
 * 
 */
package struts.action;

import java.util.ArrayList;
import java.util.HashMap;

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
import struts.form.UserLoginForm;

/**
 * @author VSuriyakumar Created On: 21-Apr-2014
 * 
 *         TODO
 */
public class UserLogoutAction extends Action
{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		dao.hibernate.SpringHibernateDAO springHibernateDAO = (dao.hibernate.SpringHibernateDAO) ServiceFinder
				.getContext(request).getBean("SpringHibernateDao");

		// Create object of ActionMesssages
		ActionMessages errors = new ActionMessages();

		UserLoginForm objForm = (UserLoginForm) form;


		HttpSession session = request.getSession();
		if (session.getAttribute("userID") != null)
		{
			session.removeAttribute("userID");
		}

		if (session.getAttribute("ID") != null)
		{
			session.removeAttribute("ID");
		}
		if (session.getAttribute("eligibleMatches") != null)
		{
			session.removeAttribute("eligibleMatches");
		}
		if (session.getAttribute("players") != null)
		{
			session.removeAttribute("players");
		}
		if (session.getAttribute("allmatches") != null)
		{
			session.removeAttribute("allmatches");
		}
		return mapping.findForward("success");
	}

}
