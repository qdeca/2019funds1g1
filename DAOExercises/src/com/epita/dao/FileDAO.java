package com.epita.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import com.epita.entities.User;

public class FileDAO {
	
	
	public static final String USERS_FILENAME = "users.db";
	
	public void createUser(User user) {
		try {
			Files.write(Paths.get(USERS_FILENAME), user.toString().getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
			// write a new line into the file corresponding to the user.toString() method which gives all the characteristics of a user
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String searchUserByName(String name) {

		try {
			List<String> userList = Files.readAllLines(Paths.get(USERS_FILENAME)); // get all users from the file
			for (String user : userList) { // for each user
				if (user.contains(name)) { // see if the name matches the one in parameter
					return user; // if so, return the user
				}
			}
		} catch( NoSuchFileException nsfe) {
			System.out.println("Create a file first ! ");
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;  // otherwise, return null
	}
	
	public List<String> searchUsersByHeight(double height) {
		List<String> matchingUsers = new ArrayList<>();
		try {
			List<String> userList = Files.readAllLines(Paths.get(USERS_FILENAME));// get all users from the file
			for (String user : userList) { // for each user
				if (user.contains(Double.toString(height))) { // see if the height matches the one in parameter
					matchingUsers.add(user); // if so, add it to the matching users list
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return matchingUsers; // return the list of matching users
	}
	
	public void deleteUser(User userToDelete) {
		List<String> userList;
		try {
			userList = Files.readAllLines(Paths.get(USERS_FILENAME));// get all users from the file
			int index = -1;
			for (String user : userList) { // for each user
				if (user.contains(userToDelete.getName())) { // see if the name matches the one in parameter
					  index = userList.indexOf(user);
				}
			}
			if (index >= 0) userList.remove(index);
			// recreate the file by deleting it then recreating it with the same list minus the deleted user
			Files.delete(Paths.get(USERS_FILENAME));
			for (String user : userList) {
				Files.write(Paths.get(USERS_FILENAME), user.toString().getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public void updateUser(User userToUpdate) { // changes characteristics of given user to new adress present in userToUpdate
		deleteUser(userToUpdate); // delete the user with old information
		createUser(userToUpdate); // create the user wirth updated information
	}
	
	

}
