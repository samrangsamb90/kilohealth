package com.spring.demo_project.entity;

import com.spring.demo_project.Enum.GroupType;
import com.spring.demo_project.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "product_attributes")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductAttributesEntity extends BaseEntity {
    private GroupType type;
    private String value;

    @ManyToMany
    @JoinTable(
            name = "productSku_attribute",
            joinColumns = @JoinColumn(name = "productAttribute_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "productSku_id",referencedColumnName = "id")
    )
    private Set<ProductSkuEntity> productSkus;
}
