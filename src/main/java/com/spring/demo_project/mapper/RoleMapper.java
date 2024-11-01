package com.spring.demo_project.mapper;

import com.spring.demo_project.entity.RoleEntity;
import com.spring.demo_project.model.request.RoleRequest;
import com.spring.demo_project.model.response.RoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface RoleMapper {

    @Mapping(target = "permissions",source = "permissions")
    RoleResponse from(RoleEntity roleEntity);
    RoleEntity to(RoleRequest role);
}
