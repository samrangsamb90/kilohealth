package com.spring.demo_project.service;

import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.BaseService;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.entity.CartEntity;
import com.spring.demo_project.entity.UserEntity;
import com.spring.demo_project.mapper.CartMapper;
import com.spring.demo_project.model.request.CartRequest;
import com.spring.demo_project.repository.CartRepository;
import com.spring.demo_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class CartService extends BaseService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    private final CartMapper cartMapper;

    public StructureRS create (CartRequest req){
        UserEntity user = userRepository.findById(req.getUserId()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.BAD_REQUEST,"user has not beam found"));

        CartEntity cart = cartMapper.toCart(req);

        cart.setUser(user);
        cart= cartRepository.save(cart);
        return response(cartMapper.fromCart(cart));
    }

    public StructureRS findById (Long id){
        CartEntity cart = cartRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"cart not found"));

        return response(cartMapper.fromCart(cart));
    }

    public StructureRS findAll(BaseListingRQ req){
        Page<CartEntity> cart = cartRepository.findAll(req.getPageable());
        return response(cart.stream().map(cartMapper::fromCart),cart);
    }

    public void softDelete(Long id){
        CartEntity cart = cartRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"cart not found"));
        cart.setDeletedDate(Instant.now());
        cartRepository.save(cart);
    }
}
