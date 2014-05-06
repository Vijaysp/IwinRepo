<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
<title>Predict and Enjoy!</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
<body bgcolor="#e6ffe5">
	<%if ("admin".equalsIgnoreCase((String) session.getAttribute("userID")))
	{
		%>
	<%@ include file="../topadmin.jsp"%>
	<%
	}
	else 
	{%>
	<%@ include file="../top.jsp"%>
	<%
	} %>

	<h3>Contact us</h3>
	<span class="bgSmall1"> For any queries or clarifications in
		scoring rules or points calculation, send a mail to
		
		iwinpredictioncontest@gmail.com	
		<hr>
		<table align="left"><tr>
		<pre><tr align="center"><font color="blue">Developers</font><tr><td>
		<img src="../images/omie.jpg" width="100" height="100" alt="Omie" />
		<p>
			Omprakash <a href="https://www.facebook.com/kb.omprakash">Omie<img  width="25" height="25" src="../images/facebook.png"></a>.
		</p></td><td>
	
		<img src="../images/shan.jpg" width="100" height="100" alt="Shan" />
		<p>
			Shanmuga sundaram <a href="https://www.facebook.com/shan.laxmi">Shan<img  width="25" height="25" src="../images/facebook.png"></a>.
		</p>
	</td><td>
		<img src="../images/vijay.JPG" width="100" height="100" alt="Vijay" />
		<p>
			Vijay Suriya <a href="https://www.facebook.com/vjayirp">Vijay<img  width="25" height="25" src="../images/facebook.png"></a>.
		</p>
</td><td>
		<img src="../images/sree.jpg" width="100" height="100" alt="Sree" />
		<p>
-			Sreeram <a href="https://www.facebook.com/sreeram.sankaranarayanan">Sree<img  width="25" height="25" src="../images/facebook.png"></a>.
		</p>
	</td>
	</tr></pre>
	</table>
	<hr>
</body>
