-- 1. Create the new schema
CREATE SCHEMA IF NOT EXISTS ormlearn;
USE ormlearn;

-- 2. Create the country table
CREATE TABLE country (
    co_code VARCHAR(2) PRIMARY KEY,
    co_name VARCHAR(50)
);

-- 3. Insert the requested sample records
INSERT INTO country VALUES ('IN', 'India');
INSERT INTO country VALUES ('US', 'United States of America');

-- 4. Verify the data is there
SELECT * FROM country;