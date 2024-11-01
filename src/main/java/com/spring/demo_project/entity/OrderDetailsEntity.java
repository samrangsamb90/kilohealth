package com.spring.demo_project.entity;

import com.spring.demo_project.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "order_details")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderDetailsEntity extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToOne(mappedBy = "orderDetail")
    private PaymentDetailsEntity paymentDetail;
    private BigDecimal total;

    @OneToMany(mappedBy = "orderDetail")
    private List<OrderItemEntity> orderItems;
}
