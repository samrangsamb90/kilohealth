package com.spring.demo_project.controller;

import com.spring.demo_project.base.BaseController;
import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.model.request.CartRequest;
import com.spring.demo_project.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/carts")
public class CartController extends BaseController {
    private final CartService cartService;

    @PostMapping
    public ResponseEntity<StructureRS> create(@RequestBody CartRequest cart) {
        return response(cartService.create(cart));
    }

    @GetMapping
    public ResponseEntity<StructureRS> findALl(BaseListingRQ req){
        return response(cartService.findAll(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StructureRS> findById(@PathVariable Long id){
        return response(cartService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void softDelete(@PathVariable Long id){
        cartService.softDelete(id);
    }
}
