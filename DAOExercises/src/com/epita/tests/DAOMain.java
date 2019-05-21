package com.epita.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOMain {
	
	public static void main(String[] args) {
		//readUsers();
		createUser();
		
		// TO READ   : SELECT
		// TO CREATE : INSERT INTO
		// TO DELETE : DELETE FROM
		// TO UPDATE : UPDATE 
	}

	private static void readUsers() {
		try {
			
			// CREATE TABLE USER(ID int primary key, NAME varchar(255), EMAIL varchar(255)
			// INSERT INTO USER VALUES (1, 'Testname', 'Testmail')
			
			Connection connection = DriverManager.getConnection("jdbc:h2:C:/Formation2019/db/h2DS", "sa", "");
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
	}

	
	private static void createUser() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:h2:C:/Formation2019/db/h2DS", "sa", "");
			PreparedStatement statement = connection.prepareStatement("INSERT INTO USER VALUES(?,?,?)"); // ? are parameters
			statement.setInt(1, 5); // first parameter is the value 5
			statement.setString(2, "NewName"); // second parameter is the value NewName
			statement.setString(3, "NewMail"); // third parameter is the value NewMail
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void updateUser() {
		// UPDATE USER SET NAME = ? WHERE ID = ?
	}
}
