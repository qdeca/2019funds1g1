package com.epita.main;

import java.util.Scanner;

public class LoginMain {
	
	public static final String VALID_USERNAME = "admin";
	public static final String VALID_PASSWORD = "password";

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		// create a login functionality with username and password
		System.out.println("Please enter your username : ");
		String username = scanner.nextLine();
		System.out.println("Please enter your password : ");
		String password = scanner.nextLine();
		if (VALID_USERNAME.equals(username) 
				&& VALID_PASSWORD.equals(password)) {
		// && represents the logical AND
		// || represents the logical OR
		// ! represents the logical NOT
		// comparable to if (VALID_USERNAME== username) {
			System.out.println("You're connected");
		} else {
			System.out.println("Wrong username or password");
		}
		scanner.close();
		
	}
	
}
