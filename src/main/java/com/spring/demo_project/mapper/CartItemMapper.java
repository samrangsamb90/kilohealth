package com.spring.demo_project.mapper;

import com.spring.demo_project.entity.CartItemEntity;
import com.spring.demo_project.model.request.CartItemRequest;
import com.spring.demo_project.model.response.CartItemResponse;
import org.mapstruct.Mapper;

@Mapper
public interface CartItemMapper {
    
    CartItemResponse from(CartItemEntity cartItem);
    CartItemEntity to(CartItemRequest cartItemRequest);
}
