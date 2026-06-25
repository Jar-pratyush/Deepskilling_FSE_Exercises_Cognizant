CREATE DATABASE IF NOT EXISTS CognizantAssessment;
USE CognizantAssessment;

-- SETUP: Creating dummy tables and data so the code can actually execute
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    CustomerName VARCHAR(50),
    Age INT,
    Balance DECIMAL(10,2),
    IsVIP BOOLEAN DEFAULT FALSE
);

CREATE TABLE Loans (
    LoanID INT PRIMARY KEY,
    CustomerID INT,
    InterestRate DECIMAL(5,2),
    DueDate DATE
);

INSERT INTO Customers VALUES
(1, 'Alice', 65, 5000.00, FALSE),
(2, 'Bob', 45, 15000.00, FALSE),
(3, 'Charlie', 62, 12000.00, FALSE);

INSERT INTO Loans VALUES
(101, 1, 5.00, DATE_ADD(CURDATE(), INTERVAL 10 DAY)),
(102, 2, 4.50, DATE_ADD(CURDATE(), INTERVAL 45 DAY)),
(103, 3, 6.00, DATE_ADD(CURDATE(), INTERVAL 20 DAY));

-- SCENARIO 1 & 2: Looping through customers to apply age discounts and VIP status
-- Note: Wrapping in a procedure to demonstrate explicit looping (Cursors) in MySQL
DELIMITER //
CREATE PROCEDURE ProcessCustomerUpdates()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE curr_id INT;
    DECLARE curr_age INT;
    DECLARE curr_balance DECIMAL(10,2);

    -- Cursor to iterate through all customers
    DECLARE customer_cursor CURSOR FOR SELECT CustomerID, Age, Balance FROM Customers;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN customer_cursor;

    read_loop: LOOP
        FETCH customer_cursor INTO curr_id, curr_age, curr_balance;
        IF done THEN
            LEAVE read_loop;
        END IF;

        -- Scenario 1 Logic: 1% discount for age > 60
        IF curr_age > 60 THEN
            UPDATE Loans SET InterestRate = InterestRate - 1.00 WHERE CustomerID = curr_id;
        END IF;

        -- Scenario 2 Logic: VIP for balance > 10000
        IF curr_balance > 10000.00 THEN
            UPDATE Customers SET IsVIP = TRUE WHERE CustomerID = curr_id;
        END IF;
    END LOOP;

    CLOSE customer_cursor;
END //
DELIMITER ;

-- Execute the procedure to apply the updates
CALL ProcessCustomerUpdates();

-- View Results for Scenarios 1 & 2
SELECT * FROM Customers;
SELECT * FROM Loans;

-- SCENARIO 3: Fetch loans due in next 30 days and print a reminder
SELECT
    CONCAT('REMINDER: Dear ', c.CustomerName, ', your loan (ID: ', l.LoanID, ') is due on ', l.DueDate, '.') AS ReminderMessage
FROM Loans l
JOIN Customers c ON l.CustomerID = c.CustomerID
WHERE l.DueDate BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY);