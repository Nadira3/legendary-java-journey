-- Create database if it doesn't exist
CREATE DATABASE IF NOT EXISTS bankapp;

-- Use the bankapp database
USE bankapp;

-- Create the Customer table if it doesn't exist
CREATE TABLE IF NOT EXISTS Customer (
    id VARCHAR(255) PRIMARY KEY,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    phone VARCHAR(255),
    email VARCHAR(255),
    address VARCHAR(255)
);

-- Create the BankAccount table if it doesn't exist
CREATE TABLE IF NOT EXISTS BankAccount (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customerId VARCHAR(255),
    accountNumber VARCHAR(255),
    typeID INT,
    balance DECIMAL(10, 2),
    FOREIGN KEY (customerId) REFERENCES Customer(id) ON DELETE CASCADE
);

-- Create the AccountType table if it doesn't exist
CREATE TABLE IF NOT EXISTS AccountType (
    typeID INT AUTO_INCREMENT PRIMARY KEY,
    typeName VARCHAR(255) NOT NULL
);
