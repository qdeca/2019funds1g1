package com.epita.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.epita.services.Configuration;

public class LoginMain {
	

	private static final String LOGIN_PASSWORD = "login.password";
	private static final String LOGIN_USERNAME = "login.username";
	private static final int CREATE_OPTION = 1;
	private static final int UPDATE_OPTION = 2;
	private static final int DELETE_OPTION = 3;
	private static final int CONTINUE_OPTION = 1;
	private static final int STOP_OPTION = 2;


	

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		// create a login functionality with username and password
		System.out.println("Please enter your username : ");
		String username = scanner.nextLine();
		System.out.println("Please enter your password : ");
		String password = scanner.nextLine();
		if (login(username, password)) {
			System.out.println("You're connected");
			boolean continueProgram = true;
			while (continueProgram) {
				continueProgram = navigateInProgram(scanner);
			}
			
		} else {
			System.out.println("Wrong username or password");
		}
		scanner.close();
		
	}

	private static boolean login(String username, String password) {
		Configuration config = Configuration.getInstance();
		String validUsername = config.getPropertyValue(LOGIN_USERNAME);
		String validPassword = config.getPropertyValue(LOGIN_PASSWORD);
		if (validUsername == null)  {
			System.out.println("no login in config file");
			return false;
		} else if (validPassword == null) {
			System.out.println("no password in config file");
			return false;
		}
		return (validUsername.equals(username) 
				&& validPassword.equals(password));
	}



	private static boolean navigateInProgram(Scanner scanner) {
		try {
			boolean continueProgram = true;
			System.out.println("Press 1 to create, 2 to update and 3 to delete : ");
			int option = scanner.nextInt();
			switch (option) {
			case CREATE_OPTION 	: 
				System.out.println("You have succesfully created an object");
				break;
			case UPDATE_OPTION 	: 
				System.out.println("You have succesfully updated an object");
				break;
			case DELETE_OPTION 	: 
				System.out.println("You have succesfully deleted an object");
				break;
			default				:
				System.out.println("Bad input entered");
			}
			System.out.println("Press 1 to continue or 2 to stop");
			option = scanner.nextInt();
			if (CONTINUE_OPTION == option) {
				System.out.println("Let's try this again");
			} else if (STOP_OPTION == option) {
				System.out.println("Exiting program");
				continueProgram = false;
			} else {
				System.out.println("Bad input entered, exiting program");
				continueProgram = false;
			}
			return continueProgram;
		} catch(InputMismatchException e) {
			System.out.println("Bad input entered : " + e.getMessage());
		}
		return false;
	}
	
}
