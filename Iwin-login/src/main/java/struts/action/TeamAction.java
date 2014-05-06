package struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.hibernate.pojo.Team;

import services.ServiceFinder;
import struts.form.TeamForm;

public class TeamAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		TeamForm obj = (TeamForm) form;
		Team team = new Team();
		team.setName(obj.getTeam());
		 dao.hibernate.SpringHibernateDAO springHibernateDAO = (dao.hibernate.SpringHibernateDAO) ServiceFinder.getContext(request)
	  		.getBean("SpringHibernateDao");
		 springHibernateDAO.addTeam(team);
		 return mapping.findForward("success");
	}
}
