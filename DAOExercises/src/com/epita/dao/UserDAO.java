package com.epita.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.epita.entities.User;
import com.epita.utils.Configuration;

public class UserDAO {
	
	private final Configuration config = Configuration.getInstance();
	
	private final String JDBC_PASSWORD = config.getPropertyValue("jdbc_password");
	private final String JDBC_USER = config.getPropertyValue("jdbc_user");
	private final String JDBC_URI = config.getPropertyValue("jdbc_uri");


	private Connection initConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URI, JDBC_USER, JDBC_PASSWORD);
	}
	
	public void createUser(User user) {
		try {
			//Connection connection = initConnection();
			Connection connection = DriverManager.getConnection("jdbc:h2:C:/Formation2019/db/h2DS", "sa", "");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

			PreparedStatement statement = connection.prepareStatement("INSERT INTO USER(NAME, HEIGHT, ADRESS, BIRTHDATE) VALUES(?,?,?,?)");
			statement.setString(1, user.getName());
			statement.setDouble(2, user.getHeight());
			statement.setString(3, user.getAdress());
			statement.setString(4, sdf.format(user.getBirthdate()));
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public List<User> searchUsersByName(String username) {
		List<User> listUsers = new ArrayList<>();
		try {
			Connection connection = initConnection();
			//Connection connection = DriverManager.getConnection("jdbc:h2:C:/Formation2019/db/h2DS", "sa", "");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM USER WHERE NAME = ?");
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			while(result.next()) {  // for all users in database
				int id = result.getInt(1); // get id (first column)
				String name = result.getString(2); // get name (second column)
				double height = result.getDouble(3); 
				String adress = result.getString(4); 
				Date date = (Date) sdf.parse(result.getString(5)); 
				User user = new User(name, height, adress, date);
				listUsers.add(user);
			}
		} catch (SQLException e) {
			System.out.println("Connection failed : " + e.getMessage());
		} catch (ParseException pe) {
			System.out.println("Parse failed : " + pe.getMessage());
			
		}
		
		return listUsers;  
	}
	
	public List<String> searchUsersByHeight(double height) {
		return null; //TODO 
	}
	
	public void deleteUser(User userToDelete) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:h2:C:/Formation2019/db/h2DS", "sa", "");
			PreparedStatement statement = connection.prepareStatement("DELETE FROM USER WHERE NAME= ? and HEIGHT=? and ADRESS = ?");
			statement.setString(1, userToDelete.getName());
			statement.setDouble(2, userToDelete.getHeight());
			statement.setString(3, userToDelete.getAdress());
			statement.execute();
		} catch (SQLException e) {
			System.out.println("An exception occured while attempting to update a user : " + e.getMessage());
		}

	}
	
	
	public void updateUserAdress(User userToUpdate) { // changes characteristics of given user to new adress present in userToUpdate
		try {
			Connection connection = DriverManager.getConnection("jdbc:h2:C:/Formation2019/db/h2DS", "sa", "");
			PreparedStatement statement = connection.prepareStatement("UPDATE USER SET ADRESS=? WHERE NAME= ? AND HEIGHT = ?");
			statement.setString(1, userToUpdate.getAdress());
			statement.setString(2, userToUpdate.getName());
			statement.setDouble(3, userToUpdate.getHeight());
			statement.execute();
		} catch (SQLException e) {
			System.out.println("An exception occured while attempting to update a user : " + e.getMessage());
		}

	}

}
