package com.precious.bankapp;
import com.precious.utils.InputUtils;
import com.precious.utils.UniqueIDGenerator;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Main class to run the Banking Application.
 */

public class BankingApplication 
{
	private static BankAction bankAction = new BankAction();
    	private static CustomerService customerService = new CustomerService();

    	public static void main(String[] args) 
	{
        	Scanner scanner = new Scanner(System.in);

        	while (true)
		{
            		System.out.println("Welcome to the Bank!");
            		System.out.println("1. Log in");
            		System.out.println("2. Create new customer");
	            	System.out.println("3. Exit");
            		int choice = InputUtils.getIntInput(scanner, "Enter choice: ");

            		switch (choice)
			{
                		case 1:
                    			// Login flow
                    			System.out.print("Enter Customer ID: ");
                    			String customerId = scanner.nextLine();
                    			Customer customer = customerService.getCustomerByID(customerId);

                    			if (customer != null)
					{
                        			System.out.println("Welcome, " + customer.getName());
                        			CustomerSession session = new CustomerSession(customer, bankAction, scanner, customerService);
                        			session.start();
                    			}
					else
					{
                        			System.out.println("Customer not found. Please create an account.");
                        			System.out.println();
                    			}
                    			break;

                		case 2:
                    			// Create new customer
                    			createCustomer(scanner);
                    			break;

                		case 3:
                    		System.out.println("Thank you for using the Bank!");
                    		return;

                		default:
                    			System.out.println("Invalid choice. Try again.");
                        		System.out.println();
                    			break;
            		}
        	}
	}

	private static void createCustomer(Scanner scanner)
	{
		System.out.print("Enter your name: ");
	    	String name = scanner.nextLine();
    
	    	System.out.print("Enter your address: ");
	    	String address = scanner.nextLine();
    
	    	// Generate a unique customer ID using the UniqueIDGenerator class
	    	String customerId = UniqueIDGenerator.generateAlphanumericId("CUST", 6);
	    	// Create a new customer object
	    	Customer newCustomer = new Customer(name.trim(), customerId, address.trim());
    
	    	// Add the new customer to the system
	    	customerService.addCustomer(newCustomer);
    
	    	// Output success message
	    	System.out.println("Customer created successfully.");
	    	System.out.println("Your Customer ID is: " + newCustomer.getId());
	    	System.out.println();
	}
}
