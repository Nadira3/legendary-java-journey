import java.util.Scanner;

class BankAction
{
	/** 
	 * Deposits a specified amount into the user's balance.
	 * @param amount The amount to be deposited.
	 * @param balance The current balance before the deposit.
	 * @return The updated balance after the deposit.
	 */
	public double deposit(int amount, double balance)
	{
		balance += amount;
		System.out.println("Deposit successful! Your new balance is: $" + balance + "\n");
		return balance;
	}
	
	/**
	 * Withdraws a specified amount from the user's balance if sufficient funds are available.
	 * @param amount The amount to be withdrawn.
	 * @param balance The current balance before the withdrawal.
	 * @return The updated balance after the withdrawal.
	 */
	public double withdraw(int amount, double balance)
	{
		if (balance >= amount)
		{
			balance -= amount;
			System.out.println("Withdraw successful! Your new balance is: $" + balance + "\n");
		}
		else
			System.out.println("Withdraw unsuccessful! Your balance is insufficient to withdraw $" + amount + ".\n");
		return balance;
	}
	
	/**
	 * Displays the current balance of the user.
	 * @param balance The current balance to be displayed.
	 */
	public void show(double balance)
	{
		System.out.println("Your current balance is $" + balance + ".\n");
	}
}

class BankAccount
{
	double balance = 0.00; // Stores the user's current balance.
	int amount; // Temporary variable to store the amount for transactions.
	
	/**
	 * Prints the available options for the banking application.
	 */
	public void printOptions()
	{
		System.out.println("Welcome to the Simple Banking Application!\nPlease select an option:\n1. Deposit Money\n2. Withdraw Money\n3. View Balance\n4. Exit");
	}

	/**
	 * Takes the user's response and performs the corresponding action.
	 * @param response The user's selected option.
	 * @param myObj The Scanner object used for user input.
	 * @return A boolean indicating whether the application should continue running.
	 */
	public boolean takeResponse(int response, Scanner myObj)
	{
		BankAction action = new BankAction(); // Create a new BankAction instance.

		switch (response) {
			case 1:
				System.out.print("Enter the amount to deposit: $");
				amount = myObj.nextInt();
				balance = action.deposit(amount, balance); // Deposit the amount.
				break;
			case 2:
				System.out.print("Enter the amount to withdraw: $");
				amount = myObj.nextInt();
				balance = action.withdraw(amount, balance); // Withdraw the amount.
				break;
			case 3:
				action.show(balance); // Show the current balance.
				break;
			case 4:
				System.out.println("Bye!");
				break;
			default:
				System.out.println("Enter a valid option from 1 - 4\n");
		}

		return response != 4 ? true : false; // Continue unless the user chooses to exit.
	}
}

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
