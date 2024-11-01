package com.spring.demo_project.entity;

import com.spring.demo_project.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.catalina.User;

import java.util.List;

@Entity
@Data
@Table(name = "carts")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CartEntity extends BaseEntity {
    private Double total;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "cart")
    private List<CartItemEntity> cartItems;
}
