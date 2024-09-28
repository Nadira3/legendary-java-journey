package com.precious.bankapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankActionTest {

    private BankAction account;

    @BeforeEach
    public void setUp() {
        // Set up an account with an initial balance of $100
        account = new BankAccount(100.0);
    }
}
