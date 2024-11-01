package com.spring.demo_project.entity;

import com.spring.demo_project.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "products_skus")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductSkuEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    private String sku;
    private Integer quantity;
    private BigDecimal price;

    @ManyToMany(mappedBy = "productSkus")
    private Set<OrderItemEntity> orderItems;

    @ManyToMany(mappedBy = "productSkus")
    private Set<CartItemEntity> cartItems;

    @ManyToMany(mappedBy = "productSkus")
    private Set<ProductAttributesEntity> productAttributes;
}
