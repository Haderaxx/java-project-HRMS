package com.hrms.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
   private static final String URL = "jdbc:mysql://localhost:3306/hrms_db";
private static final String USER = "hrms_user";
private static final String PASSWORD = "Hrms@123";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

