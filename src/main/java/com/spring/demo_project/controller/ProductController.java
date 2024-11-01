package com.spring.demo_project.controller;

import com.spring.demo_project.base.BaseController;
import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.model.request.ProductRequest;
import com.spring.demo_project.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController extends BaseController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<StructureRS> create(@RequestBody ProductRequest req){
        return response(productService.create(req));
    }

    @GetMapping
    public ResponseEntity<StructureRS> findAll(BaseListingRQ req){
        return response(productService.findAll(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StructureRS> findById(@PathVariable Long id){
        return response(productService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void softDelete(@PathVariable Long id){
        productService.softDelete(id);
    }

    @PutMapping("/restore/{id}")
    public ResponseEntity<StructureRS> restore (@PathVariable Long id){
        return response(productService.restore(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StructureRS> update(@PathVariable Long id, ProductRequest req){
        return response(productService.update(id, req));
    }
}
