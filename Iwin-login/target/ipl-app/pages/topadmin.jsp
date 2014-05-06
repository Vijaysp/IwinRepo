
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ page import="dao.hibernate.*"%>
<%@ page import="dao.hibernate.pojo.*"%>
<%@ page import="services.*"%>
<%@ page import="java.util.*"%>
<link rel="stylesheet" href="../styles.css" type="text/css"
	media="screen">

<table width="100%" height="30" border="0" cellspacing="0"
	cellpadding="0" class="mainTable"
	background="../Logos/topHeaderBg.jpg">

	<tr>

		<td width="75%" align="left">
			<h4>
				&nbsp;
				</h2>
				<h2 align="center">
					<font color="white" face="Tahoma">IPL Prediction Contest</font>
					</h1>
					<h3 align="center">
						<font color="white" face="Tahoma">Koi nahi bachega!!! </font>
					</h3>
		</td>
		<td width="20%"><img src="../Logos/IPL_Logo.png"
			align="right" width="75%" height="100%" alt="IPL 2014" /></td>
	</tr>
</table>
<%
	SpringHibernateDAO springHibernateDAO = (dao.hibernate.SpringHibernateDAO) ServiceFinder
			.getContext(request).getBean("SpringHibernateDao");
	ArrayList teamList = springHibernateDAO.getTeams();
	Iterator teamItr = teamList.iterator();
	StringBuffer str = new StringBuffer();
	Team team = new Team();
	System.err.println((String) session.getAttribute("userID"));
	Calendar calendar = Calendar.getInstance();
	System.err.println(calendar.get(Calendar.HOUR_OF_DAY));

	while (teamItr.hasNext())
	{
		team = (Team) teamItr.next();
		str.append("<option>");
		str.append((String) team.getName());
		str.append("</option>");
	}
	session.setAttribute("teamtag", str.toString());
%>

<table border="0" width="100%" cellpadding="0" cellspacing="0">
	<tr>
		<td align="center" bgcolor="#6699CC" class="linkMenu" nowrap><html:link
				page="">
				<font color="white">Home</font>
			</html:link></td>

		<td align="center" class="linkMenu" bgcolor="#6699CC" nowrap>
			<%
				if ((String) session.getAttribute("userID") != null)
				{
					if ("admin".equalsIgnoreCase((String) session
							.getAttribute("userID")))
					{
			%> <html:link page="/userregister.do?action=Edit">
				<font color="white">Update Profile</font>
			</html:link> <%
 	}
 	}
 	else
 	{
 %> <html:link page="/pages/user/userRegister.jsp">
				<font color="white">Register</font>
			</html:link> <%
 	}
 %>
		</td>

		<td width="12%" class="linkMenu" bgcolor="#6699CC" align="center"
			nowrap>
			<%
				if ((String) session.getAttribute("userID") != null)
				{
			%> <html:link page="/pages/user/loginsuccess.jsp">
				<font color="white">Create Prediction</font>
			</html:link> <%
 	}
 %>
		</td>

		<td width="12%" class="linkMenu" bgcolor="#6699CC" align="center"
			nowrap>
			<%
				if ((String) session.getAttribute("userID") != null
						&& "admin".equals((String) session.getAttribute("userID")))
				{
			%> <html:link page="/pages/user/createteam.jsp">
				<font color="white">Create Teams</font>
			</html:link> <%
 	}
 %>
		</td>

		<td width="12%" class="linkMenu" bgcolor="#6699CC" align="center"
			nowrap>
			<%
				if ((String) session.getAttribute("userID") != null
						&& "admin".equals((String) session.getAttribute("userID")))
				{
			%> <html:link page="/pages/user/creatematch.jsp">
				<font color="white">Create Matches</font>
			</html:link> <%
 	}
 %>
		</td>

		<td width="12%" class="linkMenu" bgcolor="#6699CC" align="center"
			nowrap>
			<%
				if ((String) session.getAttribute("userID") != null
						&& "admin".equals((String) session.getAttribute("userID")))
				{
			%> <html:link page="/pages/user/createplayer.jsp">
				<font color="white">Create Players</font>
			</html:link> <%
 	}
 %>
		</td>

		<td width="13%" class="linkMenu" bgcolor="#6699CC" align="center"
			nowrap>
			<%
				if ((String) session.getAttribute("userID") != null
						&& "admin".equals((String) session.getAttribute("userID")))
				{
			%> <html:link page="/pages/user/admin.jsp">
				<font color="white">Admin</font>
			</html:link> <%
 	}
 %>
		</td>
		<td width="13%" class="linkMenu" bgcolor="#6699CC" align="center"
			nowrap>
			<%
				if ((String) session.getAttribute("userID") != null)
				{
			%> <html:link page="/pages/user/PointsTable.jsp">
				<font color="white">Points Table</font>
			</html:link> <%
			 	}
			 %>
		</td>

		<!--Shan-->
		<td width="12%" class="linkMenu" bgcolor="#6699CC" align="center"
			nowrap><html:link page="/pages/user/rules.jsp">
				<font color="white">Rules</font>
			</html:link></td>
		<!--Shan-->
		<td width="10%" class="linkMenu" bgcolor="#6699CC" align="center"
			nowrap>
			<%
			if ((String) session.getAttribute("userID") != null)
			{
			%> <B><font color="aqua"> <%
					out.print("Welcome " + session.getAttribute("userID"));
				%>
			</font> </B>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<html:link page="/logout.do">
				<font color="white">Logout</font>
			</html:link> <%
		 	}
		 	else
		 	{
		 	%> <html:link page="/pages/user/userlogin.jsp">
				<font color="white">Login</font>
			</html:link> <%
		 	}
		 %>
		</td>
	</tr>

	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>
</table>