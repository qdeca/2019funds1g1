package com.epita.entities;

public class SavingsAccount {

	private double monthlyInterestRate;
	private double balance;
	
	
	
	
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
