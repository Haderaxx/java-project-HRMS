package com.hrms.service;

import com.hrms.dao.UserDAO;
import com.hrms.model.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public boolean registerUser(User user) {
        return userDAO.register(user);
    }

    public User loginUser(String username, String password) {
        return userDAO.login(username, password);
    }
}
