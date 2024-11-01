package com.spring.demo_project.mapper;

import com.spring.demo_project.entity.SubCategoryEntity;
import com.spring.demo_project.model.request.SubCategoryRequest;
import com.spring.demo_project.model.response.SubCategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SubCategoryMapper {
    @Mapping(target = "category",source = "parent")
    SubCategoryResponse fromSubCategory(SubCategoryEntity subCategory);
    SubCategoryEntity toSubCategory(SubCategoryRequest subCategory);
}
