package com.iwin.utility;

import java.util.Random;

public class PasswordGenerator
{
	public static String generatePassword(String emailId)
	{
		String password = null;
		
		password = emailId.substring(0, emailId.indexOf("."));
		
		password = password+new Random().nextInt(99);
        
        return password;
	}
}
