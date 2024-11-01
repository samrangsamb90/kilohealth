package com.spring.demo_project.mapper;

import com.spring.demo_project.entity.ProductAttributesEntity;
import com.spring.demo_project.model.request.ProductAttributeRequest;
import com.spring.demo_project.model.response.ProductAttributeResponse;
import org.mapstruct.Mapper;

@Mapper
public interface ProductAttributeMapper {
    ProductAttributeResponse from(ProductAttributesEntity productAttributes);
    ProductAttributesEntity to(ProductAttributeRequest productAttributeRequest);
}
