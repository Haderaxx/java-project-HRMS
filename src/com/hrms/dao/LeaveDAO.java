package com.hrms.dao;

import com.hrms.model.LeaveRequest;
import com.hrms.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeaveDAO {

    // 🔹 Add new leave request
    public void addLeave(LeaveRequest leaveRequest) {
        String query = "INSERT INTO leave_requests (employee_id, start_date, end_date, reason, status, applied_on) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, leaveRequest.getEmployeeId());
            stmt.setString(2, leaveRequest.getStartDate());
            stmt.setString(3, leaveRequest.getEndDate());
            stmt.setString(4, leaveRequest.getReason());
            stmt.setString(5, leaveRequest.getStatus());
            stmt.setString(6, leaveRequest.getAppliedOn());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 Get all leave requests
    public List<LeaveRequest> getAllLeaves() {
        List<LeaveRequest> leaveList = new ArrayList<>();
        String query = "SELECT * FROM leave_requests";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                LeaveRequest leave = new LeaveRequest();
                leave.setId(rs.getInt("id"));
                leave.setEmployeeId(rs.getInt("employee_id"));
                leave.setStartDate(rs.getString("start_date"));
                leave.setEndDate(rs.getString("end_date"));
                leave.setReason(rs.getString("reason"));
                leave.setStatus(rs.getString("status"));
                leave.setAppliedOn(rs.getString("applied_on"));
                leaveList.add(leave);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return leaveList;
    }

    // 🔹 Update leave status (Approve/Reject)
    public void updateLeaveStatus(int leaveId, String status) {
        String query = "UPDATE leave_requests SET status = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, status);
            stmt.setInt(2, leaveId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 Get leaves by employee ID (optional)
    public List<LeaveRequest> getLeavesByEmployee(int employeeId) {
        List<LeaveRequest> leaveList = new ArrayList<>();
        String query = "SELECT * FROM leave_requests WHERE employee_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                LeaveRequest leave = new LeaveRequest();
                leave.setId(rs.getInt("id"));
                leave.setEmployeeId(rs.getInt("employee_id"));
                leave.setStartDate(rs.getString("start_date"));
                leave.setEndDate(rs.getString("end_date"));
                leave.setReason(rs.getString("reason"));
                leave.setStatus(rs.getString("status"));
                leave.setAppliedOn(rs.getString("applied_on"));
                leaveList.add(leave);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return leaveList;
    }
}


