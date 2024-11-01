package com.spring.demo_project.service;

import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.BaseService;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.entity.RoleEntity;
import com.spring.demo_project.entity.UserEntity;
import com.spring.demo_project.mapper.UserMapper;
import com.spring.demo_project.model.request.UserRequest;
import com.spring.demo_project.repository.RoleRepository;
import com.spring.demo_project.repository.UserRepository;
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
public class UserService extends BaseService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    public StructureRS create(UserRequest req){

        Set<RoleEntity> roles =req.getRoleId().stream().map(roleId ->
                roleRepository.findById(roleId).orElseThrow(()->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST,"role has bean not found"))).collect(Collectors.toSet());

        UserEntity user = userMapper.toUser(req);

        user.setRoles(roles);
        user.setProfile("avatar.png");
        user = userRepository.save(user);
        return response(userMapper.fromUser(user));
    }

    public StructureRS findById(Long id){
        UserEntity user = userRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"user not bean found"));
        return response(userMapper.fromUser(user));
    }

    public StructureRS findAll(BaseListingRQ req){
        Page<UserEntity> page = userRepository.fetchAll(req.getQuery(),req.getPageable(req.getSort(),req.getOrder()));
        return response(page.stream().map(userMapper::fromUser),page);
    }

    public void softDelete(Long id ){
        UserEntity user = userRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"user not bean found"));

        user.setDeletedDate(Instant.now());
        userRepository.save(user);
    }

    public StructureRS restore(Long id){
        UserEntity user = userRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"user not bean found"));

        user.setDeletedDate(null);
        user =userRepository.save(user);
        return response(userMapper.fromUser(user));
    }

    public StructureRS update(Long id, UserRequest req){
        UserEntity user = userRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"user not bean found"));

        Set<RoleEntity> roles= req.getRoleId().stream().map(roleId ->
                roleRepository.findById(roleId).orElseThrow(()->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST,"role has bean not found"))).collect(Collectors.toSet());

        user.setFirstName(req.getFirstName());
        user.setLastName(req.getLastName());
        user.setUserName(req.getUserName());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        user.setPhoneNumber(req.getPhoneNumber());
        user.setDob(req.getDob());
        user.setRoles(roles);
        user = userRepository.save(user);

        return response(userMapper.fromUser(user));
    }
}
