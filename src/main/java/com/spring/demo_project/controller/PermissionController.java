package com.spring.demo_project.controller;

import com.spring.demo_project.base.BaseController;
import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.model.request.PermissionRequest;
import com.spring.demo_project.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.api.callback.BaseCallback;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/permissions")
public class PermissionController extends BaseController {
    private final PermissionService permissionService;

    @PostMapping
    public ResponseEntity<StructureRS> create(@RequestBody PermissionRequest req){
        return response(permissionService.create(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StructureRS> findAById(@PathVariable Long id){
        return response(permissionService.finById(id));
    }

    @GetMapping
    public ResponseEntity<StructureRS> findAll(BaseListingRQ req){
        return response(permissionService.findALl(req));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StructureRS> update(@PathVariable Long id, @RequestBody PermissionRequest req){
        return response(permissionService.update(id,req));
    }

    @PutMapping("/restore/{id}")
    public ResponseEntity<StructureRS> restore(@PathVariable Long id){
        return response(permissionService.restore(id));
    }

    @DeleteMapping("/{id}")
    public void softDelete(@PathVariable Long id){
        permissionService.softDelete(id);
    }
}
