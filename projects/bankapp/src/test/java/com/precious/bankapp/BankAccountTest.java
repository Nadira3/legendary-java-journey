package com.precious.bankapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        // Set up an account with an initial balance of $100
        account = new BankAccount(100.0);
    }

    @Test
    public void testInitialBalance() {
        // Test that the initial balance is set correctly
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    public void testDeposit() {
        // Test depositing money
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        // Test withdrawing money
        account.withdraw(30.0);
        assertEquals(70.0, account.getBalance(), 0.001);
    }

    @Test
    public void testOverdraw() {
        // Test withdrawing more than the balance
        account.withdraw(200.0);
        assertEquals(100.0, account.getBalance(), 0.001); // Balance should remain unchanged
    }

    @Test
    public void testNegativeDeposit() {
        // Test that negative deposits are ignored
        account.deposit(-50.0);
        assertEquals(100.0, account.getBalance(), 0.001); // Balance should remain unchanged
    }

    @Test
    public void testNegativeWithdraw() {
        // Test that negative withdrawals are ignored
        account.withdraw(-30.0);
        assertEquals(100.0, account.getBalance(), 0.001); // Balance should remain unchanged
    }
}
