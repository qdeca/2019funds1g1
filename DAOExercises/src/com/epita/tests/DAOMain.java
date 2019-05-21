package com.epita.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOMain {
	
	public static void main(String[] args) {
		//
//createUser();
//		readUsers();
		for (int id : searchUsersByMail("NewMail")) {
			System.out.println(id);
		}

	}

	private static void readUsers() {
		try {
			
			// CREATE TABLE USER(ID int primary key, NAME varchar(255), EMAIL varchar(255)
			// INSERT INTO USER VALUES (1, 'Testname', 'Testmail')
			
			Connection connection = DriverManager.getConnection("jdbc:h2:C:/Formation2019/db/h2DS", "sa", "");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM USER");
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
			statement.setInt(1, 7); // first parameter is the value 5
			statement.setString(2, "NewName"); // second parameter is the value NewName
			statement.setString(3, "NewMail"); // third parameter is the value NewMail
			statement.execute();
		} catch (SQLException e) {
			System.out.println("An exception occured while attempting to add a user : " + e.getMessage());
		}
		
	}
	
	private static void updateUser() {
		int idToModify = 5;
		String nameToModify = "Durand";

		try {
			Connection connection = DriverManager.getConnection("jdbc:h2:C:/Formation2019/db/h2DS", "sa", "");
			PreparedStatement statement = connection.prepareStatement("UPDATE USER SET NAME=? WHERE ID= ?");
			statement.setString(1, nameToModify);
			statement.setInt(2, idToModify);
			statement.execute();
		} catch (SQLException e) {
			System.out.println("An exception occured while attempting to update a user : " + e.getMessage());
		}
	}
	
	private static void deleteUser() {
		int idToDelete = 5;
		try {
			Connection connection = DriverManager.getConnection("jdbc:h2:C:/Formation2019/db/h2DS", "sa", "");
			PreparedStatement statement = connection.prepareStatement("DELETE FROM USER WHERE ID = ?");
			statement.setInt(1, idToDelete);
			statement.execute();
		} catch (SQLException e) {
			System.out.println("An exception occured while attempting to delete a user : " + e.getMessage());
		}
	}
	
	
	// TODO search users by mail
	// use SELECT instruction
	// return a list of ids
	private static List<Integer> searchUsersByMail(String email) {
		List<Integer> listResults = new ArrayList<>();
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:h2:C:/Formation2019/db/h2DS", "sa", ""); // establish connectio,
			PreparedStatement statement = connection.prepareStatement("SELECT ID FROM USER WHERE EMAIL=?"); // set up SQL instruction
			statement.setString(1, email); // add parameter to the instruction
			ResultSet result = statement.executeQuery(); // execute the query
			while(result.next()) {  // for all users in database matching the email
				int id = result.getInt(1); // get id 
				listResults.add(id);
			}
		} catch(SQLException e) {
			System.out.println("An exception occured while attempting to search the database : " + e.getMessage());
		}
		return listResults;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
