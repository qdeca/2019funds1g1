package com.epita.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String wantedDateFormat = "yyyy/MM/dd";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a date of the following format : " + wantedDateFormat);
		SimpleDateFormat sdf = new SimpleDateFormat(wantedDateFormat);
		String userInput = scanner.nextLine();
		// how to check that the userInput is of the right format ?
		String yearInput = userInput.substring(0, 4);
		String monthInput = userInput.substring(5, 7);
		String dayInput = userInput.substring(8, 10);

		try {
			
			sdf.setLenient(false);
			sdf.parse(userInput);
//			Integer.parseInt(yearInput);
//			Integer.parseInt(monthInput);
//			Integer.parseInt(dayInput);
//			if (userInput.charAt(4) != '/' || userInput.charAt(7) != '/') {
//				System.out.println("Wrong separator.");
//				return;
//			}
			System.out.println("Correct !");
		} catch (NumberFormatException nfe) {
			System.out.println("Incorrect format given.");
		} catch (ParseException pe) {
			System.out.println("Incorrect format given.");
			
		}
		

	}
}
