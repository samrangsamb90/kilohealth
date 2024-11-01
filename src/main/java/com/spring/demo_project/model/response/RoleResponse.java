package com.spring.demo_project.model.response;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class RoleResponse {
    private Long id;
    private String name;
    private String code;

    private Set<PermissionResponse> permissions =new HashSet<>();
}
