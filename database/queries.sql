
SELECT * FROM employees;

SELECT * FROM departments;

SELECT * FROM salaries;

SELECT e.first_name, e.last_name, d.department_name
FROM employees e
JOIN departments d ON e.department = d.department_name;

SELECT e.first_name, e.last_name, s.salary
FROM employees e
JOIN salaries s ON e.employee_id = s.employee_id;

