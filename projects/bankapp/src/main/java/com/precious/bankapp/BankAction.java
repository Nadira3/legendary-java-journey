package com.precious.bankapp;

import java.util.Scanner;
import java.util.ArrayList;
/**
 * Class to handle user actions and validate choices.
 */
class BankAction {

	// Validates if the response is between 1 and 4
	public boolean isValidOption(int option) {
        	return option >= 1 && option <= 6;
	}
	
    	// Creates a new bankaccount
	public BankAccount createAccount(Scanner scanner, String accountName) {
        	System.out.println("Which type of account will you like to open?");
        	System.out.println("Please select an option:");
	        System.out.println("1. Savings Account");
        	System.out.println("2. Checking Account");
	        System.out.println("3. Fixed Deposit Account");

		BankAccount account;
		// Validate if user input is of integer type
            	if (!scanner.hasNextInt()) {
                	System.out.println("Invalid input. Please enter a number between 1 and 3.\n");
                	scanner.next(); // Clear invalid input
            	}
	        System.out.print("Enter your choice: ");
		int response = scanner.nextInt();

		switch (response) {
			case 1:
				account = new SavingsAccount(accountName);
			case 2:
				account = new CheckingAccount(accountName);
			case 3:
				account = new FixedDepositAccount(accountName);
			default:
				account = new BankAccount(accountName);
		}
	    
		// it’s possible to return a SavingsAccount, CheckingAccount, or FixedDepositAccount while still having the method return a BankAccount.
		// This works because all three of those classes inherit from BankAccount. In object-oriented programming, this is called polymorphism
		return account;
    	}
    
	// Displays the menu options
	public void printOptions() {
        	System.out.println("Please select an option:");
	        System.out.println("1. Create Account");
	        System.out.println("2. Deposit Money");
        	System.out.println("3. Withdraw Money");
	        System.out.println("4. View Account Details");
        	System.out.println("5. View Account Balance");
	        System.out.println("6. Exit");
    	}

	// Displays account details
	public void displayAccountDetails(ArrayList<BankAccount> accountList) {
		for (BankAccount account : accountList)
		{
			System.out.println(account);
		}
	}
	
	// Checks if a user has a valid account
	public BankAccount queryAccountStatus(ArrayList<BankAccount> accountList, Scanner scanner) {
		BankAccount accountInUse = null;
		int choice;

		for (BankAccount account : accountList)
		{
			System.out.println(account);
			System.out.println("Will you like to perform an action with this account?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			
			System.out.print("Enter your choice: ");
			
			// Validate if user input is of integer type
            		while (!scanner.hasNextInt() ||(choice = scanner.nextInt()) < 1 || choice > 2) {
                		System.out.println("Invalid input. Please enter a number either 1 or 2.\n");
	                	scanner.next(); // Clear invalid input
	            	}

			switch (choice) {
				case 1:
					accountInUse = account;
					break;
				case 2:
					continue;
			}
		}
		return accountInUse;
	}
}
