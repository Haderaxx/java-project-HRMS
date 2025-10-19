package com.hrms.service;

import com.hrms.dao.LeaveDAO;
import com.hrms.model.LeaveRequest;
import java.util.List;

public class LeaveService {

    private LeaveDAO leaveDAO = new LeaveDAO();

    public void applyLeave(LeaveRequest leaveRequest) {
        leaveDAO.addLeave(leaveRequest);
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

