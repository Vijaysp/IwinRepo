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
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		class="naviBg">
		<tr>
			<td height="30" valign="middle">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="10" valign="middle">&nbsp;</td>
						<td align="left" valign="middle">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td>&nbsp;</td>
									<td width="10">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
							</table>
						</td>
						<td align="right" valign="middle" nowrap>
							<table border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td class="linkMenu">&nbsp;</td>
									<td width="10">&nbsp;</td>
									<td>&nbsp;</td>
									<td width="10">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
							</table>
						</td>
						<td width="10" valign="middle">&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<center>
		<h3 class="titleMessage">© Copyright 2014 by Iwin IPL Team Fantasy League. All rights reserved. Copyright belongs to the Iwin IPL Team Fantasy League. 
This is for promoting IPL and entertaining people.The intention is not to earn or for commercial purpose</h3>
	</center>

	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="">
		<tr>
			<td class="title"><strong>No Gifts/Prizes or Cash Award</strong></td>
		</tr>
		<tr>
			<td class="bgSmall1">
				<li>The intention of game is to promote IPL</li>
				<li>This is only introduced for entertaining people and there is strictly no gambling</li>
				<li>The winners name will be in the top and there is no cash award offered now</li>
				<li>As of now there is no gifts or prizes offered and best prediction will be ranked as first</li>
				
			</td>
		</tr>
	

		<tr>
			<td class="message" align="center">PS: We are strictly following the rules as mentioned in the Rules tab</td>
		</tr>
	</table>
</body>
