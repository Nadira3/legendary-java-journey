import java.util.Scanner;

class Options
{
	public void printOptions()
	{
		System.out.println("Welcome to the Simple Banking Application!\nPlease select an option:\n1. Deposit Money\n2. Withdraw Money\n3. View Balance\n4. Exit");
	}

	public void takeResponse(int response)
	{
	}

	public boolean optionValidator(int num)
	{
		return num >= 1 && num <= 3 ? true : false;
	}
}

public class BankingApplication
{
	public static void main(String args[])
	{
		Options option = new Options();
		Scanner myObj = new Scanner(System.in);
		int response;
		boolean valid = true;

		while(valid) 
		{
			option.printOptions();
			response = myObj.nextInt();
			valid = option.optionValidator(response);
			if (valid)
				option.takeResponse(response);
			else
			{
				if (response == 4)
				{
					System.out.println("Bye!");
					return;
				}
				valid = true;
				System.out.println("\nEnter a valid number from 1 - 4\n");
			}
		}

	}
}
