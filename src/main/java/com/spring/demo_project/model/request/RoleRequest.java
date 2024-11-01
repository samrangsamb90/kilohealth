package com.spring.demo_project.model.request;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class RoleRequest {
    private String name;
    private String code;

    private Set<Long> permissionId = new HashSet<>();
}
