-- Retrieve all employees
SELECT * FROM employees;

-- Retrieve all departments
SELECT * FROM departments;

-- Retrieve all salaries
SELECT * FROM salaries;

-- Retrieve employees with their department names
SELECT e.first_name, e.last_name, d.department_name
FROM employees e
JOIN departments d ON e.department = d.department_name;

-- Retrieve employees with their salary details
SELECT e.first_name, e.last_name, s.salary
FROM employees e
JOIN salaries s ON e.employee_id = s.employee_id;
