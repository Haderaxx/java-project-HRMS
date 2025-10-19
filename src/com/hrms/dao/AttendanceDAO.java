package com.hrms.dao;

import java.sql.*;
import java.util.*;
import com.hrms.model.Attendance;
import com.hrms.util.DBConnection;

public class AttendanceDAO {

    // Add new attendance record
    public void addAttendance(Attendance attendance) {
        String sql = "INSERT INTO attendance (employee_id, date, status) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, attendance.getEmployeeId());
            stmt.setDate(2, java.sql.Date.valueOf(attendance.getDate())); // convert LocalDate/String to SQL Date
            stmt.setString(3, attendance.getStatus());
            stmt.executeUpdate();

            System.out.println("✅ Attendance added for employee ID: " + attendance.getEmployeeId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all attendance records
    public List<Attendance> getAllAttendance() {
        List<Attendance> attendanceList = new ArrayList<>();
        String sql = "SELECT * FROM attendance";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Attendance att = new Attendance();
                att.setId(rs.getInt("id"));
                att.setEmployeeId(rs.getInt("employee_id"));
                att.setDate(rs.getDate("date").toString());
                att.setStatus(rs.getString("status"));
                attendanceList.add(att);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceList;
    }

    // Get attendance by employee ID
    public List<Attendance> getAttendanceByEmployee(int empId) {
        List<Attendance> attendanceList = new ArrayList<>();
        String sql = "SELECT * FROM attendance WHERE employee_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, empId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Attendance att = new Attendance();
                att.setId(rs.getInt("id"));
                att.setEmployeeId(rs.getInt("employee_id"));
                att.setDate(rs.getDate("date").toString());
                att.setStatus(rs.getString("status"));
                attendanceList.add(att);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceList;
    }
}
