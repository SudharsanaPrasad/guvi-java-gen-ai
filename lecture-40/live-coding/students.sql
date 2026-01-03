-- In java, we wrote comments using "//"
-- in mysql, we can write comments using "--"

-- Java's Data types: Primitive ones (int, double, short, byte, etc)

-- MySQL Data Types

-- NUMERICAL DATA TYPES
-- Integers: TINYINT(0/1), SMALLINT, MEDIUMINT, INT (common), BIGINT
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

-- CREATE DATABASE students;
-- DROP DATABASE students;

CREATE DATABASE guvi_sde;

USE guvi_sde;

DROP TABLE students;
-- String str = new String(); -> max length for this string -> 50 characters
-- Create a table
-- course -> "SDE", "Java", "ML"
-- 1, 2...
CREATE TABLE students (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    course VARCHAR(30),
    marks INT
);

-- public static void main(String[] args)
-- 'a' -> char, "a" -> String
INSERT INTO students(name, course, marks) VALUES ('SARANDEEPRAJ', 'SDE', 85);
INSERT INTO students(name, course, marks) VALUES ('Sridhar', 'SDE', 85);
INSERT INTO students(name, course, marks) VALUES ('Ashwin', 'SDE', 85);
INSERT INTO students(name, course, marks) VALUES ('Choo', 'SDE', 85);
INSERT INTO students(id, name, course, marks) VALUES (9, 'Test 5', 'SDE', 75);


INSERT INTO students(name, course, marks) VALUES 
	('Sridhar', 'SDE', 85),
	('Ashwin', 'SDE', 85),
	('Choo', 'SDE', 85),
	('Thirumalini', 'SDE', 85);

-- Read the data in the students table
SELECT * FROM students;

-- Filter
-- Retrieve all students whose marks are greater than 80
SELECT *
FROM students
WHERE marks > 80;

-- Update a student whose id = 3; set the marks to 87
UPDATE students
SET marks = 87
WHERE id = 3;

-- Delete learners whose marks < 80
-- For this to work, you need to disable safe mode (Preferences)
DELETE 
FROM students
WHERE marks < 80;

DELETE 
FROM students
WHERE id = 9;

DELETE 
FROM students
WHERE marks < 60 AND id = 10;