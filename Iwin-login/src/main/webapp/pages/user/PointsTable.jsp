
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.iwin.utility.ListConst"%>
<%@page import="com.iwin.utility.CollectionUtils"%>
<%@page import="dao.hibernate.pojo.Prediction"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ page
	import="java.util.ArrayList, java.util.Iterator, dao.hibernate.pojo.Match, java.text.SimpleDateFormat,java.util.HashMap"%>

<html:html locale="true">

<head>

<title>Predict and Enjoy!!</title>
<html:base />
</head>
<body bgcolor="#e6ffe5">
	<%@ include file="../top.jsp"%>

	<table border="1" class="table" align="center">

		<tr>
			<th class="bgTh5Big">Ranking based on points</th>
			<th></th>

			<th class="bgTh5Big">Ranking based on average</th>
		</tr>

		<tr>
			<td>
				<table border="1" class="table">
					<tr>
						<th class="bgTr5Small" width=20>Rank</th>
						<th class="bgTr5Small" width=150">Name</th>
						<th class="bgTr5Small" width=125>Points</th>
					</tr>
					<%
	
				ArrayList pointsTable = springHibernateDAO.generatePointsTable();
				
				Iterator pointsItr = pointsTable.iterator();
				Prediction pred = null;
				int count = 0; 
				
				while (pointsItr.hasNext())
				{
					count = count + 1;
					pred = (Prediction) pointsItr.next();
				%>
					<tr>
						<%
						if (session.getAttribute("userID") != null 
								&& ((String)session.getAttribute("userID")).
								equalsIgnoreCase((String)pred.getUserid()))
						{	
					%>
						<td class="bgTr3SmallHighLighted" align="center"><%= count %></td>
						<td class="bgTr3SmallHighLighted" width="auto"><%= pred.getUserid() %></td>
						<td class="bgTr3SmallHighLighted" align="center"><%= pred.getPoints() %></td>
						<% 
						}
						else
						{
					%>
						<td class="bgTr3Small" align="center"><%= count %></td>
						<td class="bgTr3Small" width="auto"><%= pred.getUserid() %></td>
						<td class="bgTr3Small" align="center"><%= pred.getPoints() %></td>
						<%
						}
					%>
					</tr>
					<%
				}
				%>
				</table>
			</td>

			<td>&nbsp;</td>

			<td>
				<table border="1" class="table">
					<tr>
						<th class="bgTr5Small">Rank</th>
						<th class="bgTr5Small">Name</th>
						<th class="bgTr5Small">Points</th>
						<th class="bgTr5Small" no wrap>Matches Predicted</th>
						<th class="bgTr5Small" no wrap>Avg per match</th>
					</tr>
					<%
				ArrayList avgPointsTabCol = springHibernateDAO.
						gnratePointsTblBasedOnAvg();
				ArrayList tempCol = new ArrayList();
				
				avgPointsTabCol = (ArrayList) CollectionUtils.sortPredictionAvg(
						avgPointsTabCol, ListConst.LSTSortCollectionOrder.
						LST_SORT_COLLECTION_ORDER_DESC);
				
				DecimalFormat df = new DecimalFormat("#");
				
				Iterator avgPointsTabColItr = avgPointsTabCol.iterator();
				com.iwin.domain.Prediction prediction = null;
				int counter = 0; 
				int remCount = 0;
				
				while (avgPointsTabColItr.hasNext())
				{
					
					prediction = (com.iwin.domain.Prediction) 
							avgPointsTabColItr.next();
					
					if (prediction.getMatches() < 25)
					{
						tempCol.add(prediction);
						avgPointsTabColItr.remove();
						remCount = remCount + 1;
						continue;
					}
					counter = counter + 1;
				%>
					<tr>
						<%
						if (session.getAttribute("userID") != null 
								&& ((String)session.getAttribute("userID")).
								equalsIgnoreCase((String)prediction.getUserid()))
						{	
					%>
						<td class="bgTr3SmallHighLighted" align="center"><%= counter %></td>
						<td class="bgTr3SmallHighLighted" width="auto"><%= prediction.getUserid() %></td>
						<td class="bgTr3SmallHighLighted" align="center"><%= df.format(prediction.getPoints()) %></td>
						<td class="bgTr3SmallHighLighted" align="center"><%= df.format(prediction.getMatches()) %></td>
						<td class="bgTr3SmallHighLighted" align="center"><%= prediction.getAverage()%></td>
						<% 
						}
						else
						{
					%>
						<td class="bgTr3Small" align="center"><%= counter %></td>
						<td class="bgTr3Small" width="auto"><%= prediction.getUserid() %></td>
						<td class="bgTr3Small" align="center"><%= df.format(prediction.getPoints()) %></td>
						<td class="bgTr3Small" align="center"><%= df.format(prediction.getMatches()) %></td>
						<td class="bgTr3Small" align="center"><%= prediction.getAverage() %></td>
						<%
						}
					%>
					</tr>
					<%
				}
				
				int counter1 = counter;
				
				for (int i = 0 ; i < tempCol.size(); i ++)
				{
					com.iwin.domain.Prediction pred1 =
							(com.iwin.domain.Prediction) tempCol.get(i);
					
					counter1++;
					
					if (session.getAttribute("userID") != null 
							&& ((String)session.getAttribute("userID")).
							equalsIgnoreCase((String)pred1.getUserid()))
					{
				%>
					<td class="bgTr3SmallHighLighted" align="center"><%= counter1 %></td>
					<td class="bgTr3SmallHighLighted" width="auto"><%= pred1.getUserid() %></td>
					<td class="bgTr3SmallHighLighted" align="center"><%= df.format(pred1.getPoints()) %></td>
					<td class="bgTr3SmallHighLighted" align="center"><%= df.format(pred1.getMatches()) %></td>
					<td class="bgTr3SmallHighLighted" align="center">-</td>
					<% 
					}
					else
					{
				%>
					<tr>
						<td class="bgTr3Small" align="center"><%= counter1 %></td>
						<td class="bgTr3Small" width="auto"><%= pred1.getUserid() %></td>
						<td class="bgTr3Small" align="center"><%= df.format(pred1.getPoints()) %></td>
						<td class="bgTr3Small" align="center"><%= df.format(pred1.getMatches()) %></td>
						<td class="bgTr3Small" align="center">-</td>
					</tr>
					<%
					}
				}
				%>
				</table>
			</td>
		</tr>
	</table>

	<center>
		<b><font class="bgSmall">Updated till:</b></font> <font class="normal"
			color="blue">72 - Sunrisers Hyderabad v Kolkata Knight Riders
			- May 19</font>
	</center>
	<center>
		<b><font class="bgSmall">Last updated:</b></font> <font class="normal"
			color="blue">23th Apr, 2014</font>
	</center>


	<center>
		<font class="normal" color="blue">PS: The listing based on
			average is just an indication. As the scoring rules has been changed
			during the course of the tournament, the listing may not project the
			exact ranking. <br>The ranking is based on priority to users who
			have predicted minimum of 25 games.
		</font>
	</center>

</body>
</html:html>