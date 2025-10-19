package com.hrms.service;

import com.hrms.dao.PerformanceDAO;
import com.hrms.model.PerformanceReview;
import java.util.List;

public class PerformanceService {

    private PerformanceDAO performanceDAO;

    public PerformanceService() {
        this.performanceDAO = new PerformanceDAO();
    }

    public PerformanceService(PerformanceDAO performanceDAO) {
        this.performanceDAO = performanceDAO;
    }

    // Add a new review
    public void addPerformanceReview(PerformanceReview review) {
        performanceDAO.addReview(review);
    }

    // Get all reviews
    public List<PerformanceReview> getAllPerformanceReviews() {
        return performanceDAO.getAllReviews();
    }

    // Get reviews for a specific employee
    public List<PerformanceReview> getReviewsByEmployee(int employeeId) {
        return performanceDAO.getByEmployee(employeeId);
    }

    // Update a review
    public boolean updatePerformanceReview(PerformanceReview review) {
        return performanceDAO.updateReview(review);
    }

    // Delete a review
    public boolean deletePerformanceReview(int reviewId) {
        return performanceDAO.deleteReview(reviewId);
    }
}
