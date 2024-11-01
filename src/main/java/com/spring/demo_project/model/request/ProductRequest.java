package com.spring.demo_project.model.request;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class ProductRequest {
    private String name;
    private String description;
    private String summary;
    private String cover;

    private Set<Long> subCategoryId;
}
