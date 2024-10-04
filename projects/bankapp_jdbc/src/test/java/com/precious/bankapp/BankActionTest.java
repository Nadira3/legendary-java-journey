package com.precious.bankapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class BankActionTest {

    @Test
    void testIsValidOption() {
        BankAction bankAction = new BankAction();
        
        // Test valid option
        assertTrue(bankAction.isValidOption(1));
        assertTrue(bankAction.isValidOption(6));
        
        // Test invalid option
        assertFalse(bankAction.isValidOption(0));
        assertFalse(bankAction.isValidOption(7));
    }

    @Test
    void testCreateAccount_SavingsAccount() {
        // Simulate user selecting Savings Account (1)
        Scanner scanner = new Scanner("1\n");
        BankAction bankAction = new BankAction();
        
        BankAccount account = bankAction.createAccount(scanner, "Alice");

        assertTrue(account instanceof BankAccount);
        assertEquals("Alice", account.getAccountName());
    }

    @Test
    void testCreateAccount_InvalidInput() {
        // Simulate invalid input followed by Savings Account selection
        Scanner scanner = new Scanner("invalid\n1\n");
        BankAction bankAction = new BankAction();
        
        BankAccount account = bankAction.createAccount(scanner, "Bob");

        assertTrue(account instanceof BankAccount);
        assertEquals("Bob", account.getAccountName());
    }

    @Test
    void testQueryAccountStatus_NoSelection() {
        BankAction bankAction = new BankAction();
        ArrayList<BankAccount> accountList = new ArrayList<>();
        accountList.add(new SavingsAccount("John"));
        accountList.add(new CheckingAccount("Jane"));

        // Simulate user responses (2 for "No")
        Scanner scanner = new Scanner("2\n2\n");
        BankAccount result = bankAction.queryAccountStatus(accountList, scanner);

        assertNull(result);  // No account selected
    }

    @Test
    void testQueryAccountStatus_ValidSelection() {
        BankAction bankAction = new BankAction();
        ArrayList<BankAccount> accountList = new ArrayList<>();
        accountList.add(new SavingsAccount("John"));
        accountList.add(new CheckingAccount("Jane"));

        // Simulate user selecting the first account (1 for "Yes")
        Scanner scanner = new Scanner("1\n");
        BankAccount result = bankAction.queryAccountStatus(accountList, scanner);

        assertNotNull(result);
        assertEquals("John", result.getAccountName());
    }

    @Test
    void testDisplayAccountDetails() {
        BankAction bankAction = new BankAction();
        ArrayList<BankAccount> accountList = new ArrayList<>();
        accountList.add(new SavingsAccount("Alice"));
        accountList.add(new CheckingAccount("Bob"));

        // In a real test, you could use System.out capture techniques
        // Here we'll just make sure the account list is properly populated
        assertDoesNotThrow(() -> bankAction.displayAccountDetails(accountList));
    }
}
