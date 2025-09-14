package com.hrms.model;

import java.io.Serializable;

public class PerformanceReview implements Serializable {
    private int reviewId;
    private int employeeId;
    private String feedback;
    private int rating; // e.g. 1-5

    public PerformanceReview(int reviewId, int employeeId, String feedback, int rating) {
        this.reviewId = reviewId;
        this.employeeId = employeeId;
        this.feedback = feedback;
        this.rating = rating;
    }

    public int getReviewId() { return reviewId; }
    public int getEmployeeId() { return employeeId; }
    public String getFeedback() { return feedback; }
    public int getRating() { return rating; }
}

