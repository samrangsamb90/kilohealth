package com.spring.demo_project.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartResponse {
    private Long id;
    private UserRS user;
    private BigDecimal total;
}
