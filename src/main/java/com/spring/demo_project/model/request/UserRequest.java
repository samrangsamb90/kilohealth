package com.spring.demo_project.model.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class UserRequest {

    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private LocalDate dob;

    private Set<Long> roleId;
}
