package com.precious.bankapp;
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
