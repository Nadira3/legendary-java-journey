package com.precious.bankapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String id;
    private String address;
    private List<BankAccount> accounts;

    public Customer(String name, String id, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
	this.accounts = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }
    
    public void addAccount(BankAccount account) {
        this.accounts.add(account);
    }
    
    public List<BankAccount> getAccounts() {
        return accounts;
    }
    
    public BankAccount getAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null; // Account not found
    }

