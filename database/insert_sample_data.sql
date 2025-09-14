-- Insert sample data into employees table
INSERT INTO employees (first_name, last_name, email, phone_number, hire_date, job_title, department)
VALUES
    ('John', 'Doe', 'john.doe@example.com', '123-456-7890', '2022-01-15', 'Software Engineer', 'IT'),
    ('Jane', 'Smith', 'jane.smith@example.com', '987-654-3210', '2021-03-22', 'HR Manager', 'HR'),
    ('Alice', 'Johnson', 'alice.johnson@example.com', '555-123-4567', '2020-07-30', 'Project Manager', 'IT');

-- Insert sample data into departments table
INSERT INTO departments (department_name)
VALUES
    ('IT'),
    ('HR'),
    ('Finance');

-- Insert sample data into salaries table
INSERT INTO salaries (employee_id, salary, effective_date)
VALUES
    (1, 75000.00, '2022-01-15'),
    (2, 65000.00, '2021-03-22'),
    (3, 70000.00, '2020-07-30');
