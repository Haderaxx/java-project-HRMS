package com.hrms.service;

import com.hrms.dao.AttendanceDAO;
import com.hrms.model.Attendance;
import java.util.List;

public class AttendanceService {

    private AttendanceDAO attendanceDAO = new AttendanceDAO();

    // Mark attendance for multiple employees
    public void markAttendance(List<Attendance> attendanceList) {
        for (Attendance att : attendanceList) {
            attendanceDAO.markAttendance(att);
        }
    }

    // Get all attendance records
    public List<Attendance> getAllAttendance() {
        return attendanceDAO.getAllAttendance();
    }

    // Get attendance for a specific employee
    public List<Attendance> getAttendanceByEmployee(int empId) {
        return attendanceDAO.getAttendanceByEmployee(empId);
    }
}

