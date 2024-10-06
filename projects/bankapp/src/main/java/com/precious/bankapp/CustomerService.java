package com.precious.bankapp;

import java.util.Scanner;
import java.util.ArrayList;
import com.precious.utils.FileUtils;
import com.precious.utils.UniqueIDGenerator;
import com.precious.utils.InputUtils;
import java.util.List;

/**
 * Class to handle user actions and validate choices.
 */

public class CustomerService {

    private static final String fileName = "customers.dat";

    // Method to retrieve a customer by their ID
    public Customer getCustomerByID(String customerID) {
        // Read the current list of customers from the file
        List<Customer> customers = FileUtils.readObjectsFromFile(fileName);

        // Search for the customer with the given ID using the utility method
        for (Customer customer : customers) {
            if (customer.getId().equals(customerID)) {
                System.out.println("Customer found: " + customer.getName());
                return customer;  // Return the found customer
            }
        }

        // If no customer is found, return null or handle the case as needed
        System.out.println("No customer found with ID: " + customerID);
        return null;
    }

    // Method to retrieve a customer by their account number
    public static Customer getCustomerByAccountNumber(String accountNumber) {
        // Read the current list of customers from the file
        List<Customer> customers = FileUtils.readObjectsFromFile(fileName);
    	List<BankAccount> accounts;

        // Search for the customer with the given ID using the utility method
        for (Customer customer : customers) {
		accounts = customer.getAccounts();
		for (BankAccount account : accounts)
		{
			if (account.getAccountNumber().equals(accountNumber))
				return customer;
		}
        }
	return null; // account not found
    }

    public void addCustomer(Customer customer) {
        // Read the current list of customers from the file
        List<Customer> customers = FileUtils.readObjectsFromFile(fileName);

        // Check if the customer ID is unique using the utility method
	if (!FileUtils.isIdentifierUnique(customers, (existingCustomer, id) -> existingCustomer.getId().equals(id), customer.getId())) {
            System.out.println("Customer ID already exists. Please choose a different ID.");
            return;
        }

        // Add the new customer and write the updated list back to the file
        customers.add(customer);
        FileUtils.writeObjectsToFile(fileName, customers);

        System.out.println("Customer added successfully.");
    }

    public void updateCustomer(Customer updatedCustomer) {
        // Read the current list of customers from the file
        List<Customer> customers = FileUtils.readObjectsFromFile(fileName);

	for (int i = 0; i < customers.size(); i++)
	{
		Customer oldCustomer = customers.get(i);
		if (oldCustomer.getId().equals(updatedCustomer.getId())) {
			customers.set(i, updatedCustomer);
	        	FileUtils.writeObjectsToFile(fileName, customers);
        		System.out.println("Customer updated successfully.");
			break;
		}
	}

    }
} 
