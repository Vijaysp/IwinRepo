<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<html:html locale="true">
<head>
<title>Predict and Enjoy!!</title>
</head>
<html:base />
<body bgcolor="#e6ffe5">
<%
if (session.getAttribute("userID") != null)
{
	session.removeAttribute("userID");
	session.setAttribute("userID", null);
} %>
	<%@ include file="top.jsp"%>
	</script>

	<center>
		<br> <br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<table width="40%">
			<tr>
				<td><html:form focus="userid" action="/userlogin" method="post">
						<table cellspacing="0" cellpadding="1" width="100%" class="table">
							<tr>
								<td align="center" class="loginTr">Login<br>
								<font color="red"><html:errors /></td>
							</tr>
							<!-- display errors -->
							<tr>
								<table width="100%" cellpadding="5" cellspacing="0"
									class="table" align="center">
									<tr align="center">
										<td class="userPass" align="right">User ID<span
											class="astericks">*</span></td>
										<td><html:text property="userid" size="30" maxlength="30"
												styleClass="textbox" /></td>
									</tr>
									<tr align="center">
										<td class="userPass" align="right">Password <span
											class="astericks">*</span>
										</td>
										<td><html:password property="password" size="30"
												maxlength="30" styleClass="textbox" /></td>
									</tr>
								</table>
							</tr>
							<tr>
								<!--<td  align="center" colspan="2"><html:submit>Submit</html:submit></td>-->
								<table border="0" cellspacing="0" cellpadding="0"
									class="buttons">
									<tr>
										<td><br /> <input type="submit" name="loginBtn"
											class="groovybutton" value="Login" title=""></td>
									</tr>
								</table>
							</tr>
							<tr>
					
						</tr>
						</table>
					</html:form></td>
			</tr>
		</table>

	</center>
<body>
</html:html>