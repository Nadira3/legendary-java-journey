package com.precious.bankapp;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Main class to run the Banking Application.
 */
public class BankingApplication {

    
	public static void main(String[] args) {
        
		Scanner scanner = new Scanner(System.in);  // Single Scanner instance
		BankAction action = new BankAction();
		BankAccount account;
		ArrayList<BankAccount> accountList = new ArrayList<>();
        	boolean running = true;

		System.out.println("Welcome to the Simple Banking Application!");
	        System.out.print("Please enter your name: ");
		String accountName = scanner.nextLine(); // Get the account holder's name   

        
		// Main loop to keep the application running until the user exits
		while (running) {
			action.printOptions(); // Show the options menu
			System.out.print("Enter your choice: ");

            		// Validate if user input is of integer type
            		if (!scanner.hasNextInt()) {
				System.out.println("Invalid input. Please enter a number between 1 and 6.\n");
				scanner.next(); // Clear invalid input
				continue;
			}

			int choice = scanner.nextInt();

			// Validate option choice (1-4)
			if (!action.isValidOption(choice)) {
				System.out.println("Please enter a valid number from 1 to 6.\n");
				continue;
			}

			// Handle each action based on user choice
			switch (choice)
			{
				case 1:
					account = action.createAccount(scanner, accountName); // Create bank account with user's name
					accountList.add(account);
					System.out.println(account);
					break;
		    
				case 2: // Deposit
					account = action.queryAccountStatus(accountList, scanner);
					if (account == null)
					{
						account = action.createAccount(scanner, accountName); // Create bank account with user's name
						accountList.add(account);
					}
					System.out.print("Enter the amount to deposit: $");
					if (scanner.hasNextDouble()) {
						double depositAmount = scanner.nextDouble();
						account.deposit(depositAmount);
					} else {
						System.out.println("Invalid input. Please enter a valid amount.\n");
						scanner.next(); // Clear invalid input
					}
					break;
		    
				case 3: // Withdraw
					account = action.queryAccountStatus(accountList, scanner);
					if (account == null)
					{
						account = action.createAccount(scanner, accountName); // Create bank account with user's name
						accountList.add(account);
					}
					System.out.print("Enter the amount to withdraw: $");
					if (scanner.hasNextDouble()) {
						double withdrawAmount = scanner.nextDouble();
						account.withdraw(withdrawAmount);
					} else {
						System.out.println("Invalid input. Please enter a valid amount.\n");
						scanner.next(); // Clear invalid input
					}
					break;
		
				case 4: // View Account Details
					action.displayAccountDetails(accountList);
					break;
		    
				case 5: // View Account Balance
					account = action.queryAccountStatus(accountList, scanner);
					if (account == null)
					{
						account = action.createAccount(scanner, accountName); // Create bank account with user's name
						accountList.add(account);
					}
					double accountBalance = account.getBalance();
					System.out.println("Your current accountBalance is: $" + accountBalance + ".\n");
					break;
		    
				case 6: // Exit     
					System.out.println("Thank you for using the Simple Banking Application. Goodbye!");
					running = false;
					break;

				default:
					System.out.println("Unknown error. Please try again.");
			}
		}

		scanner.close(); // Close the scanner when done
	}
}
