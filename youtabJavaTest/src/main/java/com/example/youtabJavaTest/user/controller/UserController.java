package com.example.youtabJavaTest.user.controller;

import com.example.youtabJavaTest.user.model.User;
import com.example.youtabJavaTest.user.service.UserService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * user controller containig the api for getting the user by id or username
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * function responsible for the api call for getting user by id or username
     * @param key
     * @return
     */
    @GetMapping("/getusercontacts/{key}")
    public User getUserByIdOrUserName(@PathVariable @ApiParam("id or username") String key){
      return userService.getUserByIdOrUserName(key);
    }
}
