
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ page
	import="java.util.ArrayList, java.util.Iterator, dao.hibernate.pojo.Match, java.text.SimpleDateFormat,java.util.HashMap"%>

<html:html locale="true">

<head>
<SCRIPT LANGUAGE=javascript>

function validateForm(formObj)
{
	var RE_DATE = /[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9] [0-9][0-9]:[0-9][0-9]/;

	if(formObj.firstteam.value == formObj.secondteam.value)
	{
		alert("Please choose different teams!");
		formObj.firsteam.focus();
		return false;
	}

	if (!RE_DATE.test(formObj.matchdate.value))
	{	
		return false;
	}

	return true;
}
//-->
</SCRIPT>
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
	<html:form action="/match" method="post"
		onsubmit="return validateForm(this);">
		<table width="50%" border="1" class="signup" align="center">
			<tr>
				<th>Choose the teams</th>
			</tr>
			<tr>
				<td align="center"><font size="4" color="#660099">MatchDate:
						<html:text property="matchdate">
						</html:text>(yyyy-MM-dd hh:mm)
				</font> <br></td>
			</tr>
			<tr>
				<td align="center"><font size="4" color="#660099"> <html:select
							property="firstteam">
							<%= (String) session.getAttribute("teamtag") %>
						</html:select>
				</font> <br></td>
			</tr>
			<tr>
				<td align="center">VS</td>
			</tr>
			<tr>
				<td align="center"><font size="4" color="#660099"> <html:select
							property="secondteam">
							<%= (String) session.getAttribute("teamtag") %>
						</html:select></font><br></td>
			</tr>

			<tr>
				<td align="center"><font size="4" color="#660099">Venue:
						<html:select property="venue">
							<option>Eden Gardens, Kolkata</option>
							<option>Feroz Shah Kotla, Delhi</option>
							<option>Himachal Pradesh Cricket Association Stadium,
								Dharamsala</option>
							<option>International Cricket Stadium, Raipur</option>
							<option>JSCA International Stadium Complex, Ranchi</option>
							<option>M.Chinnaswamy Stadium, Bengaluru</option>
							<option>MA Chidambaram Stadium, Chennai</option>
							<option>Maharashtra Cricket Association Stadium, Pune</option>
							<option>Punjab Cricket Association Stadium, Mohali</option>
							<option>Rajiv Gandhi International Stadium, Hyderabad</option>
							<option>Sawai Mansingh Stadium, Jaipur</option>
							<option>Wankhede Stadium, Mumbai</option>
							<option>Sharjah Cricket Stadium</option>
							<option>Sheikh Zayed Stadium, Abu Dhabi</option> 
						</html:select>
				</font>
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
