package com.epita.services;

import com.epita.entities.SavingsAccount;

public class Computing {
	
	public static double CONSTANT = 5;

	public static double addition(double a, double b) {
		return a+b;  // this is a comment
		/* 
		this
		is
		several
		lines
		of
		comment
		 */
		

	}
	
	
	public double computerYearlyInterest(double balance, double yearlyInterestRate) {
		

		return balance * yearlyInterestRate;
	}
	
	public double computation() {
		double a = 5;
		double b = 8;
		b += 2;
		a = 3;
		return a * b;
	}
	
}
