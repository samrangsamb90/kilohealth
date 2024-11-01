package com.spring.demo_project.controller;

import com.spring.demo_project.base.BaseController;
import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.model.request.PaymentRequest;
import com.spring.demo_project.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/payments")
public class PaymentController extends BaseController {
    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<StructureRS> create (@RequestBody PaymentRequest req){
        return response(paymentService.create(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StructureRS> findById(@PathVariable Long id){
        return response(paymentService.findById(id));
    }

    @GetMapping
    public ResponseEntity<StructureRS> findAll(BaseListingRQ req){
        return response(paymentService.findALl(req));
    }

    @DeleteMapping("/{id}")
    public void softDelete(@PathVariable Long id){
        paymentService.softDelete(id);
    }

}
