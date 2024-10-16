package com.precious.dao;

import com.precious.model.*;
import com.precious.dao.*;
import com.precious.utils.*;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;

public class BankAccountDAO {
        private DataBaseUtils dbUtils;

    public BankAccountDAO(DataBaseUtils dbUtils) {
        this.dbUtils = dbUtils;
    }

    public List<BankAccount> getAccounts(Customer customer) {
        String sql = "SELECT * FROM BankAccount WHERE customerId = ?";
        List<BankAccount> accounts = new ArrayList<>();

        try (Connection conn = this.dbUtils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, customer.getId());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String accountNumber = rs.getString("accountNumber");
                double balance = rs.getDouble("balance");
                int typeId = rs.getInt("typeId");

                // Instantiate the correct subclass based on typeId
                BankAccount account = null;
                switch (typeId) {
                    case 1:
                        account = new CheckingAccount(accountNumber, balance, customer.getId());
                        break;
                    case 2:
                        account = new SavingsAccount(accountNumber, customer.getId(), balance, 0.5);
                        break;
                    case 3:
                        account = new FixedDepositAccount(accountNumber, customer.getId(), balance, 15);
                        break;
                    default:
                        System.out.println("Unknown account type: " + typeId);
                }

                if (account != null) {
                    accounts.add(account);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving accounts: " + e.getMessage());
        }
    
        return accounts; // Return the list of accounts
    }


    public void addBankAccount(BankAccount account, Customer customer) {
        String sql = "INSERT INTO BankAccount (customerId, accountNumber, balance, typeId) VALUES (?, ?, ?, ?)";

        try (Connection conn = this.dbUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, customer.getId());
            pstmt.setString(2, account.getAccountNumber());
            pstmt.setDouble(3, account.getBalance());
            pstmt.setDouble(4, account.getTypeId());

            pstmt.executeUpdate();
            System.out.println("Bank account added successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateBankAccount(BankAccount account, Customer customer)
    {
        String sql = "UPDATE BankAccount SET balance = ? WHERE customerId = ? AND accountNumber = ?";

        try (Connection conn = this.dbUtils.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql))
        {

             // Set the parameters
            pstmt.setDouble(1, account.getBalance());
            pstmt.setString(2, customer.getId());
            pstmt.setString(3, account.getAccountNumber());

            // Execute the update
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0)
            {
                System.out.println("Customer updated successfully.");
            }
            else
            {
                System.out.println("Customer with ID " + customer.getId() + " not found.");
            }

        }
        catch (SQLException e)
        {
            System.out.println("Error updating BankAccount: " + e.getMessage());
        }
    }
}
