
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
	<html:form action="/player" method="post">
		<%@ include file="../topadmin.jsp"%>

		<table width="50%" border="1" class="signup" align="center">
			<tr>
				<th>Please enter required details</th>
			</tr>
			<tr>
				<td align="center"><font size="4" color="#660099">Player
						Name: <html:text property="name" />
				</font><br></td>
			</tr>
			<tr>
				<td align="center"><font size="4" color="#660099">Category:
						<html:select property="category">
							<option>Batsmen</option>
							<option>Bowler</option>
							<option>All-rounder</option>
							<option>Wicket-keeper</option>
						</html:select>
				</font><br></td>
			</tr>
			<tr>
				<td align="center"><font size="4" color="#660099">Team:
						<html:select property="team"><%=(String) session.getAttribute("teamtag")%>
						</html:select>
				</font><br></td>
			</tr>
			<tr>
				<td align="center"><html:submit>Create</html:submit></td>
			</tr>
		</table>
	</html:form>
	<%
	}
	%>
</body>
</html:html>
