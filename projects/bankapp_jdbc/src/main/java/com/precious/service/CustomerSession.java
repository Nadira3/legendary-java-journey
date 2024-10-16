package com.precious.service;

import com.precious.dao.*;
import com.precious.model.*;
import com.precious.utils.*;

import java.util.Scanner;

/**
 * Class to manage a customer session after login.
 */
public class CustomerSession {

    private Customer customer;
    private CustomerService customerService;
    private BankAction bankAction;
    private BankAccountDAO bankAccountDAO;
    private Scanner scanner; // Scanner passed from BankingApplication

    public CustomerSession(BankAction bankAction, BankAccountDAO bankAccountDAO, Customer customer, CustomerService customerService, Scanner scanner) {
        this.bankAction = bankAction;
        this.customer = customer;
	this.customerService = customerService;
	this.bankAccountDAO = bankAccountDAO;
        this.scanner = scanner; // Using the shared scanner
    }

    // Start the session after login
    public void start() {
        while (true) {
            System.out.println("\nCustomer Menu for " + customer.getName() + ":");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer Funds");
            System.out.println("5. View Accounts");
            System.out.println("6. Log Out");
            System.out.print("Enter your choice: ");
            int choice = InputUtils.getIntInput(scanner, "Enter choice: ");

            switch (choice) {
                case 1:
                    bankAction.createAccount(scanner, customer, bankAccountDAO);
                    break;
                case 2:
                    bankAction.performDeposit(scanner, customer, bankAccountDAO);
                    break;
                case 3:
                    bankAction.performWithdrawal(scanner, customer, bankAccountDAO);
                    break;
                case 4:
                    bankAction.performTransfer(scanner, customer, customerService, bankAccountDAO);
                    break;
                case 5:
                    bankAction.viewAccounts(customer, bankAccountDAO);
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return; // End session and go back to main menu
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
