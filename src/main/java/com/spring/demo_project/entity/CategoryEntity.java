package com.spring.demo_project.entity;

import com.spring.demo_project.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@Table(name = "categories")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CategoryEntity extends BaseEntity {
    private String name;
    private String description;

    @OneToMany(mappedBy = "parent")
    private List<SubCategoryEntity> subCategories;
}
