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

public class BankAction {

    private static final String fileName = "customers.dat";

    public static boolean transferFunds(BankAccount fromAccount, BankAccount toAccount, double amount) {
        if (fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            System.out.println("Transfer successful.");
	    return true;
        } else {
            System.out.println("Transfer failed. Insufficient funds.");
	    return false;
        }
    }

    public static void closeAccount(BankAccount account, Customer customer) {
        customer.getAccounts().remove(account);
        System.out.println("Account closed successfully.");
    }
    
    public static void viewAccounts(Customer customer, BankAccountDAO bankAccountDAO) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts = bankAccountDAO.getAccounts(customer);

        for (BankAccount account: accounts)
            System.out.println(account);
    }
    
    public static void createAccount(Scanner scanner, Customer customer, BankAccountDAO bankAccountDAO) {
        System.out.println("Account Types: 1. Checking 2. Savings 3. Fixed Deposit");
        int type = InputUtils.getIntInput(scanner, "Enter choice: ");

	    String accountNumber = UniqueIDGenerator.generateAlphanumericId("ACCT", 8);
        BankAccount newAccount = null;
        double initialBalance = 0.00;
        String prompt;

        switch (type) {
            case 1:
                newAccount = new CheckingAccount(accountNumber, initialBalance, customer.getId());
		        System.out.println(customer.getAccounts());
                bankAccountDAO.addBankAccount(newAccount, customer);
                break;
            case 2:
                prompt = "Enter interest rate for savings account in percentage => 10% = 0.1: ";
        	    double interestRate = InputUtils.getDoubleInput(scanner, prompt);
                newAccount = new SavingsAccount(accountNumber, customer.getId(), initialBalance, interestRate);
		        System.out.println(customer.getAccounts());
                bankAccountDAO.addBankAccount(newAccount, customer);
                break;
            case 3:
        	    prompt = "Enter initial deposit amount: ";
        	    initialBalance = InputUtils.getDoubleInput(scanner, prompt);
        	    prompt = "Enter lock period for fixed deposit account (in months): ";
        	    int lockPeriod = InputUtils.getIntInput(scanner, prompt);
                newAccount = new FixedDepositAccount(accountNumber, customer.getId(), initialBalance, lockPeriod);
		        System.out.println(customer.getAccounts());
                bankAccountDAO.addBankAccount(newAccount, customer);
                break;
            default:
                System.out.println("Invalid account type.");
        }
	
        System.out.println("Account created successfully.");
    }

    public static void performDeposit(Scanner scanner, Customer customer, BankAccountDAO bankAccountDAO) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = customer.getAccount(customer.getId());

        if (account != null) {
            String prompt = "Enter amount to deposit: ";
            double amount = InputUtils.getDoubleInput(scanner, prompt);
            account.deposit(amount);
            bankAccountDAO.updateBankAccount(account, customer);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void performWithdrawal(Scanner scanner, Customer customer, BankAccountDAO bankAccountDAO) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = customer.getAccount(accountNumber);

        if (account != null) {
            String prompt = "Enter amount to withdraw: ";
            double amount = InputUtils.getDoubleInput(scanner, prompt);
            if (account.withdraw(amount)) {
                bankAccountDAO.updateBankAccount(account, customer);
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void performTransfer(Scanner scanner, Customer customer, CustomerService customerService, BankAccountDAO bankAccountDAO) {
	    boolean transactionStatus = false;
        System.out.print("Enter source account number: ");
        String fromAccountNumber = scanner.nextLine();
        BankAccount fromAccount = customer.getAccount(fromAccountNumber);

        System.out.print("Enter destination account number: ");
        String toAccountNumber = scanner.nextLine();
        BankAccount toAccount = customer.getAccount(toAccountNumber);

	Customer recipient = customerService.getCustomerByAccountNumber(toAccountNumber);
	if (toAccount == null)
		toAccount = recipient.getAccount(toAccountNumber);

        if (fromAccount != null && toAccount != null) {
            String prompt = "Enter amount to transfer: ";
            double amount = InputUtils.getDoubleInput(scanner, prompt);
            transactionStatus = BankAction.transferFunds(fromAccount, toAccount, amount);
        } else {
            System.out.println("Invalid account number(s).");
        }

	if (transactionStatus)
        bankAccountDAO.updateBankAccount(fromAccount, customer);
        bankAccountDAO.updateBankAccount(toAccount, recipient);
		customerService.updateCustomer(recipient);
    }
}
