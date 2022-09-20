package com.example.youtabJavaTest.user.service;

import com.example.youtabJavaTest.user.model.User;

/**
 * user service interface containing all the function declarations for the user
 */
public interface UserService {
    User getUserByIdOrUserName(String key);
}
