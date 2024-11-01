package com.spring.demo_project.mapper;

import com.spring.demo_project.entity.OrderItemEntity;
import com.spring.demo_project.model.request.OrderItemRequest;
import com.spring.demo_project.model.response.OrderItemResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OrderItemMapper {


    OrderItemResponse from(OrderItemEntity orderItem);
    OrderItemEntity to (OrderItemRequest orderItemRequest);
}
