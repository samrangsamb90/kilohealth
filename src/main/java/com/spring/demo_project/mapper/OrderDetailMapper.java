package com.spring.demo_project.mapper;

import com.spring.demo_project.entity.OrderDetailsEntity;
import com.spring.demo_project.model.request.OrderDetailRequest;
import com.spring.demo_project.model.response.OrderDetailResponse;
import org.mapstruct.Mapper;

@Mapper
public interface OrderDetailMapper {

    //@Mapping(target = "user",source = "user")
    OrderDetailResponse fromOrder(OrderDetailsEntity order);
    OrderDetailsEntity toOrder(OrderDetailRequest order);
}
