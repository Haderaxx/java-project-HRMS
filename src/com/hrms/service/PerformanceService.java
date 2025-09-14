package com.hrms.service;

import com.hrms.dao.PerformanceDAO;
import com.hrms.model.PerformanceReview;
import java.util.List;

public class PerformanceService {
    private PerformanceDAO performanceDAO = new PerformanceDAO();

    public void saveReviews(List<PerformanceReview> reviews) {
        performanceDAO.saveReviews(reviews);
    }

    public List<PerformanceReview> getReviews() {
        return performanceDAO.loadReviews();
    }
}

