package com.spring.demo_project.model.request;

import lombok.Data;

@Data
public class AddressRequest {
    private String title;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private String landmark;
    private String phoneNumber;

    private Long userId;
}
