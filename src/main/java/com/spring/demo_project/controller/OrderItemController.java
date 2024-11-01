package com.spring.demo_project.controller;

import com.spring.demo_project.base.BaseController;
import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.model.request.OrderItemRequest;
import com.spring.demo_project.model.response.OrderItemResponse;
import com.spring.demo_project.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/orderItems")
public class OrderItemController extends BaseController {
    private final OrderItemService orderItemService;

    @PostMapping
    public ResponseEntity<StructureRS> create (@RequestBody OrderItemRequest req){
        return response(orderItemService.create(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StructureRS> findById (@PathVariable Long id){
        return response(orderItemService.findById(id));
    }

    @GetMapping
    public ResponseEntity<StructureRS> findAll(BaseListingRQ req){
        return response(orderItemService.findAll(req));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StructureRS> update (@PathVariable Long id, OrderItemRequest req){
        return response(orderItemService.update(id, req));
    }

    @DeleteMapping("/{id}")
    public void softDelete (@PathVariable Long id){
        orderItemService.softDelete(id);
    }

    @PutMapping("/restore/{id}")
    public ResponseEntity<StructureRS> restore (@PathVariable Long id){
        return response(orderItemService.restore(id));
    }
}
