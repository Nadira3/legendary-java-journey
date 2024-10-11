package com.precious.bankapp;
import com.precious.utils.InputUtils;

import java.util.Scanner;

/**
 * Class to manage a customer session after login.
 */
public class CustomerSession
{
	private Customer customer;
    	private BankAction bankAction;
    	private Scanner scanner; // Scanner passed from BankingApplication
    	private CustomerService customerService;

    	public CustomerSession(Customer customer, BankAction bankAction, Scanner scanner, CustomerService customerService)
	{
        	this.customer = customer;
        	this.bankAction = bankAction;
		this.customerService = customerService;
        	this.scanner = scanner; // Using the shared scanner
	}

    	// Start the session after login
    	public void start()
	{
        	while (true)
		{
            		System.out.println("\nCustomer Menu for " + customer.getName() + ":");
            		System.out.println("1. Create Account");
            		System.out.println("2. Deposit");
            		System.out.println("3. Withdraw");
           	 	System.out.println("4. Transfer Funds");
            		System.out.println("5. View Accounts");
            		System.out.println("6. Log Out");
            		int choice = InputUtils.getIntInput(scanner, "Enter choice: ");

            		switch (choice)
			{
				case 1:
					bankAction.createAccount(scanner, customer);
                    			break;
                		case 2:
                    			bankAction.performDeposit(scanner, customer);
                    			break;
                		case 3:
                    			bankAction.performWithdrawal(scanner, customer);
                    			break;
                		case 4:
                    			bankAction.performTransfer(scanner, customer, customerService);
                    			break;
                		case 5:
                    			bankAction.viewAccounts(customer);
                    			break;
                		case 6:
		    			customerService.updateCustomer(customer);
                    			System.out.println("Logging out...");
                    			System.out.println();
                    			return; // End session and go back to main menu
                		default:
                    			System.out.println("Invalid choice. Try again.");
            		}
        	}
    	}
}
