package com.spring.demo_project.model.request;

import lombok.Data;

@Data
public class SubCategoryRequest {
    private String name;
    private String description;
    private Long parentId;
}
