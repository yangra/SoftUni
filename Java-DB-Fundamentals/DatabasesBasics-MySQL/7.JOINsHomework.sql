#1
SELECT e.employee_id, e.job_title, a.address_id, a.address_text FROM employees AS e
INNER JOIN addresses AS a
ON a.address_id = e.address_id
ORDER BY address_id
LIMIT 5;


#2
SELECT e.first_name, e.last_name, t.name AS town, a.address_text FROM employees AS e
INNER JOIN addresses AS a
ON a.address_id = e.address_id
INNER JOIN towns AS t
ON t.town_id = a.town_id
ORDER BY e.first_name, e.last_name
LIMIT 5;

#3
SELECT e.employee_id, e.first_name, e.last_name, d.name AS department_name FROM employees AS e
JOIN departments AS d
ON e.department_id = d.department_id
WHERE d.name = 'Sales'
ORDER BY e.employee_id DESC;

#4
SELECT e.employee_id, e.first_name, e.salary, d.name AS department_name FROM employees AS e
INNER JOIN departments AS d ON d.department_id = e.department_id
AND e.salary > 15000 
ORDER BY d.department_id DESC
LIMIT 5;

#5
SELECT e.employee_id, e.first_name 
FROM employees AS e
LEFT JOIN employees_projects AS ep
ON e.employee_id = ep.employee_id
WHERE ep.project_id IS NULL							
ORDER BY e.employee_id DESC
LIMIT 3;


SELECT e.employee_id, e.first_name FROM employees AS e
WHERE e.employee_id NOT IN (SELECT ep.employee_id 
							FROM employees_projects AS ep
							GROUP BY ep.employee_id
							)
ORDER BY e.employee_id DESC
LIMIT 3;

#6
SELECT e.first_name, e.last_name, e.hire_date, d.name FROM employees AS e
JOIN departments AS d
ON d.department_id = e.department_id
WHERE DATE(e.hire_date) > '1999/1/1'
AND d.name IN ('Sales', 'Finance')
ORDER BY e.hire_date;

#7
SELECT e.employee_id, e.first_name, p.name AS project_name FROM employees AS e
INNER JOIN employees_projects AS ep ON ep.employee_id = e.employee_id
INNER JOIN projects AS p ON p.project_id = ep.project_id
AND DATE(p.start_date) > '2002/8/13' AND p.end_date IS NULL
ORDER BY e.first_name, p.name
LIMIT 5;

#8
SELECT e.employee_id, e.first_name, CASE WHEN YEAR(p.start_date) >= 2005 THEN NULL
														ELSE p.name
														END AS project_name FROM employees AS e
INNER JOIN employees_projects AS ep ON ep.employee_id = e.employee_id
INNER JOIN projects AS p ON p.project_id = ep.project_id
AND e.employee_id = 24 
ORDER BY e.first_name, p.name;

#9
SELECT e.employee_id, e.first_name, m.employee_id AS manager_id, m.first_name AS manager_name FROM employees AS e
JOIN employees AS m
ON e.manager_id = m.employee_id AND
m.employee_id in (3,7)
ORDER BY e.first_name;

#10
SELECT e.employee_id, 
			CONCAT(e.first_name, ' ', e.last_name) AS employee_name, 
			CONCAT(m.first_name,' ', m.last_name ) AS manager_name,
			d.name AS department_name
FROM employees AS e
INNER JOIN employees AS m
ON e.manager_id = m.employee_id
INNER JOIN departments AS d
ON e.department_id = d.department_id
ORDER BY e.employee_id
LIMIT 5;

#11
SELECT MIN(avg_sal) AS min_average_salary
FROM(	SELECT d.department_id, AVG(e.salary) AS avg_sal FROM employees AS e
		JOIN departments AS d
		ON e.department_id = d.department_id
		GROUP BY d.department_id) AS average;

#12
SELECT c.country_code, m.mountain_range, p.peak_name, p.elevation FROM countries AS c
	INNER JOIN mountains_countries AS mc ON c.country_code = mc.country_code
	INNER JOIN mountains AS m ON m.id = mc.mountain_id
	INNER JOIN peaks AS p ON p.mountain_id = m.id
WHERE c.country_name='Bulgaria' AND p.elevation > 2835
ORDER BY p.elevation DESC;

#13
SELECT c.country_code, COUNT(mc.mountain_id) AS mountain_range FROM countries AS c
LEFT JOIN mountains_countries AS mc
ON c.country_code = mc.country_code
LEFT JOIN mountains AS m
ON m.id = mc.mountain_id
WHERE c.country_name IN ('United States', 'Russia', 'Bulgaria')
GROUP BY c.country_code
ORDER BY mountain_range DESC;

#14
SELECT c.country_name, r.river_name FROM countries AS c
	LEFT JOIN countries_rivers AS cr
	ON cr.country_code = c.country_code
	LEFT JOIN rivers AS r
	ON r.id = cr.river_id
WHERE c.continent_code = 'AF'
ORDER BY c.country_name
LIMIT 5;
	
#15
SELECT co.continent_code, cu.currency_code, COUNT(cu.currency_code) AS currency_usage FROM continents AS co 
INNER JOIN countries AS c ON co.continent_code = c.continent_code
INNER JOIN currencies AS cu ON c.currency_code = cu.currency_code
GROUP BY co.continent_code, cu.currency_code;
HAVING currency_usage > 1;

SELECT max_cu_use.continent_code, cu_use.currency_code, max_cu_use.max_use AS currency_usage FROM(
SELECT cu_usage.continent_code, MAX(cu_usage.currency_usage) AS max_use FROM (SELECT cont.continent_code, curr.currency_code, COUNT(curr.currency_code) AS currency_usage FROM continents as cont
		JOIN countries AS coun
		ON coun.continent_code = cont.continent_code
		JOIN currencies AS curr
		ON coun.currency_code = curr.currency_code
	GROUP BY cont.continent_code, curr.currency_code
	HAVING currency_usage > 1) AS cu_usage
GROUP BY cu_usage.continent_code) AS max_cu_use
JOIN
(SELECT cont.continent_code, curr.currency_code, COUNT(curr.currency_code) AS currency_usage FROM continents as cont
		JOIN countries AS coun
		ON coun.continent_code = cont.continent_code
		JOIN currencies AS curr
		ON coun.currency_code = curr.currency_code
	GROUP BY cont.continent_code, curr.currency_code
	HAVING currency_usage > 1) AS cu_use
ON cu_use.continent_code = max_cu_use.continent_code 
AND max_cu_use.max_use = cu_use.currency_usage
ORDER BY max_cu_use.continent_code, cu_use.currency_code;
	
#16
SELECT COUNT(*) AS country_count 
FROM countries AS c
		LEFT JOIN mountains_countries AS mc
		ON c.country_code = mc.country_code
		WHERE mc.mountain_id IS NULL;
		
#17
SELECT max_peak.country_name, max_peak.highest_peak_elevation, max_river.longest_river_length FROM
 (SELECT 	c.country_name, 
			MAX(p.elevation) AS highest_peak_elevation 			 
	FROM countries AS c
	LEFT JOIN mountains_countries AS mc
	ON mc.country_code = c.country_code
	LEFT JOIN mountains AS m
	ON m.id = mc.mountain_id
	LEFT JOIN peaks AS p
	ON p.mountain_id = m.id
GROUP BY c.country_name) AS max_peak
INNER JOIN	
		(SELECT 	co.country_name,
					MAX(r.length) AS longest_river_length
			FROM countries AS co
			LEFT JOIN countries_rivers AS cr
			ON cr.country_code = co.country_code
			LEFT JOIN rivers AS r
			ON cr.river_id = r.id
		GROUP BY co.country_name) AS max_river
ON max_peak.country_name = max_river.country_name
ORDER BY max_peak.highest_peak_elevation DESC, max_river.longest_river_length DESC, max_peak.country_name
LIMIT 5;