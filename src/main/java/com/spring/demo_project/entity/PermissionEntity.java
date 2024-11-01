package com.spring.demo_project.entity;

import com.spring.demo_project.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "permission")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PermissionEntity extends BaseEntity {
    private String name;
    private String code;

    @ManyToMany(mappedBy = "permissions",fetch = FetchType.LAZY)
    private Set<RoleEntity> roles;
}
