package com.hrms.service;

import com.hrms.dao.LeaveDAO;
import com.hrms.model.LeaveRequest;
import java.util.List;

public class LeaveService {
    private LeaveDAO leaveDAO = new LeaveDAO();

    public void saveLeaveRequests(List<LeaveRequest> requests) {
        leaveDAO.saveLeaves(requests);
    }

    public List<LeaveRequest> getLeaveRequests() {
        return leaveDAO.loadLeaves();
    }
}

