package com.precious.bankapp;
import java.util.Scanner;

public class BankingApplication
{
	/**
	 * The main method that runs the banking application.
	 * It initializes the BankAccount and handles user interaction.
	 * @param args Command line arguments (not used).
	 */
	public static void main(String args[])
	{
		BankAccount account = new BankAccount(); // Create a new BankAccount instance.
		Scanner myObj = new Scanner(System.in); // Initialize Scanner for user input.
		int response; // Variable to store user's choice.
		boolean valid = true; // Control variable for the main loop.

		while(valid) 
		{
			account.printOptions(); // Display options to the user.
			System.out.print("\nEnter your choice: ");
			response = myObj.nextInt(); // Read the user's choice.
			valid = account.takeResponse(response, myObj); // Process the choice and update the valid flag.
			if (!valid)
				break;
		}

	}
}
