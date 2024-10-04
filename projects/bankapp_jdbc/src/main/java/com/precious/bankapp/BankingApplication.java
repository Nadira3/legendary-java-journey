package com.precious.bankapp;
import com.precious.bankapp.dao.*;
import com.precious.bankapp.model.*;
import com.precious.bankapp.service.*;
import com.precious.utils.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Main class to run the Banking Application.
 */

public class BankingApplication {

    private static BankAction bankAction = new BankAction();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
                    Customer customer = bankAction.getCustomerByID(customerId);

                    if (customer != null) {
                        System.out.println("Welcome, " + customer.getName());
                        CustomerSession session = new CustomerSession(customer, bankAction, scanner);
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
	    bankAction.addCustomer(newCustomer);
    
	    // Output success message
	    System.out.println("Customer created successfully.");
	    System.out.println("Your Customer ID is: " + newCustomer.getId());

	}
}
