package com.cognizant.moviecruiser.dao;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {

	static Connection getConnection() {
		BufferedInputStream bufferedInputStream = (BufferedInputStream) ConnectionHandler.class.getClassLoader()
				.getResourceAsStream("connection.properties");
		Properties properties = new Properties();
		try {
			properties.load(bufferedInputStream);
		} catch (IOException e) {
			System.out.println("Unable to load/find connection.properties file");
		}
		String driver = (String) properties.get("driver");

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load the mysql driver" + e.getMessage());
		}
		String user = (String) properties.get("user");
		String password = (String) properties.get("password");
		String url = (String) properties.get("connection-url");

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("Unable to connect to database");
		}

		return connection;
	}
}
