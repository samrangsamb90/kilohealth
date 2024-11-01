package com.spring.demo_project.entity;

import com.spring.demo_project.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@Table(name = "sub_categories")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SubCategoryEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private CategoryEntity parent;

    private String name;
    private String description;

    @ManyToMany(mappedBy = "subCategories")
    private List<ProductEntity> products;
}
