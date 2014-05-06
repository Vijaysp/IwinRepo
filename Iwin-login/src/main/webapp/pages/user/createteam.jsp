
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ page
	import="java.util.ArrayList, java.util.Iterator, dao.hibernate.pojo.Match, java.text.SimpleDateFormat,java.util.HashMap"%>

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

	<html:form action="/team" method="post">
		<table width="50%" border="0" class="table" align="center">
			<tr>
				<th class="loginTr">Mention the team</th>
			</tr>

			<tr class="userPass">
				<td align="center" class="userPass"><html:text property="team"
						styleClass="textbox">
					</html:text><br></td>
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
