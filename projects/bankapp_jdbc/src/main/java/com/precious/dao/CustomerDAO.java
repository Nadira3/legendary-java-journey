package com.precious.dao;

import com.precious.service.*;
import com.precious.model.*;
import com.precious.utils.*;

import java.sql.*;

public class CustomerDAO {
    private DataBaseUtils dbUtils = null;

    public CustomerDAO(DataBaseUtils dbUtils) {
        this.dbUtils = dbUtils;
    }

    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO Customer (id, name, address) VALUES (?, ?, ?)";

        try (Connection conn = this.dbUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, customer.getId());
            pstmt.setString(2, customer.getName());
            pstmt.setString(3, customer.getAddress());
            // pstmt.setString(3, customer.getPhone());
            // pstmt.setString(4, customer.getEmail());

            pstmt.executeUpdate();
            System.out.println("Customer added successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Customer getCustomerById(String id) {
        String sql = "SELECT * FROM Customer WHERE id = ?";
        try (Connection conn = dbUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Customer(
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("address"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public Customer getCustomerByAccountNumber(String accountNumber) {
        String sql = "SELECT * FROM BankAccount WHERE accountNumber = ?";
	String customerId = null;
        try (Connection conn = this.dbUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, accountNumber);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                    customerId = rs.getString("customerId");
            }
	    if (customerId != null) {
		    return this.getCustomerById(customerId);
	    }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public void updateCustomer(Customer customer) { }
}
