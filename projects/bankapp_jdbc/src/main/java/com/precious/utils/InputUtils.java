package com.precious.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {

    /**
     * A utility method to safely get integer input from the user.
     *
     * @param scanner The scanner object for input
     * @param prompt The message to display to the user
     * @return A valid integer input from the user
     */
    public static int getIntInput(Scanner scanner, String prompt) {
        int input = -1;
        while (true) {
            try {
                System.out.print(prompt);
                input = scanner.nextInt();
                scanner.nextLine(); // Consume the newline left by nextInt()
                break; // Exit loop when input is valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        return input;
    }
    
    public static double getDoubleInput(Scanner scanner, String prompt) {
        double input = 0.00;
        while (true) {
            try {
                System.out.print(prompt);
                input = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline left by nextInt()
                break; // Exit loop when input is valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        return input;
    }
}
