package com.spring.demo_project.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentResponse {
    private Long id;
    private OrderDetailRS orderDetail;
    private BigDecimal amount;
    private String status;
}
