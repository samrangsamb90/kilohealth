package com.spring.demo_project.controller;

import com.spring.demo_project.base.BaseController;
import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.model.request.RoleRequest;
import com.spring.demo_project.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/roles")
public class RoleController extends BaseController {
    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<StructureRS> create(@RequestBody RoleRequest req){
        return response(roleService.create(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StructureRS> findById(@PathVariable Long id){
        return response(roleService.findById(id));
    }

    @GetMapping
    public ResponseEntity<StructureRS> findAll(BaseListingRQ req){
        return response(roleService.findALl(req));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StructureRS> update(@PathVariable Long id,RoleRequest req){
        return response(roleService.update(id,req));
    }

    @PutMapping("/restore/{id}")
    public ResponseEntity<StructureRS> redtore(@PathVariable Long id){
        return response(roleService.restore(id));
    }

    @DeleteMapping("/{id}")
    public void softDelete(@PathVariable Long id){
        roleService.softDelete(id);
    }
}
