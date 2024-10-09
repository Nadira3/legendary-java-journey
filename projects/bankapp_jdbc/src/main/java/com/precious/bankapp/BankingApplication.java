package com.precious.bankapp;

import com.precious.dao.*;
import com.precious.model.*;
import com.precious.service.*;
import com.precious.utils.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Main class to run the Banking Application.
 */

public class BankingApplication {

    private static BankAction bankAction = new BankAction();
    private static BankAccountDAO bankAccountDAO;
    private static CustomerService customerService;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (args.length < 2) {
            System.out.println("Usage: java -jar YourJavaApplication.jar <username> <password>");
            return;
        }
        
	String username = args[0];
        String password = args[1];

        DataBaseUtils dbUtils = new DataBaseUtils(username, password);
	customerService = new CustomerService(dbUtils);
        bankAccountDAO = new BankAccountDAO(dbUtils);
        while (true) {
            System.out.println("Welcome to the Bank!");
            System.out.println("1. Log in");
            System.out.println("2. Create new customer");
            System.out.println("3. Exit");
            int choice = InputUtils.getIntInput(scanner, "Enter choice: ");

            switch (choice) {
                case 1:
                    // Login flow
                    System.out.print("Enter Customer ID: ");
                    String customerId = scanner.nextLine();
                    Customer customer = customerService.getCustomerByID(customerId);

                    if (customer != null) {
                        System.out.println("Welcome, " + customer.getName());
                        CustomerSession session = new CustomerSession(bankAction, bankAccountDAO, customer, customerService, scanner);
                        session.start();
                    } else {
                        System.out.println("Customer not found. Please create an account.");
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
                    break;
            }
        }
    }

    private static void createCustomer(Scanner scanner) {
    
	    System.out.print("Enter your name: ");
	    String name = scanner.nextLine();
    
	    System.out.print("Enter your address: ");
	    String address = scanner.nextLine();
    
	    // Generate a unique customer ID using the UniqueIDGenerator class
	    String customerId = UniqueIDGenerator.generateAlphanumericId("CUST", 6);
	    // Create a new customer object
	    Customer newCustomer = new Customer(name, customerId, address);
    
	    // Add the new customer to the system
	    customerService.addCustomer(newCustomer);
    
	    // Output success message
	    System.out.println("Customer created successfully.");
	    System.out.println("Your Customer ID is: " + newCustomer.getId());

	}
}
