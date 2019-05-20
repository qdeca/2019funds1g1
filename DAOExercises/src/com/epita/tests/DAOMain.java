package com.epita.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOMain {
	
	public static void main(String[] args) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost:9093//C:/Formation2019/db/h2DS", "sa", "");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM USER WHERE ID=1");
			ResultSet result = statement.executeQuery();
			System.out.println(result);
		} catch (SQLException e) {
			System.out.println("Connection failed : " + e.getMessage());
		}
	
	}

}
