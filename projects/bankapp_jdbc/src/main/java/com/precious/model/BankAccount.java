package com.precious.model;

import java.util.Scanner;

/**
 * Class to manage the bank account operations.
 */
public abstract class BankAccount {
    protected double balance;
    protected String accountNumber;
    protected String customerId;
    protected int typeId;

    public BankAccount(String accountNumber, double initialBalance, String customerId, int typeId) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.customerId = customerId;
        this.typeId = typeId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getBalance() {
        return balance;
    }

    public int getTypeId() {
        return typeId;
    }

    public abstract void deposit(double amount);

    public abstract boolean withdraw(double amount);

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Balance: " + balance;
    }
}
