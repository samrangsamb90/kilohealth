package com.spring.demo_project.mapper;

import com.spring.demo_project.entity.PermissionEntity;
import com.spring.demo_project.model.request.PermissionRequest;
import com.spring.demo_project.model.response.PermissionResponse;
import org.mapstruct.Mapper;

@Mapper
public interface PermissionMapper {

    PermissionResponse from(PermissionEntity permission);
    PermissionEntity to(PermissionRequest permission);
}
