
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
	background="./Logos/topHeaderBg.jpg">
	<tr>
		<td width="75%" align="left">
			<h4>
				&nbsp;
				</h2>
				<h2 align="center">
					<font color="white" face="Tahoma">IPL Prediction Contest</font>
				</h2>
				<h3 align="center">
					<font color="white" face="Tahoma">Koi nahi bachega!!! </font>
				</h3>
		</td>
		<td width="20%"><img
			src="./Logos/IPL_Logo.png"
			align="right" width="75%" height="80%" alt="IPL 2014" /></td>
	</tr>
</table>
<%
	SpringHibernateDAO springHibernateDAO = (dao.hibernate.SpringHibernateDAO) ServiceFinder
			.getContext(request).getBean("SpringHibernateDao");
	ArrayList teamList = springHibernateDAO.getTeams();
	Iterator teamItr = teamList.iterator();
	StringBuffer str = new StringBuffer();
	Team team = new Team();
	System.err.println("UserID (top.jsp): "+(String) session.getAttribute("userID"));
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
		<td bgcolor="#6699CC" class="linkMenu" align="center" nowrap><html:link
				page="/pages/Welcome.jsp">
				<font color="white">Home</font>
			</html:link></td>
			
			<td bgcolor="#6699CC" class="linkMenu" align="center" nowrap><html:link
				page="/pages/user/Contactus.jsp">
				<font color="white">Contact</font>
			</html:link></td>

		<td align="center" class="linkMenu" bgcolor="#6699CC" nowrap>
			<%
				if ((String) session.getAttribute("userID") != null)
				{
			%> <%
 				}
				else
				{
			 %> <html:link page="/pages/user/userRegister.jsp">
				<font color="white">Register</font>
			</html:link> <%
				}
			%>

		</td>

		<td bgcolor="#6699CC" class="linkMenu" align="center" nowrap>
			<%
				if ((String) session.getAttribute("userID") != null)
				{
			%> <html:link page="/pages/user/loginsuccess.jsp">
				<font color="white">Create Prediction</font>
			</html:link> <%
 			}
			 %>
		</td>

		<td bgcolor="#6699CC" class="linkMenu" align="center" nowrap>
			<%
				if ((String) session.getAttribute("userID") != null)
				{
				%> <html:link page="/pages/user/MyTeam.jsp">
				<font color="white">Fixtures</font>
			</html:link> <%
	 			}
			 %>
		</td>

		<td bgcolor="#6699CC" class="linkMenu" align="center" nowrap>
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
		<td bgcolor="#6699CC" class="linkMenu" align="center" nowrap><html:link
				page="/pages/user/rules.jsp">
				<font color="white">Rules</font>
			</html:link></td>
		<!--Shan-->
		
		<!--Vijay-->
		<td bgcolor="#6699CC" class="linkMenu" align="center" nowrap><html:link
				page="/pages/user/CopyRights.jsp">
				<font color="white">CopyRights</font>
			</html:link></td>
		<!--Vijay-->
		
		<td bgcolor="#6699CC" class="linkMenu" align="right" nowrap>
			<%
			if ((String) session.getAttribute("userID") != null)
			{
			%> <b><font color="aqua"> <%
				out.print("Welcome " + session.getAttribute("userID"));
			%>
			</font></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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