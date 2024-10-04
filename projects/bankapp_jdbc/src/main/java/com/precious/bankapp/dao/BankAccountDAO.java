package com.precious.bankapp.dao;
import com.precious.bankapp.model.*;
import com.precious.bankapp.model.*;
import com.precious.utils.*;

import java.sql.*;

public class BankAccountDAO {
	private DataBaseUtils dbUtils;

    public BankAccountDAO(DataBaseUtils dbUtils) {
        this.dbUtils = dbUtils;
    }

    public void addBankAccount(BankAccount account, Customer customer) {
        String sql = "INSERT INTO BankAccount (customerId, accountNumber, balance) VALUES (?, ?, ?)";

        try (Connection conn = this.dbUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, customer.getId());
            pstmt.setString(2, account.getAccountNumber());
            pstmt.setDouble(3, account.getBalance());

            pstmt.executeUpdate();
            System.out.println("Bank account added successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
