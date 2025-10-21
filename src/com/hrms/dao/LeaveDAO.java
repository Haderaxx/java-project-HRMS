package com.hrms.dao;

import java.sql.*;
import java.util.*;
import com.hrms.model.LeaveRequest;
import com.hrms.util.DBConnection;

public class LeaveDAO {

    public void saveLeave(LeaveRequest leave) {
        String sql = "INSERT INTO leave_requests (employee_id, start_date, end_date, reason, status, applied_on) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, leave.getEmployeeId());
            stmt.setString(2, leave.getStartDate());
            stmt.setString(3, leave.getEndDate());
            stmt.setString(4, leave.getReason());
            stmt.setString(5, leave.getStatus());
            stmt.setString(6, leave.getAppliedOn());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<LeaveRequest> getAllLeaves() {
        List<LeaveRequest> leaves = new ArrayList<>();
        String sql = "SELECT * FROM leave_requests";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                LeaveRequest leave = new LeaveRequest();
                leave.setId(rs.getInt("id"));
                leave.setEmployeeId(rs.getInt("employee_id"));
                leave.setStartDate(rs.getString("start_date"));
                leave.setEndDate(rs.getString("end_date"));
                leave.setReason(rs.getString("reason"));
                leave.setStatus(rs.getString("status"));
                leave.setAppliedOn(rs.getString("applied_on"));
                leaves.add(leave);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return leaves;
    }

    public void updateLeaveStatus(int leaveId, String status) {
        String sql = "UPDATE leave_requests SET status = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);
            stmt.setInt(2, leaveId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
