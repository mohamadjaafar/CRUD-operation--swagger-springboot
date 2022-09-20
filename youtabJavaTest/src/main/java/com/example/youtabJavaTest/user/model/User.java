package com.example.youtabJavaTest.user.model;

import com.example.youtabJavaTest.user.DTOS.AddressDTO;
import com.example.youtabJavaTest.user.DTOS.CompanyDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * user model containing all the information about the user
 */
@Getter
@Setter
@Component
public class User {
    private Integer id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private AddressDTO address;
    private CompanyDTO company;



}

