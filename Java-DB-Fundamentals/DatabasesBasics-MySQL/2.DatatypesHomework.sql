CREATE DATABASE minions;

USE minions;

CREATE TABLE minions(
	id INT,
	name VARCHAR(50),
	age INT(3)
);

CREATE TABLE towns(
	id INT,
	name VARCHAR(45)
);

ALTER TABLE minions
ADD CONSTRAINT pk_minions PRIMARY KEY(id);

ALTER TABLE towns
ADD CONSTRAINT pk_towns PRIMARY KEY(id);

ALTER TABLE minions
ADD COLUMN town_id INT;

ALTER TABLE minions
ADD CONSTRAINT fk_minions_towns FOREIGN KEY(town_id)
REFERENCES towns (id);

INSERT INTO towns (id, name) 
VALUES (1, 'Sofia'), (2, 'Plovdiv'), (3, 'Varna');

INSERT INTO minions (id, name, age, town_id)
VALUES (1, 'Kevin', 22, 1), (2, 'Bob', 15, 3), (3, 'Steward', NULL, 2);

TRUNCATE TABLE minions;

DROP TABLE minions, towns;

CREATE TABLE people(
	id INT AUTO_INCREMENT,
	name VARCHAR(200) NOT NULL,
	picture MEDIUMBLOB,
	height DOUBLE(3,2),
	weight DOUBLE(5,2),
	gender CHAR(1) NOT NULL,
	birthdate DATE NOT NULL,
	biography TEXT,
	CONSTRAINT pk_people PRIMARY KEY(id)
);

INSERT INTO people (name, height, weight, gender, birthdate, biography) 
VALUES ('Angel Popov', 1.76, 86, 'm', '1981-02-21', 'Born in February'),
('Maritza Penova', 1.64, 56, 'f', '1945-06-11', 'Born in June'),
('Martin Minchev', 1.86, 95, 'm', '1966-04-16', 'Born in April'),
('Sonq Mileva', 1.60, 50, 'f', '1971-09-26', 'Born in September'),
('Rumen Shopov', 1.88, 88, 'm', '1996-12-14', 'Born in December');

CREATE TABLE users (
	id BIGINT UNIQUE AUTO_INCREMENT,
	username VARCHAR(30) NOT NULL,
	password VARCHAR(26) NOT NULL,
	profile_picture MEDIUMBLOB,
	last_login_time TIME,
	is_deleted BOOL,
	CONSTRAINT pk_users PRIMARY KEY(id)
);

INSERT INTO users(username, password, last_login_time, is_deleted)
VALUES ('pesho', '12kl56', '12:45:32', 0),
('gosho', '45jk89', '18:12:35', 0),
('asparuh', '58hj25', '00:51:12', 0),
('grisho', 'rt78tr', '15:12:05', 1),
('dilqn', 'bg95gb', '14:00:09', 0);

ALTER TABLE users 
MODIFY id BIGINT NOT NULL;

ALTER TABLE users 
DROP PRIMARY KEY;

ALTER TABLE users
CHANGE id id BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE users
ADD CONSTRAINT pk_users PRIMARY KEY(id, username);

ALTER TABLE users
CHANGE last_login_time last_login_time DATETIME DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE users 
MODIFY id BIGINT NOT NULL;

ALTER TABLE users 
DROP PRIMARY KEY;

ALTER TABLE users
ADD CONSTRAINT pk_users PRIMARY KEY(id);

ALTER TABLE users
CHANGE id id BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE users
ADD CONSTRAINT UNIQUE(username);

CREATE DATABASE movies;

USE movies;

CREATE TABLE directors(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	director_name VARCHAR(50) NOT NULL,
	notes TEXT
);

CREATE TABLE genres(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	genre_name VARCHAR(30) NOT NULL,
	notes TEXT
);

CREATE TABLE categories(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	category_name VARCHAR(50) NOT NULL,
	notes TEXT
);

CREATE TABLE movies(
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(100) NOT NULL,
	director_id INT NOT NULL,
	copyright_year VARCHAR(4),
	length INT(3),
	genre_id INT NOT NULL,
	category_id INT NOT NULL,
	rating INT(1),
	notes TEXT
);

INSERT INTO directors (director_name, notes)
VALUES ('Pesho', NULL),
('Gosho', 'Shefa'),
('Malin', 'No notes'),
('Rostislav', 'The best'),
('Petran', NULL);

INSERT INTO genres (genre_name, notes)
VALUES ('Classic', NULL),
('Psycho', 'King'),
('Drama', 'Scarlet'),
('Sci-fi', 'Clarke'),
('Comedy', NULL);

INSERT INTO categories (category_name, notes)
VALUES ('category1', NULL),
('category2', '11-15'),
('category3', '15-18'),
('category4', 'adult'),
('category5', NULL);

INSERT INTO movies (title, director_id, copyright_year, length, genre_id, category_id,rating, notes)
VALUES ('Gataka', 1,'1999',142, 4, 4, 1, null),
('The Matrix', 5,'2008',123, 4, 2, 2, null),
('Gone With The Winds', 3,'1978',156, 3, 3, 3, null),
('Kite Runner', 4,'2004',112, 1, 4, 4, null),
('The Fifth Element', 2,'1999',105, 4, 5, 5, null);


DROP DATABASE IF EXISTS car_rental;
CREATE DATABASE car_rental;
USE car_rental;

DROP TABLE IF EXISTS categories;
CREATE TABLE categories (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
category VARCHAR(30) NOT NULL, 
daily_rate DECIMAL(10,2) NOT NULL, 
weekly_rate DECIMAL(10,2) NOT NULL, 
monthly_rate DECIMAL(10,2) NOT NULL, 
weekend_rate DECIMAL(10,2) NOT NULL
);

DROP TABLE IF EXISTS cars;
CREATE TABLE cars (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
plate_number VARCHAR(10) NOT NULL, 
make VARCHAR(30) NOT NULL, 
model VARCHAR(20) NOT NULL, 
car_year CHAR(4) NOT NULL, 
category_id INT NOT NULL, 
doors ENUM('2','3','4','5') NOT NULL, 
picture BLOB, 
car_condition VARCHAR(100) NOT NULL, 
available BOOL NOT NULL
);

DROP TABLE IF EXISTS employees;
CREATE TABLE employees (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
first_name VARCHAR(30) NOT NULL, 
last_name VARCHAR(30) NOT NULL, 
title VARCHAR(50) NOT NULL, 
notes TEXT
);

DROP TABLE IF EXISTS customers;
CREATE TABLE customers (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
driver_licence_number VARCHAR(20) NOT NULL, 
full_name VARCHAR(60) NOT NULL, 
address VARCHAR(200) NOT NULL, 
city VARCHAR(50) NOT NULL, 
zip_code VARCHAR(10) NOT NULL, 
notes TEXT
);

DROP TABLE IF EXISTS rental_orders;
CREATE TABLE rental_orders (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
employee_id INT NOT NULL, 
customer_id BIGINT NOT NULL, 
car_id INT NOT NULL, 
car_condition VARCHAR(100), 
tank_level ENUM('full','empty','half') NOT NULL, 
kilometrage_start INT NOT NULL,
kilometrage_end INT NOT NULL, 
total_kilometrage INT NOT NULL, 
start_date DATE NOT NULL, 
end_date DATE NOT NULL, 
total_days INT NOT NULL, 
rate_applied ENUM('daily', 'weekly', 'monthly', 'weekend') NOT NULL,
tax_rate DECIMAL(4,2) NOT NULL, 
order_status ENUM('processed', 'ordered', 'awaiting_approval', 'available') NOT NULL,
notes TEXT
);

INSERT INTO categories(category, daily_rate, weekly_rate, monthly_rate, weekend_rate)
VALUES('small car', 50.5, 45.00, 40.00, 48.00), 
('medium car', 60.00, 55.00, 50.00, 58.00),
('large car', 75.00, 70.00, 65.00, 72.00);

INSERT INTO cars(plate_number, make, model, car_year, category_id, doors, picture, car_condition, available)
VALUES('AM1245LA', 'BMW', '230i', '2016', 2,'4', NULL,'Small scratches', 1), 
('AM7126PO', 'SEAT', 'MINI', '2017', 1,'2', NULL,'New' ,1),
('AM3214KP', 'Suzuki', 'SX4', '2016', 3,'4', NULL,'Small scratches', 1);

INSERT INTO employees(first_name, last_name, title, notes)
VALUES('John', 'Doe', 'fixxer', 'Good guy'), 
('Pepper', 'Smith', 'seller', null),
('Mary', 'Crone', 'cleaner', 'Nutty');

INSERT INTO customers(driver_licence_number, full_name, address, city, zip_code, notes)
VALUES('12312312312', 'James Brown', '123 Victoria Road', 'Inverness', 'SW1223', NULL), 
('32132132132', 'Curt Crown', '12 Belvenue Blvd', 'Manchester', 'AB4512','Left the car in poor state'),
('78978979878', 'Poppy moviescarsBaker', '1 Trivoli Street', 'London', 'SW12DG', NULL);

INSERT INTO rental_orders(employee_id, customer_id, car_id, car_condition, tank_level, kilometrage_start,
kilometrage_end, total_kilometrage, start_date, end_date, total_days, rate_applied, tax_rate, 
order_status, notes)
VALUES(3, 2, 1, 'Small scratches', 'full', 20426, 20636, 210, '2017-02-21', '2017-02-24',3, 'daily', 0.07,'available',NULL), 
(1, 3, 3, 'Small scratches', 'full', 60521, 61349, 828, '2017-03-13','2017-03-19',6, 'weekly', 0.07, 'available', NULL),
(2, 1, 2, 'New', 'full', 2256, 6245, 3989, '2017-04-04','2017-04-24',20, 'monthly', 0.07, 'processed', NULL);


DROP DATABASE IF EXISTS hotel;
CREATE DATABASE hotel;
USE hotel;

DROP TABLE IF EXISTS employees;
CREATE TABLE employees(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
first_name VARCHAR(30) NOT NULL, 
last_name VARCHAR(30) NOT NULL, 
title VARCHAR(20) NOT NULL, 
notes TEXT
);

DROP TABLE IF EXISTS customers;
CREATE TABLE customers (
account_number VARCHAR(30) NOT NULL PRIMARY KEY, 
first_name VARCHAR(30) NOT NULL, 
last_name VARCHAR(30) NOT NULL, 
phone_number VARCHAR(20) NOT NULL, 
emergency_name VARCHAR(50) NOT NULL,
emergency_number VARCHAR(20) NOT NULL, 
notes TEXT
);

DROP TABLE IF EXISTS room_status;
CREATE TABLE room_status (
room_status VARCHAR(12) NOT NULL PRIMARY KEY, 
notes TEXT
);

DROP TABLE IF EXISTS room_types;
CREATE TABLE room_types (
room_type VARCHAR(10) NOT NULL PRIMARY KEY, 
notes TEXT
);

DROP TABLE IF EXISTS bed_types;
CREATE TABLE bed_types (
bed_type VARCHAR(12) NOT NULL PRIMARY KEY, 
notes TEXT
);

DROP TABLE IF EXISTS rooms;
CREATE TABLE rooms (
room_number INT(4) NOT NULL PRIMARY KEY, 
room_type VARCHAR(10) NOT NULL, 
bed_type VARCHAR(12) NOT NULL, 
rate DECIMAL(10,2) NOT NULL, 
room_status VARCHAR(12) NOT NULL, 
notes TEXT
);

DROP TABLE IF EXISTS payments;
CREATE TABLE payments (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
employee_id INT NOT NULL, 
payment_date DATE NOT NULL, 
account_number VARCHAR(30) NOT NULL, 
first_date_occupied DATE NOT NULL, 
last_date_occupied DATE NOT NULL, 
total_days INT NOT NULL, 
amount_charged DECIMAL(10,2) NOT NULL, 
tax_rate DECIMAL(4,2) NOT NULL, 
tax_amount DECIMAL(9,2) NOT NULL, 
payment_total DECIMAL(10,2) NOT NULL, 
notes TEXT
);

DROP TABLE IF EXISTS occupancies;
CREATE TABLE occupancies (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
employee_id INT NOT NULL, 
date_occupied DATE NOT NULL, 
account_number VARCHAR(20) NOT NULL, 
room_number INT(4) NOT NULL, 
rate_applied DECIMAL(10,2) NOT NULL, 
phone_charge BOOL, 
notes TEXT
);

INSERT INTO employees (first_name, last_name, title, notes)
VALUES ('George', 'Bush', 'housekeeper', NULL),
('Ronald', 'Raleigh', 'receptionist', NULL),
('Margaret', 'Hill', 'server', NULL);

INSERT INTO customers (account_number, first_name, last_name, phone_number, emergency_name, emergency_number, notes)
VALUES (12345678901234567890, 'Kevin', 'Black', '049666333888', 'Greta Munch', '049555666777', NULL),
(01234567890123456789, 'Dawn', 'Watson', '049111222333', 'Pavel Popov', '049222333444', NULL),
(98765432109876543210, 'Barny', 'Rubble', '049555666888', 'Greta Munch', '049999888777', NULL);

INSERT INTO room_status (room_status, notes)
VALUES ('occupied', NULL),
('empty', NULL),
('cleaned', NULL);

INSERT INTO room_types (room_type, notes)
VALUES ('twin', NULL),
('single', NULL),
('double', NULL);

INSERT INTO bed_types (bed_type, notes)
VALUES ('king size', NULL),
('single', NULL),
('double', NULL);

INSERT INTO rooms (room_number, room_type, bed_type, rate, room_status, notes)
VALUES(123, 'single', 'king size', 100.00, 'occupied', NULL),
(223, 'twin', 'single', 160.00, 'cleaned', NULL),
(323, 'double', 'double', 140.00, 'empty', NULL);

INSERT INTO payments (employee_id, payment_date, account_number, first_date_occupied, last_date_occupied, total_days, amount_charged, tax_rate, tax_amount, payment_total, notes)
VALUES(2, '2017-03-17', '01234567890123456789', '2017-03-14', '2017-03-16', 3, 300.00, 0.20, 60.00, 360.00, NULL),
(3, '2017-04-18', '98765432109876543210', '2017-04-07', '2017-04-17', 10, 1400.00, 0.20, 280.00, 1680.00, NULL),
(1, '2017-05-17', '12345678901234567890', '2017-05-15', '2017-05-16', 2, 320.00, 0.20, 64.00, 384.00, NULL);

INSERT INTO occupancies (employee_id, date_occupied, account_number, room_number, rate_applied, phone_charge, notes)
VALUES (2, '2017-10-24', 56789012345678901234, 212, 80.00, 0, NULL),
(1, '2017-02-21', 34567890123456789012, 312, 80.00, 1, NULL),
(3, '2017-08-12', 23456789012345678901, 421, 80.00, 0, NULL);

DROP DATABASE IF EXISTS soft_uni;
CREATE DATABASE soft_uni;
USE soft_uni;

DROP TABLE IF EXISTS towns;
CREATE TABLE towns (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS addresses;
CREATE TABLE addresses (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	address_text VARCHAR(200) NOT NULL, 
	town_id INT NOT NULL,
	CONSTRAINT fk_addresses_towns FOREIGN KEY (town_id)
	REFERENCES towns (id)
);

DROP TABLE IF EXISTS departments;
CREATE TABLE departments (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS employees;
CREATE TABLE employees (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	first_name VARCHAR(30) NOT NULL,
	middle_name VARCHAR(30), 
	last_name VARCHAR(30) NOT NULL, 
	job_title VARCHAR(50) NOT NULL, 
	department_id INT NOT NULL, 
	hire_date DATE NOT NULL, 
	salary DECIMAL(20,2),
	address_id INT NOT NULL,
	CONSTRAINT fk_employees_addresses FOREIGN KEY (address_id)
	REFERENCES addresses (id),
	CONSTRAINT fk_employees_departments FOREIGN KEY (department_id)
	REFERENCES departments (id)
);

ALTER TABLE employees
MODIFY COLUMN address_id INT;

INSERT INTO towns (name)
VALUES ('Sofia'),
('Plovdiv'),
('Varna'),
('Burgas');

INSERT INTO departments (name)
VALUES ('Engineering'),
('Sales'),
('Marketing'),
('Software Development'),
('Quality Assurance');

INSERT INTO employees (first_name, middle_name, last_name, job_title, department_id, hire_date, salary)
VALUES ('Ivan', 'Ivanov', 'Ivanov','.NET Developer', 4, '2013-02-01', 3500.00),
('Petar', 'Petrov', 'Petrov','Senior Engineer', 1, '2004-03-02', 4000.00),
('Maria', 'Petrova', 'Ivanova','Intern', 5, '2016-08-28', 525.25),
('Georgi', 'Terziev', 'Ivanov','CEO', 2, '2007-12-09', 3000.00),
('Peter', 'Pan', 'Pan','Intern', 3, '2016-08-28', 599.88);

SELECT * FROM towns;
SELECT * FROM departments;
SELECT * FROM employees;

SELECT * FROM towns ORDER BY towns.name;
SELECT * FROM departments ORDER BY departments.name;
SELECT * FROM employees ORDER BY employees.salary DESC;

SELECT name FROM towns ORDER BY towns.name;
SELECT name FROM departments ORDER BY departments.name;
SELECT first_name, last_name, job_title, salary FROM employees ORDER BY employees.salary DESC;

UPDATE employees
SET salary = salary * 1.10;

SELECT salary FROM employees;


USE hotel;

UPDATE payments
SET payments.tax_rate = payments.tax_rate*0.97;

SELECT tax_rate FROM payments;


TRUNCATE TABLE occupancies;