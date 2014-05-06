<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
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
	<%
	}
	else
	{
	%>
	<%@ include file="../top.jsp"%>
	<%
	}
	%>
	<div class='post-body entry-content'>
	<pre><font color="dark blue">Match Schedule</font></pre>
<div class="separator" style="clear: both; text-align: center;"><a href="http://3.bp.blogspot.com/-nt0fXJkpef4/Uz2kyPJTu3I/AAAAAAAADUQ/OjSlbZbJu9A/s1600/IPL+2014+Full.jpg" imageanchor="1" style="margin-left: 1em; margin-right: 1em;"><img border="0" src="http://3.bp.blogspot.com/-nt0fXJkpef4/Uz2kyPJTu3I/AAAAAAAADUQ/OjSlbZbJu9A/s1600/IPL+2014+Full.jpg" /></a></div>
	</body></html:html>