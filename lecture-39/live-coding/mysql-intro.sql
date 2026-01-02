-- In java, we wrote comments using "//"
-- in mysql, we can write comments using "--"

-- Java's Data types: Primitive ones (int, double, short, byte, etc)

-- MySQL Data Types

-- NUMERICAL DATA TYPES
-- Integers: TINYINT, SMALLINT, MEDIUMINT, INT (common), BIGINT
-- Decimal (3.14): DECIMAL

-- TEXTUAL DATA TYPES (Strings)
-- VARCHAR (common): variable length
-- TEXT, TINYTEXT, MEDIUMTEXT, etc

-- DATES & TIMES
-- DATE. Format: YYYY-MM-DD (Eg: 2026-01-02)
-- TIME. Format: HH:MM:SS (Eg: 08:46:50)
-- TIMESTAMP. DATE + TIME. Eg: 2022-12-30 22:38:32

-- BOOLEAN

-- BINARY
-- JSON

-- SCHEMA: the blueprint (structure) of the database. 
-- In a MySQL Schema
	-- tables (users, orders, etc)
	-- columns (eg for users table: id, name, email, etc)
    -- Each column must have a data type
    -- Rules & Constraints (Primary key, etc)
    
    
-- Create a database
-- CREATE DATABASE <argument> where argument is the database name
CREATE DATABASE students;

USE students;

-- Create a table
CREATE TABLE learners (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    marks INT
);

    
    
    
    
    
    
    
    
    
    
    
    