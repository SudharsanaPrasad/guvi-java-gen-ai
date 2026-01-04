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
