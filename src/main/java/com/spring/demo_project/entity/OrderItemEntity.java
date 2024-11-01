package com.spring.demo_project.entity;

import com.spring.demo_project.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "order_item")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderItemEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderDetailsEntity orderDetail;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToMany
    @JoinTable(
            name = "order_productSku",
            joinColumns = @JoinColumn(name = "orderItem_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "productSku_id",referencedColumnName = "id")
    )
    private Set<ProductSkuEntity> productSkus;

    private Integer quantity;
}
