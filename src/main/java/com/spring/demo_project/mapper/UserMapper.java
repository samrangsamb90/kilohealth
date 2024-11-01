package com.spring.demo_project.mapper;

import com.spring.demo_project.entity.UserEntity;
import com.spring.demo_project.model.request.UserRequest;
import com.spring.demo_project.model.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserResponse fromUser(UserEntity user);
    UserEntity toUser(UserRequest user);
}
