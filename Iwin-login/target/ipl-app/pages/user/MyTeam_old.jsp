
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ page
	import="java.util.ArrayList,java.util.Iterator,java.text.SimpleDateFormat,java.util.HashMap"%>

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
	{
	%>
	<%@ include file="../top.jsp"%>
	<%
	}
	%>

	<html:form action="/myTeam" method="post">
		<input type="hidden" name="userid"
			value="<%=(String) session.getAttribute("userID")%>" />

		<table border="0" class="table" align="center">
			<tr>
				<td align="center" class="loginTr">My Fantasy Team</td>
			</tr>

			<tr>
				<table border="0" class="table" align="center">
					<br>
					<%
					String warningMsg = null;
					System.out.println("Warning Message: "+request.getAttribute("WARN_MSG"));
					if ((String)request.getAttribute("WARN_MSG") != null)
					{
						warningMsg = (String)request.getAttribute("WARN_MSG");
						
						request.setAttribute("WARN_MSG", null);
					}
					%>

					<%
					if (warningMsg != null)
					{
					%>
					<tr>
						<td>
							<table align="center" border="0">
								<tr>
									<td class="errorMessage">
										<%out.print(warningMsg);%>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<%
					}
					%>

					<%
					SpringHibernateDAO springHibDAO = 
							(dao.hibernate.SpringHibernateDAO) ServiceFinder
							.getContext(request).getBean("SpringHibernateDao");
				
					HashMap<String, String> selectPlayersHM = null;
					ArrayList playOffteamsCol = new ArrayList<String>();
					playOffteamsCol.add("CHENNAI SUPER KINGS");
					playOffteamsCol.add("MUMBAI INDIANS");
					playOffteamsCol.add("RAJASTHAN ROYALS");
					playOffteamsCol.add("SUNRISERS HYDERABAD");
					
					ArrayList availablePlayersCol = null;
					
					availablePlayersCol = springHibDAO.getPlayersForPlayOff(
							playOffteamsCol);
					
					System.out.println("userId: "+(String)session.getAttribute("userID") +" and size of availablePlayersCol: "+availablePlayersCol.size());
					
					UserTeam userTeam = springHibDAO.checkUserTeamExist(
							(String)session.getAttribute("userID"));
					
					if (userTeam != null)
					{
						selectPlayersHM = new HashMap<String, String>();
						
						selectPlayersHM.put("teamName", userTeam.getTeamName());
						selectPlayersHM.put("player1", userTeam.getPlayer1());
						selectPlayersHM.put("player2", userTeam.getPlayer2());
						selectPlayersHM.put("player3", userTeam.getPlayer3());
						selectPlayersHM.put("player4", userTeam.getPlayer4());
						selectPlayersHM.put("player5", userTeam.getPlayer5());
						selectPlayersHM.put("player6", userTeam.getPlayer6());
						selectPlayersHM.put("player7", userTeam.getPlayer7());
						selectPlayersHM.put("player8", userTeam.getPlayer8());
						selectPlayersHM.put("player9", userTeam.getPlayer9());
						selectPlayersHM.put("player10", userTeam.getPlayer10());
						selectPlayersHM.put("player11", userTeam.getPlayer11());
						selectPlayersHM.put("substitute", userTeam.
								getSubstitute());
					}
					
					%>
					<tr>
						<td class="userPass" align="right">My team name<span
							class="astericks">*</span></td>
						<td>
							<%
							if (selectPlayersHM != null)
							{
								String teamname = selectPlayersHM.get("teamName");
							%> <html:text property="teamName" size="75" maxlength="75"
								value="<%=teamname%>" styleClass="textBoxLarge" /> <%
							}
							else
							{
							%> <html:text property="teamName" size="75" maxlength="75"
								styleClass="textBoxLarge" /> <%
							}
							%>
						</td>
					</tr>

					<%
					for (int j = 1; j <= 11; j++)
					{
						String propValue = "player"+j;
					%>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td class="userPass" align="right"><%=propValue%> <span
							class="astericks">*</span></td>

						<td class="bgTr3Small" align="left"><html:select
								property="<%=propValue%>" styleClass="listMenu">
								<%
								
								if (availablePlayersCol != null 
										&& !availablePlayersCol.isEmpty()) 
								{
								for (int i = 0; i < availablePlayersCol.
										size(); i++)
								{
									if (selectPlayersHM != null 
											&& availablePlayersCol.get(i) != null 
											&& ((String)availablePlayersCol.
											get(i)).trim().equals(
											selectPlayersHM.get(propValue)))
									{
									%>
								<option selected="selected">
									<%=(String) availablePlayersCol.
												get(i)%>
								</option>
								<%
										continue;
									}
									else
									{
									%>
								<option>
									<%=(String) availablePlayersCol.
												get(i)%>
								</option>
								<%
									}
								} }
								%>
							</html:select></td>
					</tr>
					<%
					}
					%>

					<tr>
						<td class="userPass" align="right">Substitute <span
							class="astericks">*</span></td>

						<td class="bgTr3Small" align="left"><html:select
								property="substitute" styleClass="listMenu">
								<%
							if (availablePlayersCol != null 
									&& !availablePlayersCol.isEmpty()) 
							{
							for (int i = 0; i < availablePlayersCol.
									size(); i++)
							{
								if (selectPlayersHM != null && 
										availablePlayersCol.get(i) != null && 
										((String)availablePlayersCol.get(i))
										.trim().equals(selectPlayersHM.
										get("substitute")))
								{
								%>
								<option selected="selected">
									<%=(String) availablePlayersCol.
											get(i)%>
								</option>
								<%
									continue;
								}
								else
								{
								%>
								<option>
									<%=(String) availablePlayersCol.
											get(i)%>
								</option>
								<%
								}
							}}
							%>
							</html:select></td>
					</tr>
				</table>
			</tr>
			<tr>
				<table border="0" cellspacing="0" cellpadding="0" class="buttons"
					align="center">
					<tr>
						<td><br /> <input type="submit" name="submitBtn"
							class="groovybutton" value="Submit" title=""></td>
					</tr>
				</table>
			</tr>
		</table>

		<table>


		</table>


	</html:form>
</body>
</html:html>