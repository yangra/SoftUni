#1
SELECT `first_name`, `last_name` FROM `employees`
WHERE `first_name` LIKE 'SA%';

#2
SELECT `first_name`, `last_name` FROM `employees`
WHERE `last_name` LIKE '%ei%';

#3
SELECT `first_name` FROM `employees`
WHERE `department_id` IN (3, 10) 
AND EXTRACT(year FROM `hire_date`) >= 1995 
AND EXTRACT(year FROM `hire_date`) <= 2005;

#4
SELECT `first_name`, `last_name` FROM `employees`
WHERE `job_title` NOT LIKE '%engineer%';

#5
SELECT `name` FROM `towns`
WHERE `name` LIKE '_____' OR `name` LIKE '______'
ORDER BY `name`;

#6
SELECT `town_id`, `name` FROM `towns`
WHERE `name` REGEXP '^[MKBE]'
ORDER BY `name`;

#7
SELECT `town_id`, `name` FROM `towns`
WHERE `name` REGEXP '^[^RBD]'
ORDER BY `name`;

#8
DROP VIEW IF EXISTS `v_employees_hired_after_2000`;
CREATE VIEW `v_employees_hired_after_2000` AS
SELECT `first_name`, `last_name` FROM `employees`
WHERE EXTRACT(year FROM `hire_date`) > 2000;

#9
SELECT `first_name`, `last_name` FROM `employees`
WHERE `last_name` LIKE '_____';

#10
SELECT `country_name`, `ISO_code` FROM `countries`
WHERE `country_name` LIKE '%a%a%a%'
ORDER BY `ISO_code`;

#11?????
SELECT p.`peak_name`, r.`river_name`, LOWER(CONCAT(p.`peak_name`, SUBSTRING(r.`river_name`,2))) AS `mix`
FROM `peaks` AS p, `rivers` AS r 
WHERE RIGHT(p.`peak_name`, 1) = LEFT(r.`river_name`,1)
ORDER BY `mix`;


#12
SELECT `name`, DATE_FORMAT(`start`,'%Y-%c-%d') AS `start` FROM `games`
WHERE EXTRACT(year FROM `start`) IN (2011, 2012)
ORDER BY `start`, `name`
LIMIT 50;

#13
SELECT `user_name`, SUBSTRING(`email`,LOCATE('@', `email`)+1) AS `Email Provider` FROM `users`
ORDER BY `Email Provider`, `user_name`;

#14
SELECT `user_name`, `ip_address` FROM `users`
WHERE `ip_address` LIKE '___.1%.%.___'
ORDER BY `user_name`;

#15
SELECT `name` AS 'game',
	CASE	WHEN EXTRACT(hour FROM `start`) >= 0 AND EXTRACT(hour FROM `start`) < 12 THEN 'Morning'
			WHEN EXTRACT(hour FROM `start`) >= 12 AND EXTRACT(hour FROM `start`) < 18 THEN 'Afternoon'
			WHEN EXTRACT(hour FROM `start`) >= 18 AND EXTRACT(hour FROM `start`) < 24 THEN 'Evening' 
	END
	AS 'Part of the Day',
	CASE WHEN `duration`<= 3 THEN 'Extra Short'
			WHEN `duration`> 3 AND `duration` <= 6 THEN 'Short'
			WHEN `duration`> 6 AND `duration` <= 10 THEN 'Long'
			ELSE 'Extra Long' 
	END 
	AS 'Duration'
FROM `games`;

#######
SELECT `name` AS 'game',
	CASE	WHEN HOUR(`start`) BETWEEN 0 AND 11 THEN 'Morning'
			WHEN HOUR(`start`) BETWEEN  12 AND 17 THEN 'Afternoon'
			WHEN HOUR(`start`) BETWEEN 18 AND 23 THEN 'Evening' 
	END
	AS 'Part of the Day',
	CASE WHEN `duration`<= 3 THEN 'Extra Short'
			WHEN `duration` BETWEEN 4 AND 6 THEN 'Short'
			WHEN `duration` BETWEEN 7 AND 10 THEN 'Long'
			ELSE 'Extra Long' 
	END 
	AS 'Duration'
FROM `games`;

#16
SELECT `product_name`, 
		 `order_date`, 
		 DATE_ADD(`order_date`, INTERVAL 3 DAY) AS `pay_due`, 
		 DATE_ADD(`order_date`, INTERVAL 1 MONTH) AS `deliver_due` 
FROM `orders`;

#17
CREATE DATABASE exersize4;
USE exersize4;
CREATE TABLE people(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(30),
	birthdate DATETIME
);

INSERT INTO people(name, birthdate) 
VALUES ('Ivan', '1993-05-12 05:12:45'),
('Gosho', '1968-12-01 12:45:01'),
('Maria', '2007-09-11 07:23:52');

SELECT name, TIMESTAMPDIFF(year, p.birthdate, now()) AS 'age_in_years',
TIMESTAMPDIFF(month, p.birthdate, now()) AS 'age_in_months',
TIMESTAMPDIFF(day, p.birthdate, now()) AS 'age_in_days',
TIMESTAMPDIFF(minute, p.birthdate, now()) AS 'age_in_minutes'
FROM people as p;