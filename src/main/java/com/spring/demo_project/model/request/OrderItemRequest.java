package com.spring.demo_project.model.request;

import lombok.Data;

import java.util.Set;

@Data
public class OrderItemRequest {
    private Long orderDetailId;
    private Long productId;
    private Set<Long> productSkuId;
    private Integer quantity;
}
