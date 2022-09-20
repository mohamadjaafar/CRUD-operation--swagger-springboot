package com.example.youtabJavaTest.user.DTOS;

import lombok.Getter;
import lombok.Setter;

/**
 * address model containing all the information about the address
 */
@Getter
@Setter
public class AddressDTO {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDTO geo;

}


