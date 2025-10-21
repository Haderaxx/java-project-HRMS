package com.hrms.service;

import java.util.List;
import com.hrms.dao.LeaveDAO;
import com.hrms.model.LeaveRequest;

public class LeaveService {
    private LeaveDAO leaveDAO = new LeaveDAO();

    public void applyLeave(LeaveRequest leave) {
        leaveDAO.saveLeave(leave);
    }

    public List<LeaveRequest> getAllLeaves() {
        return leaveDAO.getAllLeaves();
    }

    public void approveLeave(int leaveId) {
        leaveDAO.updateLeaveStatus(leaveId, "Approved");
    }

    public void rejectLeave(int leaveId) {
        leaveDAO.updateLeaveStatus(leaveId, "Rejected");
    }
}
