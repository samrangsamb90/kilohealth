package com.spring.demo_project.model.response;

import lombok.Data;

@Data
public class AddressResponse {
    private Long id;
    private String title;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private String landmark;
    private String phoneNumber;

    private UserRS user;
}
