
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
	<%
		}
		else
		{%>
	<%@ include file="../top.jsp"%>
	<%} %>
	<html:form action="/userPrediction" method="post">

		<input type="hidden" name="userid"
			value="<%=(String) session.getAttribute("userID")%>" />
		<table border="1" class="table" align="center">
			<tr>
				<th class="bgTr5Small">Match Number</th>
				<th class="bgTr5Small">Match Date</th>
				<th class="bgTr5Small">Choose Winning Team</th>
				<th class="bgTr5Small">Choose Man Of The Match</th>
				<th class="bgTr5Small">Venue</th>
			</tr>

			<%
				String user = (String) session.getAttribute("userID");
				Prediction predict = null;
		
				if (user != null)
				{
					dao.hibernate.SpringHibernateDAO springHibernateDAO = 
						(dao.hibernate.SpringHibernateDAO) ServiceFinder
						.getContext(request).getBean("SpringHibernateDao");
					
					ArrayList pred = springHibernateDAO
							.getUserPredictions(user);
		
					Iterator predItr = null;
			%>

			<%
				ArrayList matches = null;

			    matches = (ArrayList) session.getAttribute("eligibleMatches");
			    HashMap players = (HashMap) session.getAttribute("players");
			    
				if (matches == null || matches.isEmpty())				
				{
					matches = springHibernateDAO.getEligibleMatches(null);
					
					players = springHibernateDAO.getPlayers();
					session.setAttribute("eligibleMatches", matches);
					session.setAttribute("players", players);
				}
				
				ArrayList playerNames = null;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat display = new SimpleDateFormat("dd-MM-yyyy");
				
				if (matches != null)
				{
					Iterator matchItr = matches.iterator();
					
					while (matchItr.hasNext())
					{
						Match match = (Match) matchItr.next();
						predict = null;
						
						if (pred != null && !pred.isEmpty())
						{
							predItr = pred.iterator();
							
							while (predItr.hasNext())
							{
								predict = (Prediction) predItr.next();
								
								String predictedMatchId = predict.getMatchid().
										substring(0, predict.getMatchid().
										indexOf("~"));

								if (predictedMatchId.equals(match.getMatchid()))
								{	
									break;
								}
							}
						}
			%>

			<SCRIPT LANGUAGE=javascript>
			
			</script>

			<!-- Added for avoiding save at match time - Start-->
			<tr>
				<td align="center" colspan="2"><font color="red"> <html:errors /></td>

			</tr>
			<!-- Added for avoiding save at match time - End-->
			<tr>
				<td class="bgTr3Small" align="center"><input type="hidden"
					name="matchid" value="<%=match.getMatchid()%>" /> <%=match.getMatchid()%>

					<br></td>
				<td class="bgTr3Small" align="left" width="20%">
					<center>
						<input type="hidden" name="matchdate"
							value="<%=sdf.format(match.getMatchDate())%>" />
						<%=display.format(match.getMatchDate())%>
					</center>
				</td>
				<td class="bgTr3Small" align="left"><html:select
						property="winteam" styleClass="listMenu">
						<% 
						boolean winningTeamMatched = false; 
						
						if (predict != null)
						{
							if (predict.getWinningTeam().equals(
									match.getTeam1()))
							{
								winningTeamMatched = true;
							%>
						<option selected="selected">
							<%=match.getTeam1()%>
						</option>
						<option><%=match.getTeam2()%></option>
						<%
							}
							else if (predict.getWinningTeam().equals(
									match.getTeam2()))
							{
								winningTeamMatched = true;
								%>

						<option><%=match.getTeam1()%></option>
						<option selected="selected">
							<%=match.getTeam2()%>
						</option>
						<%
							}
						}
						
						if (!winningTeamMatched)
						{
						%>
						<option><%=match.getTeam1()%></option>
						<option><%=match.getTeam2()%></option>
						<%
						}
						%>
					</html:select></td>
				<%
					if (players != null)
					{
				%>
				<td class="bgTr3Small" align="left"><html:select property="mom"
						styleClass="listMenuLarge">
						<%
						playerNames = (ArrayList) players.get(match.getTeam1());

						if (playerNames != null)
						{
							for (int i = 0; i < playerNames.size(); i++)
							{
								if (predict != null && (((String)playerNames.
										get(i)).trim()).equals(predict.getMom()))
								{
						%>
						<option selected="selected">
							<%=(String) playerNames.get(i)%>
						</option>
						<%
								}
								else
								{
						%>
						<option>
							<%=(String) playerNames.get(i)%>
						</option>
						<%
								}
							}
						}
						%>
						<%
						playerNames = (ArrayList) players.get(match.getTeam2());

						if (playerNames != null)
						{
							for (int i = 0; i < playerNames.size(); i++)
							{
								if (predict != null 
										&& (((String)playerNames.get(i)).trim())
										.equals(predict.getMom()))
								{
						%>
						<option selected="selected">
							<%=(String) playerNames.get(i)%>
						</option>
						<%
								}
								else
								{
						%>
						<option>
							<%=(String) playerNames.get(i)%>
						</option>
						<%
								}
							}
						}
						%>
					</html:select></td>
				<%
					}
				%>

				<td class="bgTr3Small" align="left"><%=match.getVenue()%></td>
			</tr>
			<%
				}
			}
		}
			%>
		</table>
		<br>
		<br>
		<center>
			<html:submit>Save</html:submit>
		</center>

	</html:form>
</body>
</html:html>
