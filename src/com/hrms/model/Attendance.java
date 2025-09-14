package com.hrms.model;

import java.sql.Date;

public class Attendance {
    private int id;
    private int employeeId;
    private Date date;
    private String status;

    public Attendance(int id, int employeeId, Date date, String status) {
        this.id = id;
        this.employeeId = employeeId;
        this.date = date;
        this.status = status;
    }

    // Getters & Setters
    public int getId() { return id; }
    public int getEmployeeId() { return employeeId; }
    public Date getDate() { return date; }
    public String getStatus() { return status; }

    public void setId(int id) { this.id = id; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }
    public void setDate(Date date) { this.date = date; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Attendance [id=" + id + ", employeeId=" + employeeId + ", date=" + date + ", status=" + status + "]";
    }
}

