package com.precious.service;

import com.precious.dao.*;
import com.precious.model.*;
import com.precious.utils.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class to handle user actions and validate choices.
 */

public class CustomerService {

    private static final String fileName = "customers.dat";
    private CustomerDAO customerDAO;

    public CustomerService(DataBaseUtils dbUtils) {
	    this.customerDAO = new CustomerDAO(dbUtils);
    }

    public Customer createCustomer(Scanner scanner) {
    
	    System.out.print("Enter your name: ");
	    String name = scanner.nextLine();
    
	    System.out.print("Enter your address: ");
	    String address = scanner.nextLine();
    
	    // Generate a unique customer ID using the UniqueIDGenerator class
	    String customerId = UniqueIDGenerator.generateAlphanumericId("CUST", 6);
	    // Create a new customer object
	    Customer newCustomer = new Customer(name, customerId, address);
    
	    // Add the new customer to the system
	    customerDAO.addCustomer(newCustomer);
    
	    // Output success message
	    System.out.println("Customer created successfully.");
	    System.out.println("Your Customer ID is: " + newCustomer.getId());

        return newCustomer;
	}
    
    // Method to retrieve a customer by their ID
    public Customer getCustomerByID(String customerID) {
	    Customer customer = customerDAO.getCustomerById(customerID);
	    if (customer == null)
        // If no customer is found, return null or handle the case as needed
	        System.out.println("No customer found with ID: " + customerID);
        return customer;
    }

    // Method to retrieve a customer by their account number
    public Customer getCustomerByAccountNumber(String accountNumber) {
	    Customer customer = customerDAO.getCustomerByAccountNumber(accountNumber);
	    if (customer == null)
        // If no customer is found, return null or handle the case as needed
	        System.out.println("No customer found with account number: " + accountNumber);
        return customer;

    }

    public void addCustomer(Customer customer) {
        // Read the current list of customers from the database
	    customerDAO.addCustomer(customer);
        System.out.println("Customer added successfully.");
    }

    public void updateCustomer(Customer updatedCustomer) {
        // Read the current list of customers from the database
	    customerDAO.updateCustomer(updatedCustomer);
        System.out.println("Customer updated successfully.");
    }
} 
