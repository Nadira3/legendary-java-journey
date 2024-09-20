import java.util.Scanner;

class BankAction
{
	public double deposit(int amount, double balance)
	{
		balance += amount;
		System.out.println("Deposit successful! Your new balance is: $" + balance + "\n");
		return balance;
	}

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

	public void show(double balance)
	{
		System.out.println("Your current balance is $" + balance + ".\n");
	}
}

class BankAccount
{
	double balance = 0.00;
	int amount;
	Scanner myObj = new Scanner(System.in);

	public void printOptions()
	{
		System.out.println("Welcome to the Simple Banking Application!\nPlease select an option:\n1. Deposit Money\n2. Withdraw Money\n3. View Balance\n4. Exit");
	}

	public boolean takeResponse(int response)
	{
		BankAction action = new BankAction();

		switch (response) {
			case 1:
				System.out.print("Enter the amount to deposit: $");
				amount = myObj.nextInt();
				balance = action.deposit(amount, balance);
				break;
			case 2:
				System.out.print("Enter the amount to withdraw: $");
				amount = myObj.nextInt();
				balance = action.withdraw(amount, balance);
				break;
			case 3:
				action.show(balance);
				break;
			case 4:
				System.out.println("Bye!");
				break;
			default:
				System.out.println("Enter a valid option from 1 - 4\n");
		}

		return response != 4 ? true : false;
	}
}

public class BankingApplication
{
	public static void main(String args[])
	{
		BankAccount account = new BankAccount();
		Scanner myObj = new Scanner(System.in);
		int response;
		boolean valid = true;

		while(valid) 
		{
			account.printOptions();
			System.out.print("Enter your choice: ");
			response = myObj.nextInt();
			valid = account.takeResponse(response);
			if (!valid)
				break;
		}

	}
}
