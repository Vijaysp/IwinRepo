<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<html:html locale="true">

<head>
<title>Predict and Enjoy!!</title>
<html:base />
</head>


<body bgcolor="#e6ffe5" onload="javascript:blinkFont('blinkDiv');">
	<%@ include file="top.jsp"%>

	<script language="JavaScript" type="text/javascript">
	function blinkFont(blinkId) 
	{	
	  document.getElementById(blinkId).style.color="red"
  	  setTimeout("setblinkFont('"+blinkId+"')",500)
	}
	
	function setblinkFont(blinkId)
	{
  	  document.getElementById(blinkId).style.color=""
  	  setTimeout("blinkFont('"+blinkId+"')",500)
	}
</script>

	<FONT SIZE="4"><div id="blinkDiv" align="center">Here is
			a chance to topple the leaders in the points table. Become a
			franchise and pick your team using MyTeam Link. Please check for
			Rules for more details!</div></FONT>

	<logic:notPresent name="org.apache.struts.action.MESSAGE"
		scope="application">
		<font color="red"> ERROR: Application resources not loaded --
			check servlet container logs for error messages. </font>
	</logic:notPresent>
	<%
		String user = (String) session.getAttribute("userID");
			Prediction predict = null;

			if (user != null)
			{
				ArrayList pred = springHibernateDAO
						.getUserPredictions(user);

				if (pred != null && !pred.isEmpty())
				{
					Iterator predItr = pred.iterator();
	%>
	<%
			SpringHibernateDAO sprHibDAO1 = (SpringHibernateDAO) ServiceFinder
					.getContext(request).getBean("SpringHibernateDao");
			
			Calendar cal = Calendar.getInstance();
			
			cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
			Date fromDate = cal.getTime();

			cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
			Date fromDate1 = cal.getTime();
		
			cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
			Date fromDate2 = cal.getTime();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			
			ArrayList tempList = sprHibDAO1.getBestPrediction(sdf.format(fromDate), null);
			ArrayList tempList1 = sprHibDAO1.getBestPrediction(sdf.format(fromDate1), null);
			ArrayList tempList2 = sprHibDAO1.getBestPrediction(sdf.format(fromDate2), null);
			
			Scorecard bestScoreCard = null;
			
			ArrayList scorecardColl = new ArrayList();
			scorecardColl.addAll(tempList2);
			scorecardColl.addAll(tempList1);
			scorecardColl.addAll(tempList);
			
			if (scorecardColl != null)
			{
				if (scorecardColl.size() > 2)
				{
				%>
	<center>
		<h3>Best predictions of the weekend</h3>
	</center>
	<%
				}
				else if (scorecardColl.size() > 1 && scorecardColl.size() < 3)
				{
				%>
	<center>
		<h3>Best predictions of the day</h3>
	</center>
	<%
				}
				else{
				%>
	<center>
		<h3>Best prediction of the day</h3>
	</center>
	<%
				}
				
				Iterator scoreCardIter = scorecardColl.iterator();
			%>

	<table border="1" class="table" align="center">
		<tr>
			<th class="bgThSmall1">Match Number</th>
			<th class="bgThSmall1">Match Date</th>
			<th class="bgThSmall1">Player</th>
			<th class="bgThSmall1">Runs</th>
			<th class="bgThSmall1">Wickets</th>
			<th class="bgThSmall1">Catches</th>
			<th class="bgThSmall1">Stumpings</th>
			<th class="bgThSmall1">Kept Wickets</th>
			<th class="bgThSmall1">HatTrick</th>
			<th class="bgThSmall1">No.of 6s</th>
			<th class="bgThSmall1">won MoM</th>
			<th class="bgThSmall1">Duck or GoldenDuck</th>
			<th class="bgThSmall1">Points Earned</th>
		</tr>
		<%
				while (scoreCardIter.hasNext())
				{
					bestScoreCard = (Scorecard) scoreCardIter.next();
				%>
		<tr>
			<td class="bgTr3Small" align="center"><%=bestScoreCard.getMatchid() %></td>
			<td class="bgTr3Small" align="center"><%=bestScoreCard.getMatchDate() %></td>
			<td class="bgTr3Small"><%=bestScoreCard.getPlayerName() %></td>
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

	<%
			if ((String)session.getAttribute("warning") != null)
			{
		%>
	<h4 align="center">
		Warning: <font color="blue"> <% out.print((String)session.getAttribute("warning"));%>
		</font>
	</h4>
	<%	
				session.setAttribute("warning", null);
			}
		%>
	<br>
	<br>
	<center>
		<h3>Your predictions</h3>
	</center>

	<table width="60%" border="1" class="table" align="center">
		<tr>
			<th class="bgTr5Small">Match Number</th>
			<th class="bgTr5Small">Match Date</th>
			<th class="bgTr5Small">Chosen Team</th>
			<th class="bgTr5Small">Chosen Player</th>
			<th class="bgTr5Small">Points Earned</th>
		</tr>
		<%
					while (predItr.hasNext())
					{
						predict = (Prediction) predItr.next();
				%>
		<tr>
			<td class="bgTr3Small" align="center" width="10%"><%=predict.getMatchid().substring(0,
													predict.getMatchid().indexOf("~"))%></td>
			<td class="bgTr3Small" align="center" width="AUTO"><%=predict.getMatchDate()%></td>
			<td class="bgTr3Small" align="left" width="AUTO" nowrap><%=predict.getWinningTeam()%></td>
			<td class="bgTr3Small" align="left" width="AUTO" nowrap><%=predict.getMom()%></td>
			<td class="bgTr3Small" align="center" width="10%"><%=predict.getPoints()%></td>
		</tr>
		<%
					}
				}
			}
			else
			{
			%>

		<br>
		<br>
		<CENTER>
			<img border="0" align="center" src="Logos/IPL.jpg" alt="All teams" />
			</a>
		</CENTER>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>

		<center>
			<h3>
				<u>Teams</u>
			</h3>

			<a
				href="http://www.espncricinfo.com/ipl2014_auction/content/site/ipl2014_auction/index.html"
				target="blank"> <img width="8%" height="10%" border="0"
				align="center" src="Logos/CSK.jpg"
				ondragover="Click me to check the squad!" alt="Chennai Super Kings" />
			</a> <a
				href="http://www.espncricinfo.com/ipl2014_auction/content/site/ipl2014_auction/index.html"
				target="blank"> <img width="8%" height="10%" border="0"
				align="center" src="Logos/MI.jpg" alt="Mumbai Indians" />
			</a> <a
				href="http://www.espncricinfo.com/ipl2014_auction/content/site/ipl2014_auction/index.html"
				target="blank"> <img align="middle" src="Logos/DD.jpg"
				border="0" width="8%" height="9%" alt="Delhi Daredevils" />
			</a> 
			</a> <a
				href="http://www.espncricinfo.com/ipl2014_auction/content/site/ipl2014_auction/index.html"
				target="blank"> <img align="middle" src="Logos/RR.jpg"
				border="0" width="8%" height="10%" alt="Rajasthan Royals" />
			</a> <a
				href="http://www.espncricinfo.com/ipl2014_auction/content/site/ipl2014_auction/index.html"
				target="blank"> <img align="middle" src="Logos/KKR.jpg"
				border="0" width="8%" height="10%" alt="Kolkotta Knoght Riders" />
			</a> <a
				href="http://www.espncricinfo.com/ipl2014_auction/content/site/ipl2014_auction/index.html"
				target="blank"> <img align="middle" src="Logos/SH.jpg"
				border="0" width="8%" height="10%" alt="Sunrisers Hyderabad" />
			</a> <a
				href="http://www.espncricinfo.com/ipl2014_auction/content/site/ipl2014_auction/index.html"
				target="blank"> <img align="middle" src="Logos/KXI.jpg"
				border="0" width="8%" height="10%" alt="Kings XI Punjab" />
			</a> <a
				href="http://www.espncricinfo.com/ipl2014_auction/content/site/ipl2014_auction/index.html"
				target="blank"> <img align="middle" src="Logos/RCB.jpg"
				border="0" width="7%" height="11%" alt="Royal Challengers Bangalore" />
			</a>
		</center>

		<%
			}
		%>
	</table>


</body>
</html:html>
