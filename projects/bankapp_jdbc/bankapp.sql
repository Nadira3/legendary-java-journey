-- Create the bankapp database if it doesn't exist
CREATE DATABASE IF NOT EXISTS bankapp;

-- Use the bankapp database
USE bankapp;

-- Create the Customer table if it doesn't exist
CREATE TABLE IF NOT EXISTS Customer (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255)
);

-- Create the BankAccount table if it doesn't exist
CREATE TABLE IF NOT EXISTS BankAccount (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customerId VARCHAR(255),
    accountNumber VARCHAR(255),
    balance DECIMAL(10, 2),
    FOREIGN KEY (customerId) REFERENCES Customer(id) ON DELETE CASCADE
);
