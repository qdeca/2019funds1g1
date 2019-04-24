package com.epita.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.epita.services.Computing;

public class Main {
	

	public static void main(String[] toto) {
		System.out.println("Hello");
		double result;
		// static means independant of instance
		// which means no need to instanciantate an object of a class
		// to execute a static method of this class
		result = Computing.addition(30, 20);
		Computing computing = new Computing();
		double resultOfComputation = computing.computation();
		System.out.println("The result is : " + resultOfComputation);
	
	
		Scanner scanner = new Scanner(System.in);
		try { //this is a try-catch block, we will discuss it further
		    scanner.nextDouble();
		} catch (InputMismatchException e) {
		    System.out.println("Invalid Entry");
		}
	
	
	
	}
	

}
