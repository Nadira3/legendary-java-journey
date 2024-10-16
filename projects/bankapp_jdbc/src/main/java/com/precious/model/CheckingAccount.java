package com.precious.model;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountNumber, double initialBalance, String customerId) {
        super(accountNumber, initialBalance, customerId, 1);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
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
