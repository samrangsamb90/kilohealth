package com.spring.demo_project.model.response;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private String summary;
    private String cover;

    private Set<SubCategoryRS> subCategory;
}
