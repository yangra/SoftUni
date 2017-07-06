
#1
CREATE TABLE persons (
    person_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30),
    salary DECIMAL(10 , 2 ),
    passport_id INT UNIQUE NOT NULL
);

CREATE TABLE passports (
    passport_id INT PRIMARY KEY,
    passport_number CHAR(8)
);

ALTER TABLE persons 
ADD CONSTRAINT fk_persons_passports FOREIGN KEY (passport_id)
REFERENCES passports(passport_id);

INSERT INTO passports (passport_id, passport_number)
VALUES (101, 'N34FG21B'),
(102, 'K65LO4R7'),
(103, 'ZE657QP2');


INSERT INTO persons(first_name, salary, passport_id)
VALUES ('Roberto', 43300.00, 102),
('Tom', 56100.00, 103),
('Yana', 60200.00, 101);

#2
CREATE TABLE manufacturers(
	manufacturer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    established_on DATE NOT NULL
);

CREATE TABLE models (
	model_id INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    manufacturer_id INT NOT NULL
);

ALTER TABLE models
ADD CONSTRAINT fk_models_manufacturers 
FOREIGN KEY (manufacturer_id)
REFERENCES manufacturers(manufacturer_id);

INSERT INTO manufacturers (name, established_on)
VALUES ('BMW', '1916-03-07'),
('Tesla', '2003-01-01'),
('Lada', '1966-05-01');

INSERT INTO models (model_id, name, manufacturer_id)
VALUES (101, 'X1', 1),
(102, 'i6', 1),
(103, 'Model S', 2),
(104, 'Model X', 2),
(105, 'Model 3', 2),
(106, 'Nova', 3);

#3
CREATE TABLE students(
	student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE exams(
	exam_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE students_exams(
	student_id INT,
    exam_id INT,
    PRIMARY KEY (student_id, exam_id)
);

ALTER TABLE exams AUTO_INCREMENT=101;

ALTER TABLE students_exams
ADD CONSTRAINT fk_students_exams_exams
FOREIGN KEY (exam_id)
REFERENCES exams(exam_id);

ALTER TABLE students_exams
ADD CONSTRAINT fk_students_exams_students
FOREIGN KEY (student_id)
REFERENCES students(student_id);

INSERT INTO students(name)
VALUES ('Mila'),
('Toni'),
('Ron');

INSERT INTO exams(name)
VALUES ('Spring MVC'),
('Neo4g'),
('Oracle 11g');

INSERT INTO students_exams(student_id, exam_id)
VALUES (1,101),
(1,102),
(2,101),
(3,103),
(2,102),
(2,103);


#4
CREATE TABLE teachers(
	teacher_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    manager_id INT
);

ALTER TABLE teachers AUTO_INCREMENT=101;
ALTER TABLE teachers 
ADD CONSTRAINT fk_teachers_teachers
FOREIGN KEY (manager_id)
REFERENCES teachers(teacher_id);

INSERT INTO teachers(name)
VALUES ('John'),
('Maya'),
('Silvia'),
('Ted'),
('Mark'),
('Greta');

UPDATE teachers
SET manager_id  = 106
WHERE teacher_id IN (102,103);

UPDATE teachers
SET manager_id  = 105
WHERE teacher_id = 104;

UPDATE teachers
SET manager_id  = 101
WHERE teacher_id IN (105,106);



#5
#DROP TABLE IF EXISTS items;
CREATE TABLE items(
	item_id INT(11) PRIMARY KEY,
	name VARCHAR(50),
	item_type_id INT(11)
);

#DROP TABLE IF EXISTS item_types;
CREATE TABLE item_types(
	item_type_id INT(11) PRIMARY KEY,
    name VARCHAR(50)
);

#DROP TABLE IF EXISTS order_items;
CREATE TABLE order_items(
	order_id INT(11),
    item_id INT(11),
    PRIMARY KEY (order_id, item_id)
);

#DROP TABLE IF EXISTS orders;
CREATE TABLE orders(
	order_id INT(11) PRIMARY KEY,
    customer_id INT(11)
);

#DROP TABLE IF EXISTS customers;
CREATE TABLE customers(
	customer_id INT(11) PRIMARY KEY,
    name VARCHAR(50),
    birthday DATE,
    city_id INT(11)
);

#DROP TABLE IF EXISTS cities;
CREATE TABLE cities(
	city_id INT(11) PRIMARY KEY,
    name VARCHAR(50)
);

ALTER TABLE items
ADD CONSTRAINT fk_items_item_types FOREIGN KEY (item_type_id)
REFERENCES item_types(item_type_id);

ALTER TABLE order_items
ADD CONSTRAINT fk_order_items_items FOREIGN KEY (item_id)
REFERENCES items(item_id);

ALTER TABLE order_items
ADD CONSTRAINT fk_order_items_orders FOREIGN KEY (order_id)
REFERENCES orders(order_id);

ALTER TABLE orders
ADD CONSTRAINT fk_orders_customers FOREIGN KEY (customer_id)
REFERENCES customers(customer_id);

ALTER TABLE customers
ADD CONSTRAINT fk_customers_cities FOREIGN KEY (city_id)
REFERENCES cities(city_id);


#6
CREATE TABLE subjects(
	subject_id INT(11) AUTO_INCREMENT PRIMARY KEY,
    subject_name VARCHAR(50) NOT NULL
);

CREATE TABLE students(
	student_id INT(11) AUTO_INCREMENT PRIMARY KEY,
    student_number VARCHAR(12) NOT NULL,
    student_name VARCHAR(50) NOT NULL,
    major_id INT(11) NOT NULL
);

CREATE TABLE agenda(
	student_id INT(11),
    subject_id INT(11),
    PRIMARY KEY (student_id, subject_id)
);

CREATE TABLE majors(
	major_id INT(11) AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE payments(
	payment_id INT(11) AUTO_INCREMENT PRIMARY KEY,
    payment_date DATE NOT NULL,
    payment_amount DECIMAL(8,2) NOT NULL,
    student_id INT(11) NOT NULL
);

ALTER TABLE agenda
ADD CONSTRAINT fk_agenda_subjects 
FOREIGN KEY (subject_id)
REFERENCES subjects(subject_id);

ALTER TABLE agenda
ADD CONSTRAINT fk_agenda_students 
FOREIGN KEY (student_id)
REFERENCES students(student_id);

ALTER TABLE students
ADD CONSTRAINT fk_students_majors 
FOREIGN KEY (major_id)
REFERENCES majors(major_id);

ALTER TABLE payments
ADD CONSTRAINT fk_payments_studentss 
FOREIGN KEY (student_id)
REFERENCES students(student_id);

#9
SELECT m.mountain_range, p.peak_name, p.elevation AS peak_elevation
FROM mountains AS m
JOIN peaks AS p ON
m.id = p.mountain_id
WHERE m.mountain_range = 'Rila'
ORDER BY peak_elevation DESC;