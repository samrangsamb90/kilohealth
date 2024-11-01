package com.spring.demo_project.service;

import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.BaseService;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.entity.PermissionEntity;
import com.spring.demo_project.mapper.PermissionMapper;
import com.spring.demo_project.model.request.PermissionRequest;
import com.spring.demo_project.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class PermissionService extends BaseService {
    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    public StructureRS create (PermissionRequest req){
        PermissionEntity permission = permissionMapper.to(req);
        permissionRepository.save(permission);

        return response(permissionMapper.from(permission));
    }

    public StructureRS finById(Long id){
        PermissionEntity permission = permissionRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"permission not found"));

        return response(permissionMapper.from(permission));
    }

    public StructureRS findALl(BaseListingRQ req){
        Page<PermissionEntity> permissions = permissionRepository.fetchAll(req.getQuery(),req.getPageable(req.getSort(),req.getOrder()));

        return response(permissions.stream().map(permissionMapper::from),permissions);
    }

    public StructureRS update(Long id, PermissionRequest req){
        PermissionEntity permission = permissionRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"permission not found"));

        permission.setName(req.getName());
        permission.setCode(req.getCode());
        permissionRepository.save(permission);
        return response(permissionMapper.from(permission));
    }

    public void softDelete(Long id){
        PermissionEntity permission =permissionRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"permission not found"));

        permission.setDeletedDate(Instant.now());
        permission = permissionRepository.save(permission);
    }

    public StructureRS restore(Long id){
        PermissionEntity permission =permissionRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"permission not found"));

        permission.setDeletedDate(null);
        permission = permissionRepository.save(permission);

        return response(permissionMapper.from(permission));
    }
}
