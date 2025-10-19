package com.hrms.model;

public class LeaveRequest {
    private int id;
    private int employeeId;
    private String startDate;
    private String endDate;
    private String reason;
    private String status;
    private String appliedOn;

    public LeaveRequest() {}

    public LeaveRequest(int employeeId, String startDate, String endDate, String reason, String status, String appliedOn) {
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.status = status;
        this.appliedOn = appliedOn;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getAppliedOn() { return appliedOn; }
    public void setAppliedOn(String appliedOn) { this.appliedOn = appliedOn; }

    @Override
    public String toString() {
        return "LeaveRequest [id=" + id + ", employeeId=" + employeeId + ", startDate=" + startDate +
               ", endDate=" + endDate + ", reason=" + reason + ", status=" + status +
               ", appliedOn=" + appliedOn + "]";
    }
}


