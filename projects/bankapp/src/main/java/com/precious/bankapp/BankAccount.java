package com.precious.bankapp;

import java.util.Scanner;
import java.io.Serializable;

/**
 * Class to manage the bank account operations.
 */
public abstract class BankAccount implements Serializable {
    protected double balance;
    protected String accountNumber;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);

    public abstract boolean withdraw(double amount);

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Balance: " + balance;
    }
}
