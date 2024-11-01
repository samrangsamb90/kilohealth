package com.spring.demo_project.controller;

import com.spring.demo_project.base.BaseController;
import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.model.request.ProductAttributeRequest;
import com.spring.demo_project.service.ProductAttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/productAttributes")
public class ProductAttributeController  extends BaseController {
    private final ProductAttributeService productAttributeService;

    @PostMapping
    public ResponseEntity<StructureRS> create (@RequestBody ProductAttributeRequest req){
        return response(productAttributeService.create(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StructureRS> findById(@PathVariable Long id){
        return response(productAttributeService.findById(id));
    }

    @GetMapping
    public ResponseEntity<StructureRS> findALl(BaseListingRQ req){
        return response(productAttributeService.findAll(req));
    }

    @DeleteMapping("/{id}")
    public void softDelete(@PathVariable Long id){
        productAttributeService.softDelete(id);
    }

    @PutMapping("/restore/{id}")
    public ResponseEntity<StructureRS> restore(@PathVariable Long id){
        return response(productAttributeService.restore(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StructureRS> update(@PathVariable Long id, @RequestBody ProductAttributeRequest req){
        return response(productAttributeService.update(id, req));
    }
}
