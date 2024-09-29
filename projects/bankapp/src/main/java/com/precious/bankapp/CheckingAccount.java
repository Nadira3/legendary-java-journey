package com.precious.bankapp;

class CheckingAccount extends BankAccount {
	private double overdraftLimit;

	public CheckingAccount() {
		overdraftLimit = 100.00;
	}

	public CheckingAccount(String accountName) {
		this(100.00, accountName);
	}
	
	public CheckingAccount(double overdraftLimit, String accountName) {
		super(accountName);
		this.overdraftLimit = overdraftLimit;
	}
	// Getter for overdraftLimit
	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	@Override
	public void withdraw(double amount) {

    		if (this.getBalance() + overdraftLimit >= amount) {
     	   		super.withdraw(amount);
    		}
		else
			System.out.println("Insufficient Balance, Exceeded overdraft limit");
    	}
}
