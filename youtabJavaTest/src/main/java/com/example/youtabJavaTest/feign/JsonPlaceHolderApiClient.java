package com.example.youtabJavaTest.feign;

import com.example.youtabJavaTest.user.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Interface that handle persona ms api calls through open feign
 */
@FeignClient(value = "jsonpaceholder", url = "https://jsonplaceholder.typicode.com")
public interface JsonPlaceHolderApiClient {

    @GetMapping({"/users"})
    List<User> getUserByIdOrUserName();
}