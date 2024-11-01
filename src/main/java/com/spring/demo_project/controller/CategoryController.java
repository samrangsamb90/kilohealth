package com.spring.demo_project.controller;

import com.spring.demo_project.base.BaseController;
import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.model.request.CategoryRequest;
import com.spring.demo_project.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class CategoryController extends BaseController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<StructureRS> create(@RequestBody CategoryRequest req){
        return response(categoryService.create(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StructureRS> findById(@PathVariable Long id){
        return response(categoryService.findById(id));
    }

    @GetMapping
    public ResponseEntity<StructureRS> findAll(BaseListingRQ req){
        return response(categoryService.findAll(req));
    }

    @PostMapping("/{id}")
    public ResponseEntity<StructureRS> update(@PathVariable Long id, @RequestBody CategoryRequest req){
        return response(categoryService.update(id, req));
    }

    @PutMapping("/restore/{id}")
    public ResponseEntity<StructureRS> restore(@PathVariable Long id){
        return response(categoryService.restore(id));
    }
    
    @DeleteMapping("/{id}")
    public void softDelete(@PathVariable Long id){
        categoryService.softDelete(id);
    }
}
