package com.precious.bankapp;

/**
 * Class to handle user actions and validate choices.
 */
class BankAction {

    // Validates if the response is between 1 and 4
    public boolean isValidOption(int option) {
        return option >= 1 && option <= 4;
    }

    // Displays the menu options
    public void printOptions() {
        System.out.println("Welcome to the Simple Banking Application!");
        System.out.println("Please select an option:");
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. View Balance");
        System.out.println("4. Exit");
    }
}
