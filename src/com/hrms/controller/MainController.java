package com.hrms.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.hrms.model.Employee;
import com.hrms.model.Attendance;
import com.hrms.model.LeaveRequest;
import com.hrms.service.EmployeeService;
import com.hrms.service.AttendanceService;
import com.hrms.service.LeaveService;
import com.hrms.service.PerformanceService;

public class MainController {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeService();
        AttendanceService attendanceService = new AttendanceService();
        LeaveService leaveService = new LeaveService();
        PerformanceService performanceService = new PerformanceService();

        System.out.println("========= HR MANAGEMENT SYSTEM =========");

        while (true) {
            System.out.println("\n1️⃣  Add Employee");
            System.out.println("2️⃣  View All Employees");
            System.out.println("3️⃣  Mark Attendance");
            System.out.println("4️⃣  View Attendance Records");
            System.out.println("5️⃣  Apply Leave");
            System.out.println("6️⃣  Approve/Reject Leave");
            System.out.println("7️⃣  Exit");
            System.out.print("👉 Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: {
                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    Employee emp = new Employee(name, dept, salary);
                    employeeService.addEmployee(emp);
                    System.out.println("✅ Employee added successfully!");
                    break;
                }

                case 2: {
                    List<Employee> employees = employeeService.getAllEmployees();
                    System.out.println("\n========= EMPLOYEE LIST =========");
                    for (Employee e : employees) {
                        System.out.println(e);
                    }
                    break;
                }

                case 3: {
                    System.out.print("Enter Employee ID: ");
                    int empId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Status (Present/Absent): ");
                    String status = sc.nextLine();

                    Attendance att = new Attendance(empId, LocalDate.now().toString(), status);
                    attendanceService.markAttendance(att);
                    System.out.println("✅ Attendance recorded!");
                    break;
                }

                case 4: {
                    List<Attendance> records = attendanceService.getAllAttendance();
                    System.out.println("\n========= ATTENDANCE RECORDS =========");
                    for (Attendance a : records) {
                        System.out.println(a);
                    }
                    break;
                }

                case 5: {
                    System.out.print("Enter Employee ID: ");
                    int empId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Start Date (YYYY-MM-DD): ");
                    String startDate = sc.nextLine();
                    System.out.print("Enter End Date (YYYY-MM-DD): ");
                    String endDate = sc.nextLine();
                    System.out.print("Enter Reason: ");
                    String reason = sc.nextLine();

                    LeaveRequest leave = new LeaveRequest(empId, startDate, endDate, reason, "Pending", LocalDate.now().toString());
                    leaveService.applyLeave(leave);
                    System.out.println("✅ Leave request submitted successfully!");
                    break;
                }

                case 6: {
                    System.out.println("\n========= LEAVE REQUESTS =========");
                    List<LeaveRequest> leaves = leaveService.getAllLeaves();
                    for (LeaveRequest l : leaves) {
                        System.out.println(l);
                    }

                    System.out.print("\nEnter Leave ID to update: ");
                    int leaveId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Approve or Reject? (A/R): ");
                    String decision = sc.nextLine().toUpperCase();

                    if (decision.equals("A")) {
                        leaveService.approveLeave(leaveId);
                        System.out.println("✅ Leave approved!");
                    } else if (decision.equals("R")) {
                        leaveService.rejectLeave(leaveId);
                        System.out.println("❌ Leave rejected!");
                    } else {
                        System.out.println("⚠️ Invalid choice.");
                    }
                    break;
                }

                case 7: {
                    System.out.println("👋 Exiting HRMS... Goodbye!");
                    sc.close();
                    return;
                }

                default:
                    System.out.println("⚠️ Invalid option, try again!");
            }
        }
    }
}
