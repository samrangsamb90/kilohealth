package com.spring.demo_project.controller;

import com.spring.demo_project.base.BaseController;
import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.BaseService;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.model.request.ProductRequest;
import com.spring.demo_project.model.request.ProductSkuRequest;
import com.spring.demo_project.service.ProductSkuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/productSkus")
public class ProductSkuController extends BaseController {
    private final ProductSkuService productSkuService;

    @PostMapping
    public ResponseEntity<StructureRS> create(@RequestBody ProductSkuRequest req){
        return response(productSkuService.create(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StructureRS> findById(@PathVariable Long id){
        return response(productSkuService.findById(id));
    }

    @GetMapping
    public ResponseEntity<StructureRS> findAll(BaseListingRQ req){
        return response(productSkuService.findAll(req));
    }

    @DeleteMapping("/{id}")
    public void softDelete(@PathVariable Long id){
        productSkuService.softDelete(id);
    }
}
