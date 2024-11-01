package com.spring.demo_project.controller;

import com.spring.demo_project.base.BaseController;
import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.model.request.WishListRequest;
import com.spring.demo_project.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/wishLists")
@RequiredArgsConstructor
public class WishListController extends BaseController {
    private final WishListService wishListService;

    @PostMapping
    public ResponseEntity<StructureRS> create(@RequestBody WishListRequest req){
        return response(wishListService.create(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StructureRS> findById(@PathVariable Long id){
        return response(wishListService.findById(id));
    }

    @GetMapping
    public ResponseEntity<StructureRS> findAll(BaseListingRQ req){
        return response(wishListService.findAll(req));
    }

    @DeleteMapping("/{id}")
    public void softDelete(@PathVariable Long id){
        wishListService.softDelete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StructureRS> update(Long id, WishListRequest req){
        return response(wishListService.update(id,req));
    }

    @PutMapping("/restore/{id}")
    public ResponseEntity<StructureRS> restore(@PathVariable Long id){
        return response(wishListService.restore(id));
    }
}
