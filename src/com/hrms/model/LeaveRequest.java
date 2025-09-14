package com.hrms.model;

import java.io.Serializable;
import java.time.LocalDate;

public class LeaveRequest implements Serializable {
    private int requestId;
    private int employeeId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String status; // Pending, Approved, Rejected

    public LeaveRequest(int requestId, int employeeId, LocalDate fromDate, LocalDate toDate, String status) {
        this.requestId = requestId;
        this.employeeId = employeeId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.status = status;
    }

    public int getRequestId() { return requestId; }
    public int getEmployeeId() { return employeeId; }
    public LocalDate getFromDate() { return fromDate; }
    public LocalDate getToDate() { return toDate; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}

