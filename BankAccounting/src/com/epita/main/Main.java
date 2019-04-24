package com.epita.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.epita.entities.SavingsAccount;
import com.epita.services.Computing;

public class Main {
	

	public static void main(String[] toto) {
		System.out.println("Hello");
		double result;
		// static means independant of instance
		// which means no need to instanciantate an object of a class
		// to execute a static method of this class
//		result = Computing.addition(30, 20);
//		Computing computing = new Computing();
//		double resultOfComputation = computing.computation();
//		System.out.println("The result is : " + resultOfComputation);
	
	
		Scanner scanner = new Scanner(System.in);
		try { //this is a try-catch block, we will discuss it further
		    SavingsAccount account = new SavingsAccount(); // step 1
			account.setBalance(500); // step 2
			//SavingsAccount account = new SavingsAccount(500); // alternate steps 1 & 2
			System.out.println("Please enter amount to withdraw from your account");
			double amountToWithdraw = scanner.nextDouble(); // step 3
			account.withdraw(amountToWithdraw); // step 4
			System.out.println("Your new balance is : " + account.getBalance()); // step 5
		} catch (InputMismatchException e) {
		    System.out.println("Invalid Entry");
		}
	
	
	
	}
	

}
