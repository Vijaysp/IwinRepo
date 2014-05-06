
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<html:html locale="true">

<head>

<title>Predict and Enjoy!!</title>
<html:base />
</head>
<body bgcolor="#e6ffe5">
	<%@ include file="../top.jsp"%>
	<center>
		<p>
			<b>You team is created successfully ! Please click <html:link
					page="/pages/user/loginsuccess.jsp">
					<font color="red">here</font>
				</html:link> to create your prediction.
			</b>
		</p>
	</center>
</body>
</html:html>
