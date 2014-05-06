package struts.action;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.hibernate.pojo.Prediction;
import services.ServiceFinder;
import struts.form.AdminForm;

public class AdminAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		AdminForm obj = (AdminForm)form;
		ArrayList predictions = null;
		ArrayList<String> momList = null;
		Iterator predItr = null;
		Prediction pred = null;
		String matchID = null;
		String chosenMatchID = obj.getChosenMatchID().substring(0, obj.getChosenMatchID().indexOf("-")).trim();
		System.err.println("Chosen Match ID-->"+obj.getChosenMatchID());
		session.setAttribute("chosenMatchID", obj.getChosenMatchID());
		
		 dao.hibernate.SpringHibernateDAO springHibernateDAO = (dao.hibernate.SpringHibernateDAO) ServiceFinder.getContext(request)
	  		.getBean("SpringHibernateDao");
		 predictions = springHibernateDAO.getPredictions();
		
		 if (predictions != null & !predictions.isEmpty())
		 {
			 predItr = predictions.iterator();
			 momList = new ArrayList<String>();
			 
			 while (predItr.hasNext())
			 {
				 pred = (Prediction) predItr.next();
				 matchID = pred.getMatchid().substring(0, pred.getMatchid().indexOf("~")); 
				 
				 if (chosenMatchID.equals(matchID))
				 {
					 if (!momList.contains(pred.getMom()))
						 momList.add(pred.getMom());
				 }
			 }
		 }
		 		 
		ArrayList<String> userPlayerCol = springHibernateDAO.getPlayersListFromUserTeams();
		String player = null;
		
		if (userPlayerCol != null & !userPlayerCol.isEmpty())
		 {
			 predItr = userPlayerCol.iterator();

			 while (predItr.hasNext())
			 {
				 player = (String)predItr.next();
						 
				  if (!momList.contains(player))
				  {
					  momList.add(player);
				  }
			 }
		 }
		
		session.setAttribute("momList", momList);
		session.setAttribute("allpredictions", predictions);
		return mapping.findForward("success");
	}
	
}
