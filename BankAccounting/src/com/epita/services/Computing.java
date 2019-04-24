package com.epita.services;

import com.epita.entities.SavingsAccount;

public class Computing {

	double addition(double a, double b) {
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
		double amount = 7; // variable, type : double, name : amount
						// initialization to 7
		amount = 4;		// change of value to 4
		SavingsAccount account = new SavingsAccount(); // variable,
								// type : SavingsAccount
								// name : toto
								// initialization ??
		account.setBalance(500);
		account.withdraw(amount);
		account.getBalance(); // will return 496
		
		account.setBalance(1000);
		account.setMonthlyInterestRate(1.01);
		account.computeYearlyInterest();
		account.getBalance(); // will return 1000*1.01*12

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
