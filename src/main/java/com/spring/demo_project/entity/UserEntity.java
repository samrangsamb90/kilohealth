package com.spring.demo_project.entity;

import com.spring.demo_project.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserEntity extends BaseEntity {
    private String profile;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private LocalDate dob;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<AddressEntity> addresses;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<WishListEntity> wishLists;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<CartEntity> carts;

    @OneToOne(mappedBy = "user")
    private OrderDetailsEntity orderDetails;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id")
    )
    private Set<RoleEntity> roles;
}
