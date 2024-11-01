package com.spring.demo_project.mapper;

import com.spring.demo_project.entity.ProductSkuEntity;
import com.spring.demo_project.model.request.ProductSkuRequest;
import com.spring.demo_project.model.response.ProductSkuResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductSkuMapper {

    @Mapping(target = "productAttributes",source = "productAttributes")
    ProductSkuResponse from(ProductSkuEntity productSKU);
    ProductSkuEntity to(ProductSkuRequest productSkuRequest);
}
