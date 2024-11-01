package com.spring.demo_project.model.response;

import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
public class ProductSkuResponse {
    private Long id;
    private ProductRS product;
    private String sku;
    private BigDecimal price;
    private Integer quantity;
    private Set<ProductAttributeResponse> productAttributes;
}
