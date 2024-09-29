package com.precious.bankapp;

import java.util.Scanner;

/**
 * Class to manage the bank account operations.
 */
class BankAccount {
    
	private double accountBalance;
	private String accountName;
	private String accountNumber;

    	public BankAccount() {
        	this.accountBalance = 0.00; // Initialize accountBalance
	        this.accountName = "Unknown"; // Initialize accountName if not set
		this.accountNumber = generateAccountNumber();
	}
    
	public BankAccount(String accountName) {
		this(0.00, accountName); // Initialize accountName with default account accountBalance using chain construction.
	}

	public BankAccount(double accountBalance, String accountName) {
		this.accountBalance = accountBalance; // Initialize accountBalance
        	this.accountName = accountName; // Initialize accountName
	        this.accountNumber = generateAccountNumber();
	}

    
	private String generateAccountNumber() {
		long randomNum = (long) (Math.random() * 10000000000L); // Generate random 10-digit number

		return String.format("%010d", randomNum); // Ensure it's always 10 digits, padded with zeros if necessary 
	}

    
	// Deposits a valid amount into the account
	public void deposit(double amount) {
		if (amount > 0) {
			this.accountBalance += amount;
            		System.out.println("Deposit successful! Your new accountBalance is: $" + this.accountBalance + "\n");
		} else {
			System.out.println("Invalid deposit amount. Please enter a positive number.\n");
		}
	}

	// Withdraws a valid amount from the account if sufficient funds exist
	public void withdraw(double amount) {
		if (amount > 0) {
			if (this.getBalance() >= amount) {
				this.accountBalance -= amount;
				System.out.println("Withdrawal successful! Your new accountBalance is: $" + this.accountBalance + "\n");
            		} else {
				System.out.println("Insufficient accountBalance. Cannot withdraw $" + amount + ".\n");
			}
        	} else {
			System.out.println("Invalid withdrawal amount. Please enter a positive number.\n");
        	}
	}

	// Getter for accountBalance (if needed for future use)
	public double getBalance() {
		return this.accountBalance;
	}
	
	// Setter for accountBalance (if needed for future use)
	public void setBalance(double amount) {
		this.accountBalance = amount;
	}
    
	// Getter for accountName (if needed for future use)
	public String getName() {
		return this.accountName;
	}
    
	// Setter for accountName (if needed for update)
	public void setName(String accountName) {
		this.accountName = accountName;
	}
    
	// Getter for accountNumber (if needed for future use)
	public String getAccountNumber() {
        	return this.accountNumber;
	}

	@Override
	public String toString() {
		return "BankAccount{" +
			"accountName='" + accountName + '\'' +
			", accountNumber='" + accountNumber + '\'' +
			", accountBalance=" + String.format("%.2f", accountBalance) +
			'}';

	}
}
