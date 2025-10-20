package com.hrms.service;

import com.hrms.dao.AttendanceDAO;
import com.hrms.model.Attendance;
import java.util.List;

public class AttendanceService {
    private AttendanceDAO attendanceDAO = new AttendanceDAO();

    // Save attendance for multiple records
    public void markAttendance(List<Attendance> attendanceList) {
        for (Attendance attendance : attendanceList) {
            attendanceDAO.markAttendance(attendance);
        }
    }

    // Fetch all attendance records
    public List<Attendance> getAttendanceRecords() {
        return attendanceDAO.getAllAttendance();
    }
}

