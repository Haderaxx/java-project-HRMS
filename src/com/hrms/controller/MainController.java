package com.hrms.controller;

import com.hrms.service.PerformanceService;
import com.hrms.model.PerformanceReview;
import java.util.List;
import java.util.Scanner;


public class MainController {

    private static PerformanceService performanceService = new PerformanceService();
    private static Scanner sc = new Scanner(System.in);

    public static void performanceMenu() {
        while (true) {
            System.out.println("\n=== Performance Reviews Menu ===");
            System.out.println("1. Add Review");
            System.out.println("2. View All Reviews");
            System.out.println("3. View Reviews by Employee");
            System.out.println("4. Update Review");
            System.out.println("5. Delete Review");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addReview();
                    break;
                case 2:
                    viewAllReviews();
                    break;
                case 3:
                    viewReviewsByEmployee();
                    break;
                case 4:
                    updateReview();
                    break;
                case 5:
                    deleteReview();
                    break;
                case 6:
                    return; // back to main menu
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addReview() {
        System.out.print("Employee ID: ");
        int empId = sc.nextInt();
        sc.nextLine();
        System.out.print("Review ID: ");
        int reviewId = sc.nextInt();
        sc.nextLine();
        System.out.print("Feedback: ");
        String feedback = sc.nextLine();
        System.out.print("Rating (1-5): ");
        int rating = sc.nextInt();
        sc.nextLine();

        PerformanceReview review = new PerformanceReview(reviewId, empId, feedback, rating);
        performanceService.addPerformanceReview(review);
        System.out.println("Review added successfully!");
    }

    private static void viewAllReviews() {
        List<PerformanceReview> reviews = performanceService.getAllPerformanceReviews();
        if (reviews.isEmpty()) {
            System.out.println("No reviews found.");
        } else {
            reviews.forEach(System.out::println);
        }
    }

    private static void viewReviewsByEmployee() {
        System.out.print("Enter Employee ID: ");
        int empId = sc.nextInt();
        sc.nextLine();
        List<PerformanceReview> reviews = performanceService.getReviewsByEmployee(empId);
        if (reviews.isEmpty()) {
            System.out.println("No reviews found for employee " + empId);
        } else {
            reviews.forEach(System.out::println);
        }
    }

    private static void updateReview() {
        System.out.print("Enter Review ID to update: ");
        int reviewId = sc.nextInt();
        sc.nextLine();
        System.out.print("Employee ID: ");
        int empId = sc.nextInt();
        sc.nextLine();
        System.out.print("Updated Feedback: ");
        String feedback = sc.nextLine();
        System.out.print("Updated Rating (1-5): ");
        int rating = sc.nextInt();
        sc.nextLine();

        PerformanceReview review = new PerformanceReview(reviewId, empId, feedback, rating);
        if (performanceService.updatePerformanceReview(review)) {
            System.out.println("Review updated successfully!");
        } else {
            System.out.println("Review ID not found.");
        }
    }

    private static void deleteReview() {
        System.out.print("Enter Review ID to delete: ");
        int reviewId = sc.nextInt();
        sc.nextLine();
        if (performanceService.deletePerformanceReview(reviewId)) {
            System.out.println("Review deleted successfully!");
        } else {
            System.out.println("Review ID not found.");
        }
    }
}
