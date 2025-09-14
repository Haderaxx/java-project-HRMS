package com.hrms.dao;

import com.hrms.model.LeaveRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeaveDAO {
    private static final String FILE_NAME = "leaves.ser";

    public void saveLeaves(List<LeaveRequest> leaveRequests) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(leaveRequests);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<LeaveRequest> loadLeaves() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<LeaveRequest>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}

