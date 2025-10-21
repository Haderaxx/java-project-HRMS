package com.hrms.model;

public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor with ID (used when fetching from DB)
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Constructor without ID (used when adding new employees)
    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // To String
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary + "]";
    }

    // Test main method
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Apoor", "IT", 50000.0);
        Employee emp2 = new Employee("John", "HR", 40000.0);
        System.out.println(emp1);
        System.out.println(emp2);
    }
}
