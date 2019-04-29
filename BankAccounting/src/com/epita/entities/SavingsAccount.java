package com.epita.entities;

public class SavingsAccount extends Account {

	private double monthlyInterestRate;

	
	
	
	
	public SavingsAccount() {
	}
	
	

	public SavingsAccount(double balance) {
		this.balance = balance;
	}



	public SavingsAccount(double monthlyInterestRate, double balance) {
		this.monthlyInterestRate = monthlyInterestRate;
		this.balance = balance;
	}

	public double computeYearlyInterest() {

		double yearlyInterestRate = this.monthlyInterestRate * 12;
		// create variable equal to 12 times the interest rate
		//this.balance = this.balance * yearlyInterestRate;
		this.balance *= yearlyInterestRate;
		return this.balance;
	}
	
	public double withdraw(double amount) {
		int balance = 50;
		switch (balance) {
		case 50 : System.out.println("you have 50€");
					break;
		case 100 : System.out.println("you have 100€");
					break;
		default : System.out.println("amount of money not known");
		}
		//this.balance = this.balance - amount;
		this.balance -= amount;
		// assign balance minus amount to balance
		return this.balance;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getMonthlyInterestRate() {
		return monthlyInterestRate;
	}

	public void setMonthlyInterestRate(double monthlyInterestRate) {
		this.monthlyInterestRate = monthlyInterestRate;
	}
	
	
}
