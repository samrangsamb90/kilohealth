package com.spring.demo_project.mapper;

import com.spring.demo_project.entity.ProductEntity;
import com.spring.demo_project.model.request.ProductRequest;
import com.spring.demo_project.model.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductMapper {

    @Mapping(target = "subCategory",source = "subCategories")
    ProductResponse fromProduct(ProductEntity product);
    ProductEntity toProduct(ProductRequest product);
}
