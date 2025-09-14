package com.hrms.controller;

import com.hrms.dao.EmployeeDAO;
import com.hrms.dao.AttendanceDAO;
import com.hrms.model.Employee;
import com.hrms.model.Attendance;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO empDao = new EmployeeDAO();
        AttendanceDAO attDao = new AttendanceDAO();

        while (true) {
            System.out.println("\n=== HRMS MENU ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Mark Attendance");
            System.out.println("4. View All Attendance Records");
            System.out.println("5. View Attendance by Employee ID");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    empDao.addEmployee(new Employee(0, name, dept, salary));
                    break;

                case 2:
                    List<Employee> employees = empDao.getAllEmployees();
                    System.out.println("\n--- Employees ---");
                    for (Employee e : employees) {
                        System.out.println(e.getId() + " | " + e.getName() + " | " + e.getDepartment() + " | " + e.getSalary());
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID: ");
                    int empId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String dateStr = sc.nextLine();
                    System.out.print("Enter Status (Present/Absent): ");
                    String status = sc.nextLine();

                    attDao.markAttendance(new Attendance(0, empId, Date.valueOf(dateStr), status));
                    break;

                case 4:
                    List<Attendance> records = attDao.getAllAttendance();
                    System.out.println("\n--- Attendance Records ---");
                    for (Attendance a : records) {
                        System.out.println(a);
                    }
                    break;

                case 5:
                    System.out.print("Enter Employee ID: ");
                    int empIdSearch = sc.nextInt();
                    sc.nextLine();

                    List<Attendance> empRecords = attDao.getAttendanceByEmployee(empIdSearch);
                    System.out.println("\n--- Attendance for Employee ID " + empIdSearch + " ---");
                    for (Attendance a : empRecords) {
                        System.out.println(a);
                    }
                    break;

                case 6:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice, try again.");
            }
        }
    }
}
