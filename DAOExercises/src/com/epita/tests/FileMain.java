package com.epita.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.List;

import com.epita.entities.User;

public class FileMain {
	
	
	public static final String FILENAME = "users.db";
	
	public static void main(String[] args) {
		
		User user = new User("Jean Lassalle", new Double(1.83), "11 rue de la republique", new Date());
		// user we want to create
		try {
			List<String> existingUsers = Files.readAllLines(Paths.get(FILENAME));
			// list of existing users in the file
			
			boolean alreadyExisting = false;
			// how to verify user isn"t already there
			for (String existingUser : existingUsers) {
				if (existingUser.contains(user.getName())) {
					// we check that the name matches or not the one we want to create
					alreadyExisting = true;
				}
			}
			
			if (!alreadyExisting)
				Files.write(Paths.get(FILENAME), user.toString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
