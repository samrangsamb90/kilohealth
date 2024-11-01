package com.spring.demo_project.model.response;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class CartItemResponse {
    private Long id;
    private CartResponse cart;
    private ProductRS product;
    private Set<ProductSkuResponse> productSkus;
    private Integer quantity;
}
