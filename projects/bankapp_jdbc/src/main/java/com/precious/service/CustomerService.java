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
