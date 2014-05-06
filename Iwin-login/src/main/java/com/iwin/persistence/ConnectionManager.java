package com.iwin.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.iwin.utility.logging.LogWriter;

public class ConnectionManager
{


	static LogWriter logger = new LogWriter();

	public static Connection getConnection()
	{
//		final String PROTOCOL = "jdbc:derby:";
		final String PROTOCOL = "jdbc:mysql:";
		final String DB_NAME = "//ec2-50-19-213-178.compute-1.amazonaws.com:3306/iwin_ipl";
		Connection conn = null;

		try
		{
//			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Properties props = new Properties(); // connection properties
			props.put("user", "vijay_admin");
			props.put("password", "vijay");
			
			conn = DriverManager.getConnection(PROTOCOL + DB_NAME, props);
		}
		catch (InstantiationException e)
		{
			logger.error(e);
		}
		catch (IllegalAccessException e)
		{
			logger.error(e);
		}
		catch (ClassNotFoundException e)
		{
			logger.error(e);
		}
		catch (SQLException e)
		{
			logger.error(e);
		}

		return conn;
	}
}
