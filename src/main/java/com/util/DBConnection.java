package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static String userName = "jcnywmlvhxyruk";
			
	private static String password = "e3c3792aead30717437ea35d0107ca26774c58077b8eba0601dec2cf0023cb6a";
	private static String connectionURL = "jdbc:postgresql://ec2-54-224-194-214.compute-1.amazonaws.com:5432/dcmcn6r3eoi8l?sslmode=require";
	private static String driverClass = "org.postgresql.Driver";

	public static Connection getDBConnection() {

		Connection conn = null;

		try {
			Class.forName(driverClass);

			conn = DriverManager.getConnection(connectionURL, userName, password);

			if (conn != null) {

				System.out.println("connected to db..");
			} else {

				System.out.println("connected to db..");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;

	}

	public static void main(String[] args) {

		DBConnection.getDBConnection();
	}

}
