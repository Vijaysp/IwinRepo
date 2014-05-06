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
		<h3 class="titleMessage">Lets join together and celebrate the
			season of ecstacy in just not watching cricket but participating in
			an online Predictions contest.</h3>
	</center>

	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="">
		<tr>
			<td class="title"><strong>Rules for Playing Play-Offs
					and Finals</strong></td>
		</tr>
		<tr>
			<td class="bgSmall1">
				<li>Start by selecting a team name of your choice. You will not
					be able to change the name. Plan for the best name to list in the
					Points Table.</li>
				<li>You must select your 11 man team and a substitute.</li>
				<li>Change or transfer of players will not be allowed after the
					start of the first play-off. After the start of the first play-off,
					the last modified team will be freezed for the rest of the matches.</li>
				<li>The first player in the selection will be designated as
					your team's Captain.</li>
				<li>Think wise before you choose your captain, as the Captain's
					score will be doubled, be it positive or negative points.
			<li>The scoring rules remain the same as the league matches. In
					addition to the current scoring rules, points for run-outs has been
					included.</li>
				<li>There is no limitations on choosing any number of players
					from the same team.</li>
				<li>Points scored by the substitute shall be slashed by half.</li> <br>&nbsp;
				&nbsp; &nbsp; E.g., If Dinesh Karthik is your substitute and he
				scores 300 points in a match, he will fetch you just 150 points.
				<li>To form a standard cricket team with all the variety of
					players, your team should comply with one of the below specified
					player combinations.</li>
			</td>
		</tr>
		<tr>
			<td align="center">
				<table border="1" class="table">
					<tr>
						<th class="bgTr5Small">Batsmen</th>
						<th class="bgTr5Small">All-Rounders</th>
						<th class="bgTr5Small">Wicket Keeper</th>
						<th class="bgTr5Small">Bowlers</th>
					</tr>

					<tr>
						<td class="bgTr3Small" align="center">6</td>
						<td class="bgTr3Small" align="center">0</td>
						<td class="bgTr3Small" align="center">1</td>
						<td class="bgTr3Small" align="center">4</td>
					</tr>
					<tr>
						<td class="bgTr3Small" align="center">5</td>
						<td class="bgTr3Small" align="center">0</td>
						<td class="bgTr3Small" align="center">1</td>
						<td class="bgTr3Small" align="center">5</td>
					</tr>
					<tr>
						<td class="bgTr3Small" align="center">5</td>
						<td class="bgTr3Small" align="center">1</td>
						<td class="bgTr3Small" align="center">1</td>
						<td class="bgTr3Small" align="center">4</td>
					</tr>
					<tr>
						<td class="bgTr3Small" align="center">5</td>
						<td class="bgTr3Small" align="center">2</td>
						<td class="bgTr3Small" align="center">1</td>
						<td class="bgTr3Small" align="center">3</td>
					</tr>
					<tr>
						<td class="bgTr3Small" align="center">4</td>
						<td class="bgTr3Small" align="center">1</td>
						<td class="bgTr3Small" align="center">1</td>
						<td class="bgTr3Small" align="center">5</td>
					</tr>
					<tr>
						<td class="bgTr3Small" align="center">4</td>
						<td class="bgTr3Small" align="center">2</td>
						<td class="bgTr3Small" align="center">1</td>
						<td class="bgTr3Small" align="center">4</td>
					</tr>
					<tr>
						<td class="bgTr3Small" align="center">4</td>
						<td class="bgTr3Small" align="center">3</td>
						<td class="bgTr3Small" align="center">1</td>
						<td class="bgTr3Small" align="center">3</td>
					</tr>
				</table>
			</td>
		</tr>

		<tr>
			<td class="message" align="center">PS: The rules and scoring
				mechanism for our predictions (Predicting winning team and mom) will
				continue in the same fashion as we had till date. It will be open
				for prediction till the start of the match.</td>
		</tr>

		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td class="title"><strong>How to play</strong></td>
		</tr>
		<tr>
			<td class="bgSmall1"><span> Login using your userid and
					password. Register if you are first time user. <br>All you
					have to do is to Click on Create Prediction link. <br>The
					matches will be displayed with the team names and the players list.
					<br>Predict the team you believe will win the match and the
					player who will emerge as the player of the match. You score based
					on your predictions. You can check your position in Points table
					link.
			</span></td>
		</tr>

		<tr>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<td class="normalBig">The scoring rules:-</td>
		</tr>
		<tr>
			<td class="title"><strong>General Rules</strong></td>
		</tr>
		<tr>
			<td class="bgSmall1">
				<li>100 for correctly predicting MOM</li>
				<li>100 for correctly predicting winning team</li>
			</td>
		</tr>

		<tr>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<td class="title"><strong>Bating </strong></td>
		</tr>

		<tr>
			<td class="bgSmall1">
				<li>If a batsman scores 100 or above, with range value
					included, he will gain a bonus of 100 points + 3 points for every
					run scored after 100. <br>&nbsp; &nbsp; &nbsp; E.g., If
					Micheal Hussey scores 100, he will fetch you 100*1 + 100 = 200
					points <br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					&nbsp; If Chris Gayle scores 135, he will fetch you 100*1 + 100 +
					(135-100)*3 = 305 points
			</li>
				<p>
				<li>If a batsman scores between 50 and 99 with both range
					values included, he will gain a bonus of 50 points + 2 points for
					every run scored after 50. <br>&nbsp; &nbsp; &nbsp;E.g., If
					Rohit Sharma scores 50, he will fetch you 50*1 + 50 = 100 points <br>&nbsp;
					&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;If Dinesh Karthick
					scores 72, he will fetch you 50*1 + 50 + (72-50)*2 = 124 points
			</li>
				<p>
				<li>If a batsman scores between 30 and 49 with both range
					values included, he will gain a bonus of 30 points. <br>&nbsp;
					&nbsp; &nbsp;E.g., If Robin Uttappa scores 45, he will fetch you
					45*1 + 30 = 75 points
			</li>
				<p>
				<li>If a batsman scores between 1 and 29 with both range values
					included, he will score 1 points for every run scored <br>&nbsp;
					&nbsp; &nbsp;E.g., If Adam Gilchrist scores 25, he will fetch you
					25*1 = 25 points.
			</li>
				<p>
				<li>If a batsman scores 0, -25 for duck and -50 for golden duck
					or diamond duck</li>
			</td>
		</tr>

		<tr>
			<td class="normal">PS: A batsman will be considered in any one
				of the brackets for calculation.</td>
		</tr>

		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td class="title"><strong>Super Sixes </strong></td>
		</tr>
		<tr>
			<td class="bgSmall1">
				<li>For every six a batsman scores, he will fetch you
					additional 5 points.
			</td>
		</tr>

		<tr>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<td class="title"><strong>Bowling</strong> </strong></td>
		</tr>
		<tr>
			<td class="bgSmall1">
				<li>If a bolwer takes 5 wickets or above, he will gain a bonus
					of 100 points and 60 points for every wicket after 5 wickets <br>&nbsp;
					&nbsp; &nbsp;E.g., If Sunil Narine takes 5 wickets, he will fetch
					you 5*30 + 100 = 250 points <br>&nbsp; &nbsp; &nbsp; &nbsp;
					&nbsp; &nbsp; &nbsp;&nbsp; If James Faulkner takes 6 wickets, he
					will fetch you 5*30 + 100 + (6-5) * 60 = 310 points
			</li>
				<p>
				<li>If a bolwer takes either 3 or 4 wickets, he will gain a
					bonus of 75 points <br>&nbsp; &nbsp; &nbsp;E.g., If R Ashwin
					takes 3 wickets, he will fetch you 3*30 + 75 = 165 points <br>&nbsp;
					&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; If K Cooper takes 4
					wickets, he will fetch you 4*30 + 75 = 195 points
			</li>
				<p>
				<li>If a bolwer takes less than 3 wickets, he will score 30
					points for every wicket taken <br>&nbsp; &nbsp; &nbsp;E.g., If
					R Jadeja doesn't take a wicket in a match, he will not fetch you
					any points for his bowling <br>&nbsp; &nbsp; &nbsp; &nbsp;
					&nbsp; &nbsp; &nbsp;&nbsp; If R Vinay Kumar takes 2 wickets, he
					will fetch you 2*30 = 60 points
			</li> <br>
			</td>
		</tr>
		<tr>
			<td class="normal">PS: A bowler will be considered in any one of
				the brackets for calculation.</td>
		</tr>

		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td class="title"><strong>Hat-trick in a match </strong></td>
		</tr>
		<tr>
			<td class="bgSmall1">
				<li>If a bowler takes a hat-trick, he will fetch you an
					additional 150 points</li>
			</td>
		</tr>

		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td class="title"><strong>Run-outs </strong></td>
		</tr>
		<tr>
			<td class="bgSmall1">
				<p>
				<li>If a player effects 3 or more run-outs, he will gain a
					bonus of 50 + 10 points for every direct hit at stumps and 5 points
					for every run-out effected with the assistance of another player/
					players. <br>&nbsp; &nbsp; &nbsp;E.g., If R Jadeja effects 4
					run-outs, 2 out of them being direct and 1 being a throw to bowler
					and 1 being a throw to keeper, he will fetch you 2*10 + 2*5 + 50 =
					80 points <br>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp;
					&nbsp; The wicket-keeper in the above case will gain 5 points and
					the involved bowler 5 points.
			</li>
			</td>
		</tr>

		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td class="title"><strong>Catches </strong></td>
		</tr>
		<tr>
			<td class="bgSmall1">
				<p>
				<li>If a wicket-keeper takes 3 or more catches, he will gain a
					bonus of 50 + 5 points for every catch <br>&nbsp; &nbsp;
					&nbsp;E.g., If MS Dhoni takes 4 catches, he will fetch you 4*5 + 50
					= 70 points
			</li>
			</td>
		</tr>

		<tr>
			<td class="bgSmall1">
				<p>
				<li>If a non wicket-keeper takes 3 or more catches, he will
					gain a bonus of 50 + 10 points for every catch <br>&nbsp;
					&nbsp; &nbsp;E.g., If Rahul Dravid takes 3 catches, he will fetch
					you 3*10 + 50 = 80 points
			</li>
				<p>
				<li>For every catch, a wicket-keeper takes, he will be awarded
					5 points per catch.</li>
				<li>For every catch, a non wicket-keeper takes, he will be
					awarded 10 points per catch.</li>
			</td>
		</tr>
		<tr>
			<td class="normal">PS: A player will be considered in any one of
				the brackets for calculation.</td>
		</tr>

		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td class="title"><strong>Stumping </strong></td>
		</tr>
		<tr>
			<td class="bgSmall1">
				<li>If a wicket-keeper performs 3 or more stumping in a match,
					he will gain a bonus of 100 points.</li>
			</td>
		</tr>
	</table>

	<br>

	<table>
		<tr>
			<td class="message">
				<p>
					*If a player is categorized as a specialist wicket keeper and if he
					doesn't keep wickets in the match, he will be considered as a
					batsman. <br>*The player speciality has been mentioned with
					the best knowledge and with reference to some website. They are
					just for guidance for predicting the Man of the match prediction. <br>&nbsp;
					Please update the organiser if in case the category is incorrect.
				</p>
			</td>
		</tr>
		<tr>
			<td class="bgSmall1">
				<p>If anything is not clear in the scoring rules, please contact
					us!</p>
			</td>
		</tr>
	</table>
</body>
