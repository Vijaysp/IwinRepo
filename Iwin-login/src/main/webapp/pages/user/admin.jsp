<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="services.ServiceFinder"%>
<%@page import="dao.hibernate.pojo.Scorecard"%>
<%@page import="dao.hibernate.SpringHibernateDAO"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ page
	import="java.util.ArrayList,java.util.Iterator,dao.hibernate.pojo.Match,java.text.SimpleDateFormat,java.util.HashMap"%>
<html:html locale="true">

<head>
<title>Predict and Enjoy!!</title>
<html:base />
</head>
<body bgcolor="#e6ffe5">
	<%
	if ("admin".equalsIgnoreCase((String) session
			.getAttribute("userID")))
	{
	%>
	<%@ include file="../topadmin.jsp"%>
	<html:form action="/admin" method="post">
		<table border="1" class="table" align="center">
			<tr>
				<th class="loginTr">Choose the match to update the points</th>
			</tr>
			<%
				ArrayList matches = (ArrayList) session
						.getAttribute("allmatches");

				if (matches != null)
				{
					Iterator matchItr = matches.iterator();
				%>
			<tr>
				<td align="center"><html:select styleClass="listMenu"
						property="chosenMatchID">
						<%
						while (matchItr.hasNext())
						{
							Match match = (Match) matchItr.next();
							%>
						<option><%=match.getMatchid() + " - "
								+ match.getTeam1() + " vs "
								+ match.getTeam2()%></option>
						<%
						}
					%>
					</html:select> <br></td>
			</tr>
			<%
				}
			%>
		</table>

		<center>
			<html:submit>Next</html:submit>
		</center>

		<br>
		<br>

		<%
			SpringHibernateDAO sprHibDAO1 = (SpringHibernateDAO) ServiceFinder
					.getContext(request).getBean("SpringHibernateDao");
			
		
			Calendar cal = Calendar.getInstance();
			
			cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 2);
			
			Date myDate = cal.getTime();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			ArrayList scorecardColl = sprHibDAO1.getBestPrediction(
					sdf.format(myDate), null);
			Scorecard bestScoreCard = null;
			
			if (scorecardColl != null)
			{
				Iterator scoreCardIter = scorecardColl.iterator();
			%>

		<center>
			<h3>Best Prediction</h3>
		</center>
		<he>
		<table class="table" align="center" border="1">

			<tr>
				<th class="bgTr5Small">Match Number</th>
				<th class="bgTr5Small">Match Date</th>
				<th class="bgTr5Small">Player</th>
				<th class="bgTr5Small">Runs</th>
				<th class="bgTr5Small">Wickets</th>
				<th class="bgTr5Small">Catches</th>
				<th class="bgTr5Small">Stumpings</th>
				<th class="bgTr5Small">isWktKeeper</th>
				<th class="bgTr5Small">Hattrick</th>
				<th class="bgTr5Small">No.of 6s</th>
				<th class="bgTr5Small">won MoM</th>
				<th class="bgTr5Small">Duck or GoldenDuck</th>
				<th class="bgTr5Small">Points Earned</th>
			</tr>
			<%
				while (scoreCardIter.hasNext())
				{
					bestScoreCard = (Scorecard) scoreCardIter.next();					
				%>
			<tr>
				<td class="bgTr3Small" align="center"><%=bestScoreCard.getMatchid() %></td>
				<td class="bgTr3Small" align="center"><%=bestScoreCard.getMatchDate() %></td>
				<td class="bgTr3Small" align="center"><%=bestScoreCard.getPlayerName() %></td>
				<td class="bgTr3Small" align="center"><%=bestScoreCard.getRunsScored() %></td>
				<td class="bgTr3Small" align="center"><%=bestScoreCard.getWicketsTaken() %></td>
				<td class="bgTr3Small" align="center"><%=bestScoreCard.getCatchesHeld() %></td>
				<td class="bgTr3Small" align="center"><%=bestScoreCard.getStumpings() %></td>
				<td class="bgTr3Small" align="center"><%=bestScoreCard.getIsWicketKeeper() %></td>
				<td class="bgTr3Small" align="center"><%=bestScoreCard.getIsHattrick() %></td>
				<td class="bgTr3Small" align="center"><%=bestScoreCard.getSixes() %></td>
				<td class="bgTr3Small" align="center"><%=bestScoreCard.getWonMoM() %></td>
				<td class="bgTr3Small" align="center"><%=bestScoreCard.getDuckOrGD() %></td>
				<td class="bgTr3Small" align="center"><%=bestScoreCard.getPoints() %></td>
			</tr>
			<%
				}
			}
			%>
		</table>

		<br>
		<br>
		<br>
		<br>

		<%
			SpringHibernateDAO sprHibDAO = (SpringHibernateDAO) ServiceFinder
					.getContext(request).getBean("SpringHibernateDao");
			
			ArrayList scorecardCol = sprHibDAO.getScorecard();
			Scorecard scorecard = null;
			
			if (scorecardCol != null)
			{
				Iterator scoreCardItr = scorecardCol.iterator();
			%>

		<center>
			<h3>Prediction score</h3>
		</center>
		<he>
		<table border="1" class="table" align="center">

			<tr>
				<th class="bgTr5Small">Match Number</th>
				<th class="bgTr5Small">Match Date</th>
				<th class="bgTr5Small">Player</th>
				<th class="bgTr5Small">Runs</th>
				<th class="bgTr5Small">Wickets</th>
				<th class="bgTr5Small">Catches</th>
				<th class="bgTr5Small">Stumpings</th>
				<th class="bgTr5Small">isWktKeeper</th>
				<th class="bgTr5Small">Hattrick</th>
				<th class="bgTr5Small">No.of 6s</th>
				<th class="bgTr5Small">won MoM</th>
				<th class="bgTr5Small">Duck or GoldenDuck</th>
				<th class="bgTr5Small">Points Earned</th>
			</tr>
			<%
				while (scoreCardItr.hasNext())
				{
					scorecard = (Scorecard) scoreCardItr.next();
				%>
			<tr>
				<td class="bgTr3Small" align="center"><%=scorecard.getMatchid() %></td>
				<td class="bgTr3Small" align="center"><%=scorecard.getMatchDate() %></td>
				<td class="bgTr3Small" align="center"><%=scorecard.getPlayerName() %></td>
				<td class="bgTr3Small" align="center"><%=scorecard.getRunsScored() %></td>
				<td class="bgTr3Small" align="center"><%=scorecard.getWicketsTaken() %></td>
				<td class="bgTr3Small" align="center"><%=scorecard.getCatchesHeld() %></td>
				<td class="bgTr3Small" align="center"><%=scorecard.getStumpings() %></td>
				<td class="bgTr3Small" align="center"><%=scorecard.getIsWicketKeeper() %></td>
				<td class="bgTr3Small" align="center"><%=scorecard.getIsHattrick() %></td>
				<td class="bgTr3Small" align="center"><%=scorecard.getSixes() %></td>
				<td class="bgTr3Small" align="center"><%=scorecard.getWonMoM() %></td>
				<td class="bgTr3Small" align="center"><%=scorecard.getDuckOrGD() %></td>
				<td class="bgTr3Small" align="center"><%=scorecard.getPoints() %></td>
			</tr>
			<%
				}
			}
			%>
		</table>
	</html:form>
	<%
	}
	%>
</body>
</html:html>
