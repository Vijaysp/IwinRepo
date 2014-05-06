<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ page
	import="java.util.ArrayList,java.util.Iterator,java.text.SimpleDateFormat,java.util.HashMap"%>

<html:html locale="true">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Predict and Enjoy - Feedback</title>
</head>

<body bgcolor="#e6ffe5">

	<%@ include file="../top.jsp"%>
	<html:form focus="feedback" action="/feedback" method="post">

		<table width="50%" align="center">
			<tr>
				<td class="normal">Your Feedback</td>
				<td class="bgTr3Small"><html:Textarea property="feedback"
						maxlength="500" styleClass="textArea">
					</html:Textarea></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
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
	</html:form>
</body>
</html:html>