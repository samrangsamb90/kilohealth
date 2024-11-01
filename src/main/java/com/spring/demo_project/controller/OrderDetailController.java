package com.spring.demo_project.controller;

import com.spring.demo_project.base.BaseController;
import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.model.request.OrderDetailRequest;
import com.spring.demo_project.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/orderDetails")
public class OrderDetailController extends BaseController {
    private final OrderDetailService orderDetailService;

    @PostMapping
    public ResponseEntity<StructureRS> create(@RequestBody OrderDetailRequest req) {
        return response(orderDetailService.create(req));
    }

    @GetMapping
    public ResponseEntity<StructureRS> findAll(BaseListingRQ req) {
        return response(orderDetailService.findAll(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StructureRS> findById(@PathVariable Long id) {
        return response(orderDetailService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void softDelete(@PathVariable Long id) {
        orderDetailService.softDelete(id);
    }

    @PutMapping("/restore/{id}")
    public ResponseEntity<StructureRS> restore(@PathVariable Long id){
        return response(orderDetailService.restore(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StructureRS> update(@PathVariable Long id, @RequestBody OrderDetailRequest req){
        return response(orderDetailService.update(id,req));
    }
}
