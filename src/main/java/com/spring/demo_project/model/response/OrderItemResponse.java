package com.spring.demo_project.model.response;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class OrderItemResponse {
    private Long id;
    private OrderDetailResponse orderDetail;
    private ProductResponse product;
    private Set<ProductSkuResponse> productSkus;
    private Integer quantity;
}
