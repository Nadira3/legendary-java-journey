package com.precious.bankapp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class FixedDepositAccount extends BankAccount {
	private double depositAmount;
	private String maturityDate;

	public FixedDepositAccount(String accountName) {
		super(accountName);
	}
	
	public FixedDepositAccount(double depositAmount, String maturityDate) {
		this.depositAmount = depositAmount;
		this.maturityDate = maturityDate;
	}

    	// Implement logic to check if the maturity date has been reached
	public boolean isMatured() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate maturity = LocalDate.parse(this.maturityDate, formatter);
		return LocalDate.now().isAfter(maturity);	
	}

	public double calculateTotalAmount(double interestRate) {
    		double interest = (depositAmount * interestRate) / 100; // You could also add an interest rate for Fixed Deposit.
    		return depositAmount + interest;
	}

}
