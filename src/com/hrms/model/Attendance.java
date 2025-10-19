package com.hrms.model;

public class Attendance {
    private int id;
    private int employeeId;
    private String date;   // can store date as "YYYY-MM-DD" format
    private String status; // "Present" or "Absent"

    // Constructors
    public Attendance() {}

    public Attendance(int employeeId, String date, String status) {
        this.employeeId = employeeId;
        this.date = date;
        this.status = status;
    }

    public Attendance(int id, int employeeId, String date, String status) {
        this.id = id;
        this.employeeId = employeeId;
        this.date = date;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    // Optional: helpful for debugging
    @Override
    public String toString() {
        return "Attendance [id=" + id + ", employeeId=" + employeeId +
               ", date=" + date + ", status=" + status + "]";
    }
}
