package com.precious.bankapp;
import java.util.Scanner;

/**
 * Main class to run the Banking Application.
 */
public class BankingApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Single Scanner instance
        BankAccount account = new BankAccount();
        BankAction action = new BankAction();
        boolean running = true;

        // Main loop to keep the application running until the user exits
        while (running) {
            action.printOptions(); // Show the options menu
            System.out.print("Enter your choice: ");

            // Validate if user input is of integer type
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.\n");
                scanner.next(); // Clear invalid input
                continue;
            }

            int choice = scanner.nextInt();

            // Validate option choice (1-4)
            if (!action.isValidOption(choice)) {
                System.out.println("Please enter a valid number from 1 to 4.\n");
                continue;
            }

            // Handle each action based on user choice
            switch (choice) {
                case 1: // Deposit
                    System.out.print("Enter the amount to deposit: $");
                    if (scanner.hasNextDouble()) {
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Invalid input. Please enter a valid amount.\n");
                        scanner.next(); // Clear invalid input
                    }
                    break;

                case 2: // Withdraw
                    System.out.print("Enter the amount to withdraw: $");
                    if (scanner.hasNextDouble()) {
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Invalid input. Please enter a valid amount.\n");
                        scanner.next(); // Clear invalid input
                    }
                    break;

                case 3: // View Balance
                    account.showBalance();
                    break;

                case 4: // Exit
                    System.out.println("Thank you for using the Simple Banking Application. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Unknown error. Please try again.");
            }
        }

        scanner.close(); // Close the scanner when done
    }
}
