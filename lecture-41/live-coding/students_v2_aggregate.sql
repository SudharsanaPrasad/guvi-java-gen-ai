-- create a second version of our students table
-- createdAt -> camel case
-- snake case
CREATE TABLE students_v2 (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    course VARCHAR(30) NOT NULL,
    marks TINYINT NOT NULL,
    email VARCHAR(100) UNIQUE,
    description TEXT,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    -- 2026-01-03 08:19:20
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

DESCRIBE students_v2;

INSERT INTO students_v2 (name, course, marks, email, description) VALUES
	("Thirumani", "SDE", 90, "t@gmail.com", "Hey!"),
    ("SARANDEEPRAJ", "SDE", 92, "s@gmail.com", "Hello!"),
    ("Malini", "SDE", 92, "m@gmail.com", "Hello!"),
    ("Vedant", "SDE", 92, "v@gmail.com", "Hello!");
x
-- Will fail
INSERT INTO students_v2(course, marks, email) VALUES
	("SDE", 90, "t@gmail.com");
    
INSERT INTO students_v2(name, course, marks, email) VALUES
	("Soumyajit", "SDE", 90, "so@gmail.com");

SELECT * FROM students_v2;

-- ------------------------------ AGGREGATE FUNCTIONS ------------------------------

SELECT COUNT(*)  AS total_learners
FROM students_v2;

SELECT MIN(marks) AS lowest, MAX(marks) AS highest
FROM students_v2;

SELECT AVG(marks) AS avg_marks
FROM students_v2;

SELECT SUM(marks) AS total_marks
FROM students_v2;

-- the number of times a given mark occurs
SELECT marks, COUNT(*) as frequency
FROM students_v2
GROUP BY marks;

-- 90, 92, 92, 92, 90 -> GROUP -> 90, 92
-- COUNT(*) -> 90: 2, 92: 3


SELECT COUNT(marks) as frequency
FROM students_v2;

-- How many learners scored above 80?
SELECT COUNT(marks) as frequency
FROM students_v2
WHERE marks > 80;


SELECT MAX(MARKS) AS MAX_MARK
FROM students_v2;

SELECT MAX(mark) AS highest
FROM students_v2;

SELECT AVG(MARKS) AS AVG_MARKS
FROM students_v2;
