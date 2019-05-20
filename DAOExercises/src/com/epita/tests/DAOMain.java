package com.epita.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOMain {
	
	public static void main(String[] args) {
		try {
			
			// CREATE TABLE USER(ID int primary key, NAME varchar(255), EMAIL varchar(255)
			// INSERT INTO USER VALUES (1, 'Testname', 'Testmail')
			
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost:9093//C:/Formation2019/db/h2DS", "sa", "");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM USER WHERE ID=1");
			
			
			ResultSet result = statement.executeQuery();
			while(result.next()) {  // for all users in database
				int id = result.getInt(1); // get id (first column)
				String name = result.getString(2); // get name (second column)
				String email = result.getString(3); // get email (third column)
				System.out.println(id + " : " + name + " / " + email);
			}
			

		} catch (SQLException e) {
			System.out.println("Connection failed : " + e.getMessage());
		}
	
		
		// TO READ   : SELECT
		// TO CREATE : INSERT INTO
		// TO DELETE : DELETE FROM
		// TO UPDATE : UPDATE 
	}

}
