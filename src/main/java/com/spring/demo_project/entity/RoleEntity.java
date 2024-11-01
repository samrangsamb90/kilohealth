package com.spring.demo_project.entity;

import com.spring.demo_project.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RoleEntity extends BaseEntity {
    private String name;
    private String code;

    @ManyToMany(mappedBy ="roles",fetch = FetchType.LAZY)
    private List<UserEntity> users;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id",referencedColumnName = "id")
    )
    private Set<PermissionEntity> permissions;
}
