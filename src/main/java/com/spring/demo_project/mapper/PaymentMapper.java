package com.spring.demo_project.mapper;

import com.spring.demo_project.entity.PaymentDetailsEntity;
import com.spring.demo_project.model.request.PaymentRequest;
import com.spring.demo_project.model.response.PaymentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PaymentMapper {
    @Mapping(target = "orderDetail",source = "orderDetail")
    PaymentResponse fromPayment(PaymentDetailsEntity paymentDetails);
    PaymentDetailsEntity toPayment(PaymentRequest paymentRequest);
}
