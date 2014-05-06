<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<html:html locale="true">

<head>
<LINK rel="stylesheet" type="text/css" name="anyname"
	href="<html:rewrite page='/css/style.css'/>">
<title>Predict and Enjoy!!</title>
<html:base />
<SCRIPT LANGUAGE=javascript>
	function validateForm(formObj) {

		if (formObj.password.value.length == 0) {
			alert("Please enter current password!");
			formObj.password.focus();
			return false;
		}

		if (formObj.newPassword.value.length == 0) {
			alert("Please enter new password!");
			formObj.newPassword.focus();
			return false;
		}

		if (formObj.confirmPassword.value.length == 0) {
			alert("Please enter confirm password!");
			formObj.confirmPassword.focus();
			return false;
		}

		if (formObj.newPassword.value != formObj.confirmPassword.value) {
			formObj.newPassword.value = "";
			formObj.confirmPassword.value = "";
			formObj.newPassword.focus();
			alert('The new password and confirm password are not same.');
			return false;
		}

		alert('User id: ' + form.userid.value);

		formObj.actionUpdateData.value = "updatePassword";
		return true;
	}
//-->
</SCRIPT>
</head>

<body bgcolor="#e6ffe5">

	<%@ include file="../top.jsp"%>

	<center>
		<html:form action="/updateProfile" method="post"
			onsubmit="return validateForm(this);">

			<html:hidden property="action" />
			<html:hidden property="actionUpdateData" />
			<input type="hidden" name="userid"
				value="<%=(String) session.getAttribute("userID")%>" />


			<table width="50%" border="1" class="signup" align="center">

				<tr>
					<td colspan="2" align="center"><font size="4" color="#660099">Update
							Password</font><br></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><font color="red"><html:errors /></font></td>
				</tr>

				<tr>
					<td align="right" width="50%"><b>Current password<font
							color="#FF0000">*</font></b></td>
					<td align="left" width="50%"><html:text property="password"
							size="30" maxlength="120">
						</html:text></td>
				</tr>

				<tr>
					<td align="right"><b>New Password<font color="#FF0000">*</font></b></td>
					<td align="left"><html:password property="newPassword"
							size="30" maxlength="120" /></td>
				</tr>

				<tr>
					<td align="right"><b>Confirm Password<font color="#FF0000">*</font></b></td>
					<td align="left"><html:password property="confirmPassword"
							size="30" maxlength="120" /></td>
				</tr>

				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td align="center" colspan="2"><html:submit>Save</html:submit>
					</td>
				</tr>

			</table>
		</html:form>
</body>
</html:html>
