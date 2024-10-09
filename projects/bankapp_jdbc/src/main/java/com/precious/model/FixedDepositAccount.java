package com.precious.model;

public class FixedDepositAccount extends BankAccount {
    private int lockPeriod;

    public FixedDepositAccount(String accountNumber, double initialBalance, int lockPeriod) {
        super(accountNumber, initialBalance);
        this.lockPeriod = lockPeriod;
    }

    @Override
    public void deposit(double amount) {
        // Fixed deposit account may not allow additional deposits
        throw new UnsupportedOperationException("Cannot deposit into a fixed deposit account");
    }

    @Override
    public boolean withdraw(double amount) {
        // Fixed deposit account may restrict withdrawals
        throw new UnsupportedOperationException("Cannot withdraw before lock period expires");
    }
}
