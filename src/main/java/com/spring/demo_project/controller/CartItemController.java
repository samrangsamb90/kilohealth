package com.spring.demo_project.controller;

import com.spring.demo_project.base.BaseController;
import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.model.request.CartItemRequest;
import com.spring.demo_project.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/cartItems")
public class CartItemController extends BaseController {
    private final CartItemService cartItemService;

    @PostMapping
    public ResponseEntity<StructureRS> crate(@RequestBody CartItemRequest req){
        return response(cartItemService.create(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StructureRS> findById(@PathVariable Long id){
        return response(cartItemService.findById(id));
    }

    @GetMapping
    public ResponseEntity<StructureRS> findALl(BaseListingRQ req){
        return response(cartItemService.findAll(req));
    }

    @DeleteMapping("/{id}")
    public void softDelete(@PathVariable Long id){
        cartItemService.softDelete(id);
    }
}
