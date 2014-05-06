package struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import services.ServiceFinder;
import struts.form.UserPredictionForm;
import dao.hibernate.pojo.Prediction;

public class UserPredictionAction extends Action 
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		HttpSession session = request.getSession();
		UserPredictionForm formObj = (UserPredictionForm) form;
		String[] matchID = formObj.getMatchid();
		String[] matchDate = formObj.getMatchdate();
		String[] winTeam = formObj.getWinteam();
		String[] player = formObj.getMom();
		int countOfMatches = 0;
		
		boolean validSaveActionInd = true;
		boolean displayWarningMsg = false;
		
		dao.hibernate.SpringHibernateDAO springHibernateDAO = (dao.hibernate.SpringHibernateDAO) ServiceFinder
				.getContext(request).getBean("SpringHibernateDao");		
		
		StringBuffer matchIDSb = new StringBuffer();
		
		final String WARNING_MSG_FRONT = "You have tried to save the prediction for the match ";
		
		final String WARNING_MSG_END = " after the match has started. " +
				"This prediction will not be saved. The remaining matching " +
				"if any will be updated with the current predictions!!";
		
		Prediction prediction = null;
		
		for (int i = 0; i < matchID.length; i++)
		{
			validSaveActionInd = true;
			validSaveActionInd = springHibernateDAO.checkIfValidSave(matchID[i]);
			
			if (!validSaveActionInd)
			{
				displayWarningMsg = true;
								
				if (countOfMatches > 1)
				{
					matchIDSb.append(" and ");
				}
				matchIDSb.append(matchID[i]);
				countOfMatches++;
				
				continue;
			}
			
			prediction = springHibernateDAO.checkPredictionExist(matchID[i], 
					formObj.getUserid());
			
			if (prediction == null)
			{
				prediction = new Prediction();
				prediction.setMatchDate(matchDate[i]);
				prediction.setMatchid(matchID[i]+"~"+formObj.getUserid());
				prediction.setMom(player[i]);
				prediction.setPoints(0);
				prediction.setUserid(formObj.getUserid());
				prediction.setWinningTeam(winTeam[i]);
				springHibernateDAO.createPrediction(prediction);
			}
			else
			{
				prediction.setMatchDate(matchDate[i]);
				prediction.setMatchid(matchID[i]+"~"+formObj.getUserid());
				prediction.setMom(player[i]);
				prediction.setPoints(0);
				prediction.setUserid(formObj.getUserid());
				prediction.setWinningTeam(winTeam[i]);	
				springHibernateDAO.updatePrediction(prediction);
			}
		}
		
		if (displayWarningMsg)
		{
			session.setAttribute("eligibleMatches", null);
			session.setAttribute("warning", WARNING_MSG_FRONT + matchIDSb
					+ WARNING_MSG_END);
		}
		
		return mapping.findForward("success");
	}
}
