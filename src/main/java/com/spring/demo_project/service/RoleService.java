package com.spring.demo_project.service;

import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.BaseService;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.entity.PermissionEntity;
import com.spring.demo_project.entity.RoleEntity;
import com.spring.demo_project.mapper.RoleMapper;
import com.spring.demo_project.model.request.RoleRequest;
import com.spring.demo_project.repository.PermissionRepository;
import com.spring.demo_project.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService extends BaseService {
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    private final RoleMapper roleMapper;

    public StructureRS create (RoleRequest req) {
        Set<PermissionEntity> permissions = req.getPermissionId().stream().map(permissionId ->
                permissionRepository.findById(permissionId).orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST, "permission has bean not found"))).collect(Collectors.toSet());

        RoleEntity role = roleMapper.to(req);
        role.setPermissions(permissions);
        role = roleRepository.save(role);
        return response(roleMapper.from(role));
    }

    public StructureRS findById(Long id){
        RoleEntity role = roleRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "role has bean not found"));

        return response(roleMapper.from(role));
    }

    public StructureRS findALl(BaseListingRQ req){
        Page<RoleEntity> page  = roleRepository.fetchAll(req.getQuery(),req.getPageable(req.getSort(),req.getOrder()));

        return response(page.stream().map(roleMapper::from),page);
    }

    public StructureRS update(Long id, RoleRequest req){
        RoleEntity role = roleRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "role has bean not found"));

        Set<PermissionEntity> permissions = req.getPermissionId().stream().map(permissionId ->
                permissionRepository.findById(permissionId).orElseThrow(()->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST, "permission has bean not found"))).collect(Collectors.toSet());

        RoleEntity roleEntity = roleMapper.to(req);

        roleEntity.setPermissions(permissions);
        roleEntity = roleRepository.save(roleEntity);
        return response(roleMapper.from(roleEntity));
    }

    public void softDelete(Long id){
        RoleEntity role = roleRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "role has bean not found"));

        role.setDeletedDate(Instant.now());
        role = roleRepository.save(role);
    }

    public StructureRS restore(Long id){
        RoleEntity role = roleRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "role has bean not found"));



        role.setDeletedDate(null);
        role = roleRepository.save(role);

        return response(roleMapper.from(role));
    }
}
