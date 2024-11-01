package com.spring.demo_project.mapper;

import com.spring.demo_project.entity.CategoryEntity;
import com.spring.demo_project.model.request.CategoryRequest;
import com.spring.demo_project.model.response.CategoryResponse;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {
    CategoryResponse fromCategory(CategoryEntity category);
    CategoryEntity toCategory(CategoryRequest category);
}
