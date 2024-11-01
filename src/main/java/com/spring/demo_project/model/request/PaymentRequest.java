package com.spring.demo_project.model.request;

import lombok.Data;

@Data
public class PaymentRequest {
    private Long orderId;
    private Boolean status;
}
