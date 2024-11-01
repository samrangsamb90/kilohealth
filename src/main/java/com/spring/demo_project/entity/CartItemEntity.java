package com.spring.demo_project.entity;

import com.spring.demo_project.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "cart_items")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CartItemEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    private Integer quantity;

    @ManyToMany
    @JoinTable(
            name = "cartItem_productSku",
            joinColumns = @JoinColumn(name = "cartItem_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "productSku_id",referencedColumnName = "id")
    )
    private Set<ProductSkuEntity> productSkus;

}
