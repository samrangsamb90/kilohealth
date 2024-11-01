package com.spring.demo_project.entity;

import com.spring.demo_project.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "payment_details")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PaymentDetailsEntity extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "orderDetail_id")
    private OrderDetailsEntity orderDetail;

    private BigDecimal amount;
    private String provider;
    private Boolean status;
}
