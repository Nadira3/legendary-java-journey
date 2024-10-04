package com.precious.bankapp.service;

import java.util.Scanner;
import java.util.ArrayList;
import com.precious.utils.*;
import com.precious.bankapp.model.*;
import com.precious.bankapp.dao.*;
import java.util.List;

/**
 * Class to handle user actions and validate choices.
 */

public class BankAction {

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

    // Example method for adding a customer (from the previous example)
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
    
    public static void transferFunds(BankAccount fromAccount, BankAccount toAccount, double amount) {
        if (fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed. Insufficient funds.");
        }
    }

    public static void closeAccount(BankAccount account, Customer customer) {
        customer.getAccounts().remove(account);
        System.out.println("Account closed successfully.");
    }
    
    public static void createAccount(Scanner scanner, Customer customer) {
        System.out.println("Account Types: 1. Checking 2. Savings 3. Fixed Deposit");
        int type = InputUtils.getIntInput(scanner, "Enter choice: ");

	String accountNumber = UniqueIDGenerator.generateAlphanumericId("ACCT-", 8);
        double initialBalance = 0.00;
        String prompt;

        switch (type) {
            case 1:
                customer.addAccount(new CheckingAccount(accountNumber, initialBalance));
                break;
            case 2:
                prompt = "Enter interest rate for savings account in percentage => 10% = 0.1: ";
        	double interestRate = InputUtils.getDoubleInput(scanner, prompt);
                customer.addAccount(new SavingsAccount(accountNumber, initialBalance, interestRate));
                break;
            case 3:
        	prompt = "Enter lock period for fixed deposit account (in months): ";
        	int lockPeriod = InputUtils.getIntInput(scanner, prompt);
                customer.addAccount(new FixedDepositAccount(accountNumber, initialBalance, lockPeriod));
                break;
            default:
                System.out.println("Invalid account type.");
        }

        System.out.println("Account created successfully.");
    }

    public static void performDeposit(Scanner scanner, Customer customer) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = customer.getAccount(accountNumber);

        if (account != null) {
            String prompt = "Enter amount to deposit: ";
            double amount = InputUtils.getDoubleInput(scanner, prompt);
            account.deposit(amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void performWithdrawal(Scanner scanner, Customer customer) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = customer.getAccount(accountNumber);

        if (account != null) {
            String prompt = "Enter amount to withdraw: ";
            double amount = InputUtils.getDoubleInput(scanner, prompt);
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void performTransfer(Scanner scanner, Customer customer) {
        System.out.print("Enter source account number: ");
        String fromAccountNumber = scanner.nextLine();
        BankAccount fromAccount = customer.getAccount(fromAccountNumber);

        System.out.print("Enter destination account number: ");
        String toAccountNumber = scanner.nextLine();
        BankAccount toAccount = customer.getAccount(toAccountNumber);

        if (fromAccount != null && toAccount != null) {
            String prompt = "Enter amount to transfer: ";
            double amount = InputUtils.getDoubleInput(scanner, prompt);
            BankAction.transferFunds(fromAccount, toAccount, amount);
        } else {
            System.out.println("Invalid account number(s).");
        }
    }

    public static void viewAccounts(Customer customer) {
        for (BankAccount account : customer.getAccounts()) {
            System.out.println(account);
        }
    }
}
