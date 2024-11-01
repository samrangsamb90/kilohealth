package com.spring.demo_project.controller;

import com.spring.demo_project.base.BaseController;
import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.model.request.SubCategoryRequest;
import com.spring.demo_project.service.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/subCategories")
public class SubCategoryController extends BaseController {
    private final SubCategoryService subCategoryService;

    @PostMapping
    public ResponseEntity<StructureRS> create(@RequestBody SubCategoryRequest req){
        return response(subCategoryService.create(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StructureRS> findById(@PathVariable Long id){
        return response(subCategoryService.findById(id));
    }

    @GetMapping
    public ResponseEntity<StructureRS> findAll(BaseListingRQ req){
        return response(subCategoryService.findAll(req));
    }

    @DeleteMapping("/{id}")
    public void softDelete(@PathVariable Long id){
        subCategoryService.softDelete(id);
    }

    @PutMapping("/restore/{id}")
    public ResponseEntity<StructureRS> restore(@PathVariable Long id){
        return response(subCategoryService.restore(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<StructureRS> update(@PathVariable Long id,SubCategoryRequest req){
        return response(subCategoryService.update(id,req));
    }
}
