
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<html:html locale="true">

<head>

<title>Predict and Enjoy!!</title>
<html:base />
</head>
<body bgcolor="#e6ffe5">
	<%@ include file="../topadmin.jsp"%>
	<center>

		<p>
			<b>Match created successfully ! Please click <html:link
					page="/pages/user/creatematch.jsp">
					<font color="red">here</font>
				</html:link> to create another.
			</b>
		</p>

	</center>
</body>
</html:html>
