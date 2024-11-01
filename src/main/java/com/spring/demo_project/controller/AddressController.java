package com.spring.demo_project.controller;

import com.spring.demo_project.base.BaseController;
import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.model.request.AddressRequest;
import com.spring.demo_project.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/address")
@RequiredArgsConstructor
public class AddressController extends BaseController {
    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<StructureRS> create(@RequestBody AddressRequest address) {
        return ResponseEntity.ok(addressService.create(address));
    }

    @GetMapping
    public ResponseEntity<StructureRS> findAll(BaseListingRQ req) {
        return ResponseEntity.ok(addressService.findAll(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StructureRS> findById(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void softDelete(@PathVariable Long id) {
        addressService.softDelete(id);
    }

    @PutMapping("/restore/{id}")
    public ResponseEntity<StructureRS> restore(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.restore(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StructureRS> update(@PathVariable Long id, @RequestBody AddressRequest address) {
        return ResponseEntity.ok(addressService.update(id, address));
    }
}
