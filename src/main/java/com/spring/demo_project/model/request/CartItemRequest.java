package com.spring.demo_project.model.request;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class CartItemRequest {
    private Long cartId;
    private Long productId;
    private Set<Long> productSkuId;
    private Integer quantity;
}
