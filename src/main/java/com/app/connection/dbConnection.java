package com.app.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class dbConnection {
	private static Connection con;
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook","root","root");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
}
