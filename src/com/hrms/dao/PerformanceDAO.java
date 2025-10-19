package com.hrms.dao;

import com.hrms.model.PerformanceReview;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PerformanceDAO {
    private static final String FILE_NAME = "performance.ser";
    private List<PerformanceReview> reviews;

    public PerformanceDAO() {
        reviews = loadReviews();
    }

    // Load reviews from file
    @SuppressWarnings("unchecked")
    private List<PerformanceReview> loadReviews() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<PerformanceReview>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    // Save reviews to file
    private void saveReviews() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(reviews);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add a review
    public void addReview(PerformanceReview review) {
        reviews.add(review);
        saveReviews();
    }

    // Get all reviews
    public List<PerformanceReview> getAllReviews() {
        return new ArrayList<>(reviews);
    }

    // Get reviews by employee ID
    public List<PerformanceReview> getByEmployee(int employeeId) {
        return reviews.stream()
                .filter(r -> r.getEmployeeId() == employeeId)
                .collect(Collectors.toList());
    }

    // Optional: update a review
    public boolean updateReview(PerformanceReview updatedReview) {
        for (int i = 0; i < reviews.size(); i++) {
            if (reviews.get(i).getReviewId() == updatedReview.getReviewId()) {
                reviews.set(i, updatedReview);
                saveReviews();
                return true;
            }
        }
        return false;
    }

    // Optional: delete a review by ID
    public boolean deleteReview(int reviewId) {
        boolean removed = reviews.removeIf(r -> r.getReviewId() == reviewId);
        if (removed) saveReviews();
        return removed;
    }
}
