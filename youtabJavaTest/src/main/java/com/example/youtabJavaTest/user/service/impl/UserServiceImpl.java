package com.example.youtabJavaTest.user.service.impl;

import com.example.youtabJavaTest.feign.JsonPlaceHolderApiClient;
import com.example.youtabJavaTest.user.model.User;
import com.example.youtabJavaTest.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * user service implementaion interface containing all the function implementations for the user
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private JsonPlaceHolderApiClient jsonPlaceHolder;

    @Override
    public User getUserByIdOrUserName(String key) {
        log.debug("calling the json place holder api to get all users");
        List<User> users = jsonPlaceHolder.getUserByIdOrUserName();
        User returnUser = new User();
        returnUser.setId(-1);
        log.debug("looping over all the users in order to check if the key belongs to any user");
        for (User user : users) {
            if (String.valueOf(user.getId()).equals(key) || user.getUsername().equals(key)) {
                log.debug("user found");
               return user;
            }
        }
        return returnUser;
    }
}
