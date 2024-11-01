package com.spring.demo_project.mapper;

import com.spring.demo_project.entity.CartEntity;
import com.spring.demo_project.model.request.CartRequest;
import com.spring.demo_project.model.response.CartResponse;
import org.mapstruct.Mapper;

@Mapper
public interface CartMapper {

    CartResponse fromCart(CartEntity cart);
    CartEntity toCart(CartRequest cart);
}
