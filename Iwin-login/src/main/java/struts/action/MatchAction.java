package struts.action;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import services.ServiceFinder;
import struts.form.MatchForm;
import dao.hibernate.pojo.Match;

public class MatchAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		MatchForm obj = (MatchForm) form;
		Match match = new Match();
		dao.hibernate.SpringHibernateDAO springHibernateDAO = (dao.hibernate.SpringHibernateDAO) ServiceFinder.getContext(request)
	  		.getBean("SpringHibernateDao");
		long count = springHibernateDAO.getMaxMatchID();
		match.setMatchid(""+count);
		
		if (obj.getMatchdate() != null && !obj.getMatchdate().equals(""))
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			try
			{
				match.setMatchDate(new Timestamp(sdf.parse(obj.getMatchdate()).getTime()));
			}
			catch (ParseException pe)
			{
				return mapping.findForward("input");
			}
		}
		else
		{
			return mapping.findForward("input");
		}
		
		if (obj.getFirstteam().equals(obj.getSecondteam()))
		{
			return mapping.findForward("input");
		}
		
		match.setTeam1(obj.getFirstteam());
		match.setTeam2(obj.getSecondteam());
		match.setVenue(obj.getVenue());
		springHibernateDAO.addMatch(match);
		
		return mapping.findForward("success");
	}
}
