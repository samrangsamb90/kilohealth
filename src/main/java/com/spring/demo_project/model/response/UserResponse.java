package com.spring.demo_project.model.response;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class UserResponse {
    private Long id;
    private String profile;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String phoneNumber;
    private Date dob;

    private Set<RoleResponse> roles;
}
