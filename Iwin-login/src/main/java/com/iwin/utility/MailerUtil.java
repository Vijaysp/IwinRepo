package com.iwin.utility;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailerUtil {
	static Properties props = System.getProperties();

	static {
		props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");
		/*String sHostName = "Blrmail.kds.keane.com";
		props.put("mail.host", sHostName);
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", true);*/
	}

	static Authenticator auth = new Authenticator() {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("iwinpredictioncontest", "IwinDev@1900");
		}
	};

	public void sendRemainderMail() {
		// getUsers();

		String password = null;
		String userId = null;
		String toAddr = null;
		final String fromAddr = "iwinpredictioncontest@gmail.com";

		String sMsgTxt = "Hi, \nGreeting!!\nThank you for registering in "
				+ "IPL Predict and Enjoy contest. We haven't received predictions "
				+ "from you yet!!\n\nWe wish you make an active prediction and "
				+ "enjoy the contest!!\nWe have planned for a Roller Coaster "
				+ "Contest pretty soon and hope you will enjoy it and get a good "
				+ "chance of making up good points!!\n Participating is fun and "
				+ "without your participation the game is incomplete!!"
				+ "\n\nFor more details on how to play and scoring details, "
				+ "please visit: <a href='../Iwin-login/src/main/webapp/pages/user/rules.jsp'>Rules</a>"
				+ "\n\nThank you registering! "
				+ "Enjoy the game!! \n\nRegards,\nIPL Prediction Contest "
				+ "Developers";
	}

	public static Boolean sendMail(Map<Enum, String> userDetails) {
		String password = null;
		String userId = null;
		String toAddr = null;
		final String fromAddr = "iwinpredictioncontest@gmail.com";
		String subject = "Registration to IPL Prediction Contest";

		toAddr = userDetails.get(UserAttribs.EMAIL_ID);
		password = userDetails.get(UserAttribs.PASSWORD);
		userId = userDetails.get(UserAttribs.USERID);

		String sMsgTxt = "Hi, \nWelcome to IPL Prediction Contest\n"
				+ "You have successfully registered. \n\nYour User ID: "
				+ userId
				+ "\nPassword: "
				+ password
				+ "\n\nFor more details on how to play and scoring details, "
				+ "please visit: ../Iwin-login/target/ipl-app/pages/user/rules.jsp"
				+ "\n\nThank you registering! "
				+ "Enjoy the game!! \n\nRegards,\nIPL Prediction Contest "
				+ "Developers";

		// get the session with authenticator
		Session session = Session.getDefaultInstance(props, auth);
		session.setDebug(true);

		try {
			// construct the message
			Message msg = new MimeMessage(session);
			// set from address
			msg.setFrom(new InternetAddress(fromAddr));
			InternetAddress[] address = { new InternetAddress(toAddr) };

			InternetAddress[] addressBCC = { new InternetAddress(
					"Omprakash.Bhawarlal@nttdata.com") };
			// set to address
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setRecipients(Message.RecipientType.BCC, addressBCC);
			// set subject
			msg.setSubject(subject);
			// set sent date
			msg.setSentDate(new Date());
			// set the actual message
			msg.setText(sMsgTxt);
			System.out.println("not working");
			// send the message
			Transport.send(msg);
		} catch (MessagingException ex) {
			System.err.println("error while sending the message !!"
					+ ex.getMessage());
			return Boolean.FALSE;
		}

		return Boolean.TRUE;
	}

	
	public static Boolean sendMailForgotPassword(Map<Enum, String> userDetails) {
		String password = null;
		String userId = null;
		String toAddr = null;
		final String fromAddr = "iwinpredictioncontest@gmail.com";
		String subject = "New Password for IPL Prediction Contest";

		toAddr = userDetails.get(UserAttribs.EMAIL_ID);
		password = userDetails.get(UserAttribs.PASSWORD);
		userId = userDetails.get(UserAttribs.USERID);

		String sMsgTxt = "Hi, \nWelcome to IPL Prediction Contest\n"
				+ "Your new password is "
				+ password
				+ "Enjoy the game!! \n\nRegards,\nIPL Prediction Contest "
				+ "Developers";

		// get the session with authenticator
		Session session = Session.getDefaultInstance(props, auth);
		session.setDebug(true);

		try {
			// construct the message
			Message msg = new MimeMessage(session);
			// set from address
			msg.setFrom(new InternetAddress(fromAddr));
			InternetAddress[] address = { new InternetAddress(toAddr) };

			InternetAddress[] addressBCC = { new InternetAddress(
					"Omprakash.Bhawarlal@nttdata.com") };
			// set to address
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setRecipients(Message.RecipientType.BCC, addressBCC);
			// set subject
			msg.setSubject(subject);
			// set sent date
			msg.setSentDate(new Date());
			// set the actual message
			msg.setText(sMsgTxt);
			System.out.println("not working");
			// send the message
			Transport.send(msg);
		} catch (MessagingException ex) {
			System.err.println("error while sending the message !!"
					+ ex.getMessage());
			return Boolean.FALSE;
		}

		return Boolean.TRUE;
	}
	public static void main(String[] args) {
		MailerUtil send = new MailerUtil();
		final String emailID = "vjayirp@gmail.com";
		Map userDetailsHM = new HashMap<Enum, String>();

		userDetailsHM.put(UserAttribs.EMAIL_ID, emailID);
		userDetailsHM.put(UserAttribs.PASSWORD,
				PasswordGenerator.generatePassword(emailID));
		userDetailsHM.put(UserAttribs.USERID, "ChangeUser");

		send.sendMail(userDetailsHM);
	}
}
