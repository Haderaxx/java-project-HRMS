package com.hrms.service;

import com.hrms.dao.AttendanceDAO;
import com.hrms.model.Attendance;
import java.util.List;

public class AttendanceService {
    private AttendanceDAO attendanceDAO = new AttendanceDAO();

    public void markAttendance(List<Attendance> attendanceList) {
        attendanceDAO.saveAttendance(attendanceList);
    }

    public List<Attendance> getAttendanceRecords() {
        return attendanceDAO.loadAttendance();
    }
}

