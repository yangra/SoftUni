#1
SELECT COUNT(*) AS `count` FROM `wizzard_deposits`;

#2
SELECT MAX(w.`magic_wand_size`) AS longest_magic_wand FROM `wizzard_deposits` AS w;

#3
SELECT w.deposit_group, MAX(w.magic_wand_size) AS longest_magic_wand FROM `wizzard_deposits` AS w
GROUP BY w.deposit_group
ORDER BY longest_magic_wand;

#4
SELECT d.deposit_group
FROM (SELECT w.deposit_group, AVG(w.magic_wand_size) AS avg_size
		FROM wizzard_deposits AS w
		GROUP BY w.deposit_group) AS d
WHERE d.avg_size in
    (SELECT MIN(d.avg_size) AS min_salary
			FROM (SELECT w.deposit_group, AVG(w.magic_wand_size) AS avg_size
					FROM wizzard_deposits AS w
					GROUP BY w.deposit_group) AS d

	);
	
SELECT lowest_avg_wand_sizes.deposit_group	FROM								
		(SELECT w.deposit_group, AVG(w.magic_wand_size) AS avg_size FROM wizzard_deposits AS w
		GROUP BY w.deposit_group
		ORDER BY avg_size
		LIMIT 1) AS lowest_avg_wand_sizes;	

#5
SELECT w.deposit_group, SUM(w.deposit_amount) AS total_sum FROM `wizzard_deposits` AS w
GROUP BY w.deposit_group;

#6
SELECT w.deposit_group, SUM(w.deposit_amount) AS 'total_sum' FROM `wizzard_deposits` AS w
WHERE w.magic_wand_creator = 'Ollivander family'
GROUP BY w.deposit_group;

#7
SELECT w.deposit_group, SUM(w.deposit_amount) AS 'total_sum' FROM `wizzard_deposits` AS w
WHERE w.magic_wand_creator = 'Ollivander family'
GROUP BY w.deposit_group
HAVING `total_sum` < 150000
ORDER BY `total_sum` DESC;

#8
SELECT 
    wizdep.deposit_group,
    wizdep.magic_wand_creator,
    MIN(wizdep.deposit_charge) AS 'min_deposit_charge'
FROM
    `wizzard_deposits` AS wizdep
GROUP BY wizdep.deposit_group , wizdep.magic_wand_creator
ORDER BY wizdep.magic_wand_creator , wizdep.deposit_group;

#9
SELECT 
    CASE
        WHEN wiz.age BETWEEN 0 AND 10 THEN '[0-10]'
        WHEN wiz.age BETWEEN 11 AND 20 THEN '[11-20]'
        WHEN wiz.age BETWEEN 21 AND 30 THEN '[21-30]'
        WHEN wiz.age BETWEEN 31 AND 40 THEN '[31-40]'
        WHEN wiz.age BETWEEN 41 AND 50 THEN '[41-50]'
        WHEN wiz.age BETWEEN 51 AND 60 THEN '[51-60]'
        WHEN wiz.age > 60 THEN '[61+]'
    END AS age_group,
    COUNT(wiz.id) AS wizzard_count
FROM
    wizzard_deposits AS wiz
GROUP BY age_group;

#10
SELECT SUBSTRING(wiz.first_name,1,1) AS first_letter FROM wizzard_deposits AS wiz
WHERE wiz.deposit_group = 'Troll chest'
GROUP BY first_letter;

#11
SELECT wiz.deposit_group,
wiz.is_deposit_expired,
AVG(wiz.deposit_interest) AS average_interest 
FROM wizzard_deposits AS wiz
WHERE wiz.deposit_start_date > '1985-01-01'
GROUP BY wiz.deposit_group, wiz.is_deposit_expired
ORDER BY wiz.deposit_group desc, wiz.is_deposit_expired;

#12
CREATE VIEW rw_pw AS
SELECT w1.first_name AS host_wizard, w1.deposit_amount AS host_wizard_deposit,
		w2.first_name AS guest_wizard, w2.deposit_amount AS guest_wizard_deposit
FROM wizzard_deposits AS w1, wizzard_deposits AS w2
WHERE  w1.id + 1 = w2.id;

SElECT SUM(host_wizard_deposit - guest_wizard_deposit) AS sum_difference 
FROM rw_pw;

#13
SELECT 
    e.department_id, 
    MIN(e.salary) AS minimum_salary
FROM
    employees AS e
WHERE e.hire_date > '2000-01-01'
GROUP BY e.department_id
HAVING e.department_id IN (2,5,7);

#15
SELECT e.department_id, MAX(e.salary) AS max_salary FROM employees AS e
GROUP BY e.department_id
HAVING max_salary NOT BETWEEN 30000 AND 70000;

#16
SELECT COUNT(e.employee_id) AS count FROM employees AS e
WHERE e.manager_id IS NULL;

#17
SELECT 
    e.department_id, MAX(e.salary) AS third_max_salary
FROM
    employees AS e, (SELECT 
        				e.department_id, MAX(e.salary) AS second_max_salary
    				 FROM
        				employees AS e, (SELECT 
        									e.department_id, 	
                                         	MAX(e.salary) AS max_salary
    									 FROM
        									employees AS e
    									 GROUP BY 
                                         	e.department_id) AS max_sal_by_dep
    				WHERE
        				e.department_id = max_sal_by_dep.department_id
            		AND e.salary < max_sal_by_dep.max_salary
    				GROUP BY e.department_id) AS second_max_sal_by_dep
WHERE
    e.department_id = second_max_sal_by_dep.department_id
AND e.salary < second_max_sal_by_dep.second_max_salary
GROUP BY e.department_id
ORDER BY e.department_id;


#18
SELECT e.first_name, e.last_name, e.department_id FROM
employees AS e,(SELECT e.department_id, AVG(e.salary) AS avg_salary
		   FROM employees AS e
           GROUP BY e.department_id) AS avg_sal_by_dep
WHERE e.department_id = avg_sal_by_dep.department_id
	  AND e.salary > avg_sal_by_dep.avg_salary
ORDER BY e.department_id
LIMIT 10;

#19
SELECT e.department_id, SUM(e.salary) AS total_salary FROM employees AS e
GROUP BY e.department_id;