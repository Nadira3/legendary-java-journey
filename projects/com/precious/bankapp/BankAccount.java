package com.precious.bankapp;
import java.util.Scanner;

class BankAccount
{
	double balance = 0.00; // Stores the user's current balance.
	int amount; // Temporary variable to store the amount for transactions.
	
	/**
	 * Prints the available options for the banking application.
	 */
	public void printOptions()
	{
		System.out.println("Welcome to the Simple Banking Application!\nPlease select an option:\n1. Deposit Money\n2. Withdraw Money\n3. View Balance\n4. Exit");
	}

	/**
	 * Takes the user's response and performs the corresponding action.
	 * @param response The user's selected option.
	 * @param myObj The Scanner object used for user input.
	 * @return A boolean indicating whether the application should continue running.
	 */
	public boolean takeResponse(int response, Scanner myObj)
	{
		BankAction action = new BankAction(); // Create a new BankAction instance.

		switch (response) {
			case 1:
				System.out.print("Enter the amount to deposit: $");
				amount = myObj.nextInt();
				balance = action.deposit(amount, balance); // Deposit the amount.
				break;
			case 2:
				System.out.print("Enter the amount to withdraw: $");
				amount = myObj.nextInt();
				balance = action.withdraw(amount, balance); // Withdraw the amount.
				break;
			case 3:
				action.show(balance); // Show the current balance.
				break;
			case 4:
				System.out.println("Bye!");
				break;
			default:
				System.out.println("Enter a valid option from 1 - 4\n");
		}

		return response != 4 ? true : false; // Continue unless the user chooses to exit.
	}
}
