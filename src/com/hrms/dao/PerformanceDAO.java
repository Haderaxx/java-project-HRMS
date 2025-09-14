package com.hrms.dao;

import com.hrms.model.PerformanceReview;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PerformanceDAO {
    private static final String FILE_NAME = "performance.ser";

    public void saveReviews(List<PerformanceReview> reviews) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(reviews);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<PerformanceReview> loadReviews() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<PerformanceReview>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}

