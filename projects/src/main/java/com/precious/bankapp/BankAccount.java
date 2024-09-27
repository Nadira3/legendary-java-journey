package com.precious.bankapp;

import java.util.Scanner;

/**
 * Class to manage the bank account operations.
 */
class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0.00; // Initialize balance
    }
    
    public BankAccount(double balance) {
        this.balance = balance; // Initialize balance
    }

    // Deposits a valid amount into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! Your new balance is: $" + balance + "\n");
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive number.\n");
        }
    }

    // Withdraws a valid amount from the account if sufficient funds exist
    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawal successful! Your new balance is: $" + balance + "\n");
            } else {
                System.out.println("Insufficient balance. Cannot withdraw $" + amount + ".\n");
            }
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive number.\n");
        }
    }

    // Displays the current balance
    public void showBalance() {
        System.out.println("Your current balance is: $" + balance + ".\n");
    }

    // Getter for balance (if needed for future use)
    public double getBalance() {
        return balance;
    }
}
