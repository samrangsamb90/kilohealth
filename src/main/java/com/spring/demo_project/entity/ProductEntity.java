package com.spring.demo_project.entity;

import com.spring.demo_project.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "products")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductEntity extends BaseEntity {
    private String name;
    private String description;
    private String summary;
    private String cover;

    @ManyToMany
    @JoinTable(
            name = "sub_category_product",
            joinColumns = @JoinColumn(name = "product_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "subCategroy_id",referencedColumnName = "id")
    )
    private Set<SubCategoryEntity> subCategories;

    @OneToMany(mappedBy = "product")
    private List<WishListEntity> wishLists;

    @OneToMany(mappedBy = "product")
    private List<CartItemEntity> cetItems;

    @OneToMany(mappedBy = "product")
    private List<OrderItemEntity> orderItems;

    @OneToMany(mappedBy = "product")
    private List<ProductSkuEntity> productSKUs;
}
