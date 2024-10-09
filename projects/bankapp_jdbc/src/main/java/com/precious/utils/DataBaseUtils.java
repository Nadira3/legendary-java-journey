package com.precious.utils;

import java.sql.*;

/*
 * 1. import
 * 2. load and register the driver
 * 3. create connection
 * 4. create statement
 * 5. execute query
 * 6. process the results
 * 7. close
 */

public class DataBaseUtils {
    private Connection con = null;
    private String driverClassName = "com.mysql.cj.jdbc.Driver"; // Updated driver class name for MySQL Connector/J
    private static String url = "jdbc:mysql://localhost:3306/bankapp";
    private static String name; // username and password should be gotten from the environment
    private static String pwd;

    // Constructor to initialize the database connection parameters
    public DataBaseUtils(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    // Method to establish a connection to the database
    public void connect() throws SQLException {
        try {
		if (name == null || pwd == null) {
            		throw new IllegalStateException("Database credentials are not set in environment variables");
        	}
            	// Load and register the JDBC driver
            	Class.forName(driverClassName);
            	// Create the connection
            this.con = DriverManager.getConnection(url, this.name, this.pwd);
            System.out.println("Connection established successfully.");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
            throw new SQLException("Failed to load JDBC Driver.", e);
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
            throw e; // Re-throw the SQLException
        }
    }

    public Connection getConnection() throws SQLException {
	    if (this.con == null || this.con.isClosed())
		    connect();
	    return this.con;
    }

    // Method to execute a query (e.g., SELECT)
    public ResultSet executeQuery(String query) throws SQLException {
        if (con == null) {
            throw new SQLException("Connection is not established. Call connect() first.");
        }
        PreparedStatement stmt = con.prepareStatement(query);
        return stmt.executeQuery(); // Return ResultSet for processing
    }

    // Method to execute an update (e.g., INSERT, UPDATE, DELETE)
    public int executeUpdate(String query) throws SQLException {
        if (con == null) {
            throw new SQLException("Connection is not established. Call connect() first.");
        }
        PreparedStatement stmt = con.prepareStatement(query);
        return stmt.executeUpdate(); // Return the number of affected rows
    }

    // Method to close the connection
    public void terminate() {
        if (con != null) {
            try {
                con.close();
                System.out.println("Connection closed successfully.");
            } catch (SQLException e) {
                System.err.println("Failed to close the connection: " + e.getMessage());
            }
        }
    }
}
