package com.spring.demo_project.model.response;

import lombok.Data;

@Data
public class SubCategoryResponse {
    private Long id;
    private String name;
    private String description;
    private CategoryResponse category;
}
