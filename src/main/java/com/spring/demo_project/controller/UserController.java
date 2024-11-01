package com.spring.demo_project.controller;

import com.spring.demo_project.base.BaseController;
import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.model.request.UserRequest;
import com.spring.demo_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController extends BaseController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<StructureRS> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping
    public ResponseEntity<StructureRS> findAll(BaseListingRQ req) {
        return ResponseEntity.ok(userService.findAll(req));
    }

    @PostMapping
    public ResponseEntity<StructureRS> create(@RequestBody UserRequest req){
        return ResponseEntity.ok(userService.create(req));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.softDelete(id);
    }

    @PutMapping("/restore/{id}")
    public ResponseEntity<StructureRS> restore(@PathVariable Long id){
        return ResponseEntity.ok(userService.restore(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StructureRS> update(@PathVariable Long id, @RequestBody UserRequest req){
        return ResponseEntity.ok(userService.update(id, req));
    }
}
