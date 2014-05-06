package struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import services.ServiceFinder;
import struts.form.PlayerForm;

import dao.hibernate.pojo.Player;

public class PlayerAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PlayerForm obj = (PlayerForm) form;
		Player player = new Player();
		
		if (obj.getName() != null && !obj.getName().equals(""))
		{
			player.setCategory(obj.getCategory());
			player.setName(obj.getName());
			player.setTeamname(obj.getTeam());
			dao.hibernate.SpringHibernateDAO springHibernateDAO = (dao.hibernate.SpringHibernateDAO) ServiceFinder.getContext(request)
	  		.getBean("SpringHibernateDao");
			springHibernateDAO.addPlayer(player);
			return mapping.findForward("success");
		}
		else
		{
			return mapping.findForward("input");
		}
	}
}
