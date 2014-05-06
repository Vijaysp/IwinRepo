<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<html:html locale="true">
<head>
<title>Predict and Enjoy!!</title>
</head>
<html:base />
<body bgcolor="#e6ffe5">
	<%@ include file="../top.jsp"%>
<SCRIPT LANGUAGE=javascript>

	function validateForm(formObj) 
	{

		if (formObj.emailId.value.length == 0) 
		{
			alert("Please enter Email ID");
			formObj.emailId.focus();
			return false;
		}

		formObj.actionUpdateData.value = "update";
		return true;
	}
</SCRIPT>
	<center>
		<br> <br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<table width="40%">
			<tr>
				<td><html:form focus="userid" action="/forgotpassword" method="post" onsubmit="return validateForm(this);">

		<%-- 	<html:hidden property="action" />
			<html:hidden property="actionUpdateData" /> --%>
						<table cellspacing="0" cellpadding="1" width="100%" class="table">
							<tr>
								<td align="center" class="loginTr">New Password<br></td>
							
								<html:hidden property="action" />
								<html:hidden property="actionUpdateData" />
							</tr>
							<tr>	<td align="center" class="loginTr">Password will be mailed shortly!!</td></tr>
							<tr>
								<table width="100%" cellpadding="5" cellspacing="0"
									class="table" align="center">
										<tr class="loginTr" align="center">
											<td class="userPass" width="50%"><b>Email ID<font
													color="#FF0000">*</font></b></td>
											<td class="userPass" width="50%"><html:text property="emailId"
													size="30" maxlength="120" styleClass="textbox">
												</html:text></td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
								</table>
							</tr>
							<tr>
								<table border="0" cellspacing="0" cellpadding="0"
									class="buttons">
									<tr>
										<td><br /> <input type="submit" name="loginBtn"
											class="groovybutton" value="Submit" title=""></td>
									</tr>
								</table>
							</tr>
						</table>
						<font color="red"><html:errors /></td>
					</html:form></td>
			</tr>
		</table>

	</center>
<body>
</html:html>