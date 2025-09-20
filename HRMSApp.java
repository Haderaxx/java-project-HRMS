import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.List;

import com.hrms.dao.EmployeeDAO;
import com.hrms.dao.AttendanceDAO;
import com.hrms.model.Employee;
import com.hrms.model.Attendance;

public class HRMSApp extends JFrame {

    private EmployeeDAO empDao = new EmployeeDAO();
    private AttendanceDAO attDao = new AttendanceDAO();

    private JTextArea outputArea;

    public HRMSApp() {
        setTitle("HRMS Frontend");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Output Area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        JButton addEmpBtn = new JButton("Add Employee");
        JButton viewEmpBtn = new JButton("View Employees");
        JButton markAttBtn = new JButton("Mark Attendance");
        JButton viewAttBtn = new JButton("View Attendance");

        buttonPanel.add(addEmpBtn);
        buttonPanel.add(viewEmpBtn);
        buttonPanel.add(markAttBtn);
        buttonPanel.add(viewAttBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        // Button Actions
        addEmpBtn.addActionListener(e -> addEmployee());
        viewEmpBtn.addActionListener(e -> viewEmployees());
        markAttBtn.addActionListener(e -> markAttendance());
        viewAttBtn.addActionListener(e -> viewAttendance());
    }

    private void addEmployee() {
        String name = JOptionPane.showInputDialog(this, "Enter Employee Name:");
        String dept = JOptionPane.showInputDialog(this, "Enter Department:");
        String salaryStr = JOptionPane.showInputDialog(this, "Enter Salary:");

        try {
            double salary = Double.parseDouble(salaryStr);
            empDao.addEmployee(new Employee(0, name, dept, salary));
            outputArea.append("✅ Employee added: " + name + "\n");
        } catch (Exception ex) {
            outputArea.append("❌ Error: " + ex.getMessage() + "\n");
        }
    }

    private void viewEmployees() {
        List<Employee> employees = empDao.getAllEmployees();
        outputArea.append("\n--- Employees ---\n");
        for (Employee e : employees) {
            outputArea.append(e.toString() + "\n");
        }
    }

    private void markAttendance() {
        String empIdStr = JOptionPane.showInputDialog(this, "Enter Employee ID:");
        String dateStr = JOptionPane.showInputDialog(this, "Enter Date (YYYY-MM-DD):");
        String status = JOptionPane.showInputDialog(this, "Enter Status (Present/Absent):");

        try {
            int empId = Integer.parseInt(empIdStr);
            attDao.markAttendance(new Attendance(0, empId, Date.valueOf(dateStr), status));
            outputArea.append("✅ Attendance marked for Employee ID " + empId + "\n");
        } catch (Exception ex) {
            outputArea.append("❌ Error: " + ex.getMessage() + "\n");
        }
    }

    private void viewAttendance() {
        List<Attendance> records = attDao.getAllAttendance();
        outputArea.append("\n--- Attendance Records ---\n");
        for (Attendance a : records) {
            outputArea.append(a.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HRMSApp().setVisible(true);
        });
    }
}
