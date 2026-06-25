CREATE DATABASE IF NOT EXISTS CognizantAssessment;
USE CognizantAssessment;
-- SETUP: Dummy tables for banking and employees
CREATE TABLE Accounts (
    AccountID INT PRIMARY KEY,
    AccountType VARCHAR(20),
    Balance DECIMAL(15,2)
);

CREATE TABLE Employees (
    EmpID INT PRIMARY KEY,
    Department VARCHAR(50),
    Salary DECIMAL(10,2)
);

INSERT INTO Accounts VALUES (1, 'Savings', 1000.00), (2, 'Checking', 500.00), (3, 'Savings', 2000.00);
INSERT INTO Employees VALUES (101, 'Sales', 50000.00), (102, 'IT', 60000.00), (103, 'Sales', 55000.00);

-- SCENARIO 1: Process Monthly Interest (1% to Savings)
DELIMITER //
CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';
END //
DELIMITER ;

-- SCENARIO 2: Update Employee Bonus using a parameter
DELIMITER //
CREATE PROCEDURE UpdateEmployeeBonus(IN target_dept VARCHAR(50), IN bonus_percentage DECIMAL(5,2))
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * (bonus_percentage / 100))
    WHERE Department = target_dept;
END //
DELIMITER ;

-- SCENARIO 3: Transfer Funds safely with transaction handling
DELIMITER //
CREATE PROCEDURE TransferFunds(IN sender_id INT, IN receiver_id INT, IN amount DECIMAL(15,2))
BEGIN
    DECLARE sender_balance DECIMAL(15,2);

    -- Start a transaction to ensure safety
    START TRANSACTION;

    -- Check sender's current balance
    SELECT Balance INTO sender_balance FROM Accounts WHERE AccountID = sender_id FOR UPDATE;

    IF sender_balance >= amount THEN
        -- Deduct from sender
        UPDATE Accounts SET Balance = Balance - amount WHERE AccountID = sender_id;
        -- Add to receiver
        UPDATE Accounts SET Balance = Balance + amount WHERE AccountID = receiver_id;
        -- Commit changes
        COMMIT;
        SELECT 'Transfer Successful' AS Status;
    ELSE
        -- Cancel everything if insufficient funds
        ROLLBACK;
        SELECT 'Transfer Failed: Insufficient Funds' AS Status;
    END IF;
END //
DELIMITER ;

-- EXECUTION COMMANDS
CALL ProcessMonthlyInterest();
CALL UpdateEmployeeBonus('Sales', 5.00); -- Gives a 5% bonus to Sales
CALL TransferFunds(1, 2, 200.00); -- Successful transfer
CALL TransferFunds(2, 3, 9000.00); -- Failed transfer (Insufficient Funds)

-- View final states
SELECT * FROM Accounts;
SELECT * FROM Employees;