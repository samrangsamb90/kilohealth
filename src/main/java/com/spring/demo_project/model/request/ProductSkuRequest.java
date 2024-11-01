package com.spring.demo_project.model.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
public class ProductSkuRequest {
    private Long productId;
    private String sku;
    private BigDecimal price;
    private Integer quantity;
    private Set<Long> productAttributeId;
}
