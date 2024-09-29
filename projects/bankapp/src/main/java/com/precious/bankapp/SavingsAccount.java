package com.precious.bankapp;

class SavingsAccount extends BankAccount {
	private double interestRate;

	public SavingsAccount() {
		super();
		interestRate = 0.1; // set interest rate to 10% if not specified
	}

	public SavingsAccount(String accountName) {
		this(0.1, accountName);
	}
	
	public SavingsAccount(double interestRate, String accountName) {
		super(accountName);
		this.interestRate = interestRate;
	}

	public double calculateInterest() {
    		return this.getBalance() * (this.interestRate / 100);
	}

	// Getter for interestRate 
	public double getInterestRate() {
		return this.interestRate;
	}
	
	// Setter for interestRate 
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
}
