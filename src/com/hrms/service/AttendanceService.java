package com.hrms.service;

import java.util.List;
import com.hrms.dao.AttendanceDAO;

import com.hrms.model.Attendance;

public class AttendanceService {

	private AttendanceDAO attendanceDAO = new AttendanceDAO();

	public void markAttendance(Attendance att) {
		attendanceDAO.addAttendance(att);
	}

	public List<Attendance> getAllAttendance() {
		return attendanceDAO.getAllAttendance();
	}

	public List<Attendance> getAttendanceByEmployee(int empId) {
		return attendanceDAO.getAttendanceByEmployee(empId);
	}
}
