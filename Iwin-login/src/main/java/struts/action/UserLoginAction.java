package struts.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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
import dao.hibernate.pojo.Match;

public class UserLoginAction extends Action
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

		String strUserid = objForm.getUserid();
		ArrayList matches = null;
		HashMap players = null;

		String strPassword = objForm.getPassword();
		boolean loginStatus = springHibernateDAO.checkUserLogin(strUserid,
				strPassword);
		
		if (loginStatus)
		{
			HttpSession session = request.getSession();
			session.setAttribute("userID", strUserid);

			// int id =springHibernateDAO.getUserId(strUserid);

			String id = springHibernateDAO.getUserId(strUserid);

			// Integer idvalue=new Integer(id);

			session.setAttribute("ID", id);

			matches = springHibernateDAO.getEligibleMatches(null);
			players = springHibernateDAO.getPlayers();
			session.setAttribute("eligibleMatches", matches);
			matches = springHibernateDAO.getMatches();
			session.setAttribute("players", players);
			session.setAttribute("allmatches", matches);

			return mapping.findForward("success");
		}
		else
		{
			// not allowed
			errors.add("login", new ActionMessage("error.login.invalid"));
			saveErrors(request, errors);

			return mapping.findForward("failure");
		}
	}

}
