package com.spring.demo_project.service;

import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.BaseService;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.entity.OrderDetailsEntity;
import com.spring.demo_project.entity.PaymentDetailsEntity;
import com.spring.demo_project.mapper.PaymentMapper;
import com.spring.demo_project.model.request.PaymentRequest;
import com.spring.demo_project.repository.OrderDetailsRepository;
import com.spring.demo_project.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class PaymentService extends BaseService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final OrderDetailsRepository orderDetailsRepository;

    public StructureRS create(PaymentRequest req){

        OrderDetailsEntity orderDetails = orderDetailsRepository.findById(req.getOrderId()).orElseThrow(()->
        new ResponseStatusException(HttpStatus.BAD_REQUEST,"order has not found"));

        PaymentDetailsEntity paymentDetails = paymentMapper.toPayment(req);
        paymentDetails.setStatus(true);
        paymentDetails.setOrderDetail(orderDetails);
        paymentDetails = paymentRepository.save(paymentDetails);

        return response(paymentMapper.fromPayment(paymentDetails));
    }

    public StructureRS findById (Long id){
        PaymentDetailsEntity paymentDetails = paymentRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"order detail has not found"));

        return response(paymentMapper.fromPayment(paymentDetails));
    }

    public StructureRS findALl(BaseListingRQ req){
        Page<PaymentDetailsEntity> page = paymentRepository.findAll(req.getPageable());

        return response(page.stream().map(paymentMapper::fromPayment),page);
    }

    public void softDelete(Long id){
        PaymentDetailsEntity paymentDetails = paymentRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"payment has not found"));

        paymentDetails.setDeletedDate(Instant.now());
        paymentDetails = paymentRepository.save(paymentDetails);
    }
}
