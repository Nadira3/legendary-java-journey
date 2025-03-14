package com.precious.model;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String customerId, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance, customerId, 2);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount + (amount * interestRate);
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
