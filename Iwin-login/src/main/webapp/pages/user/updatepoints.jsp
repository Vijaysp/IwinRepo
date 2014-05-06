
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ page import="java.util.StringTokenizer"%>
<html:html locale="true">

<head>

<title>Predict and Enjoy!!</title>
<html:base />
</head>
<%
	String chosenMatch = (String) session
				.getAttribute("chosenMatchID");
		String team1 = chosenMatch.substring(
				chosenMatch.indexOf(" - ") + 3,
				chosenMatch.indexOf(" vs "));
		String team2 = chosenMatch.substring(chosenMatch
				.indexOf(" vs ") + 4);
		ArrayList momList = (ArrayList) session.getAttribute("momList");
%>
<body bgcolor="#e6ffe5">
	<%@ include file="../topadmin.jsp"%>
	<center>

		<p>
			<b>Update Points</b>
		</p>
	</center>

	<html:form action="/points" method="post">
		<table width="64%" border="1" align="center">
			<tr>
				<th><%=session.getAttribute("chosenMatchID")%></th>
			</tr>
			<tr>
				<td align="center">Choose the team that won: <html:select
						property="teamwon">
						<option><%=team1%></option>
						<option><%=team2%></option>
					</html:select>
				</td>
			</tr>
		</table>

		<table width="50%" border="1" align="center">
			<tr>
				<th>Player</th>
				<th>Runs</th>
				<th>No. of 6s</th>
				<th>Wickets</th>
				<th>Catches</th>
				<th>Stumping</th>
				<th>Direct Hits</th>
				<th>Collab Run Outs</th>
				<th>Wicket-Keeper</th>
				<th>Hat-trick</th>
				<th>Ducks</th>
				<th>MOM</th>
			</tr>
			<%
				if (momList != null)
				{
					Iterator momItr = momList.iterator();
					String mom = null;
					String duck = "duck[";
					String close = "]";
					int i = 0;
					
					while (momItr.hasNext())
					{
						mom = (String) momItr.next();
			%>
			<tr>
				<td><input type="hidden" name="player" value='<%=mom%>' /><%=mom%></td>

				<td><html:text property="runs"></html:text></td>
				<td><html:text property="sixesCount"></html:text></td>
				<td><html:text property="wickets"></html:text></td>
				<td><html:text property="catches"></html:text></td>
				<td><html:text property="stumping"></html:text></td>
				<td><html:text property="directHits"></html:text></td>
				<td><html:text property="collabRunOuts"></html:text></td>
				<td><html:select property="isWktKeeper">
						<option>No</option>
						<option>yes</option>
					</html:select></td>
				<td><html:select property="hattrick">
						<option>No</option>
						<option>yes</option>
					</html:select></td>
				<td><html:select property="duck">
						<option>Not Applicable</option>
						<option>Duck</option>
						<option>Golden Duck</option>
					</html:select></td>
				<td><html:select property="mom">
						<option>Not Applicable</option>
						<option>MoM</option>
					</html:select>
			</tr>
			<%
						i++;
					}
				}
			
			ArrayList<String> userPlayerCol = springHibernateDAO.getPlayersListFromUserTeams();
			
			System.out.println("userPlayerCol.size: "+userPlayerCol.size());
			
			for (int i =0; i < userPlayerCol.size(); i++)
			{
				System.out.println((i+1)+"."+userPlayerCol.get(i));
			}
			
			%>
		</table>

		<center>
			<html:submit>Save</html:submit>
		</center>
	</html:form>
</body>
</html:html>
