package com.iwin.persistence;

import java.sql.Connection;

public class DatabaseAccessImpl
{
	public void setUser()
	{
		
	}
	public static void main(String a[])
	{
		Connection connection=ConnectionManager.getConnection();
		System.out.println(connection);
	}
}

