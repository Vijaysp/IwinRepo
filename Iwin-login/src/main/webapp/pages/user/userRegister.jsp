<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<html:html locale="true">

<head>
<title>Predict and Enjoy!!</title>
<html:base />
<SCRIPT LANGUAGE=javascript>

	function validateForm(formObj) 
	{
		if (formObj.userid.value.length == 0) 
		{
			alert("Please enter User ID!");
			formObj.userid.focus();
			return false;
		}

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
</head>
<script language="javascript">

function goLite(FRM,BTN)
{
   window.document.forms[FRM].elements[BTN].style.color = "#777777";
   window.document.forms[FRM].elements[BTN].style.borderTopColor = "#666666";
   window.document.forms[FRM].elements[BTN].style.borderBottomColor = "#666666";
}

function goDim(FRM,BTN)
{
   window.document.forms[FRM].elements[BTN].style.color = "#999999";
   window.document.forms[FRM].elements[BTN].style.borderTopColor = "#AAAAAA";
   window.document.forms[FRM].elements[BTN].style.borderBottomColor = "#AAAAAA";
}

</script>


<body bgcolor="#e6ffe5">


	<%@ include file="../top.jsp"%>

	<FONT SIZE="2.5" FACE="Verdana" COLOR=White><MARQUEE WIDTH=100%
			BEHAVIOR=ALTERNATE BGColor="#6699CC">Please use valid Mail
			address for registering. Password will be emailed to your mail id.</MARQUEE></FONT>

	<center>
		<html:form focus="userid" action="/userregister" method="post"
			onsubmit="return validateForm(this);">

			<html:hidden property="action" />
			<html:hidden property="actionUpdateData" />

			<table width="50%" class="table" align="center">

				<tr class="loginTr">
					<td colspan="2" align="center" class="loginTr">Please enter
						the following details<br>
					</td>
				</tr>

				<tr class="loginTr">
					<td colspan="2" align="center"><font color="red"><html:errors /></font>&nbsp;</td>
				</tr>
				<tr>
					<td class="userPass"><b>User Id<font color="#FF0000">*</font></b></td>
					<td width="50%"><html:text property="userid" size="30"
							maxlength="120" styleClass="textbox" /></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>

				<tr class="loginTr">
					<td class="userPass" width="50%"><b>Email ID<font
							color="#FF0000">*</font></b></td>
					<td class="userPass" width="50%"><html:text property="emailId"
							size="30" maxlength="120" styleClass="textbox">
						</html:text></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>

				<tr class="loginTr">
					<td class="userPass"><b>Team I Support</b></td>
					<td class="userPass"><html:select styleClass="listMenu"
							property="isupport">
							<%=(String) session.getAttribute("teamtag")%>
						</html:select></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr></tr>

				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr class="loginTr">

					<td align="center" colspan="2"><input type="submit"
						name="loginBtn" class="groovybutton" value="Register" title=""
						onMouseOver="goLite(this.form.name,this.name)"
						onMouseOut="goDim(this.form.name,this.name)" /></td>
				</tr>
			</table>
		</html:form>
</body>
</html:html>