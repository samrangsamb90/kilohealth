package com.spring.demo_project.service;

import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.BaseService;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.entity.OrderDetailsEntity;
import com.spring.demo_project.entity.UserEntity;
import com.spring.demo_project.mapper.OrderDetailMapper;
import com.spring.demo_project.model.request.OrderDetailRequest;
import com.spring.demo_project.repository.OrderDetailsRepository;
import com.spring.demo_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class OrderDetailService extends BaseService {
    private final OrderDetailMapper orderDetailMapper;
    private final OrderDetailsRepository orderDetailsRepository;
    private final UserRepository userRepository;

    public StructureRS create(OrderDetailRequest req){
        UserEntity user = userRepository.findById(req.getUserId()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.BAD_REQUEST,"User Not Found"));

        double total =0.0;
        OrderDetailsEntity orderDetails = orderDetailMapper.toOrder(req);
        orderDetails.setUser(user);
        orderDetails= orderDetailsRepository.save(orderDetails);
        return response(orderDetailMapper.fromOrder(orderDetails));
    }

    public StructureRS findById(Long id){
        OrderDetailsEntity orderDetails = orderDetailsRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Order Not Found"));

        return response(orderDetailMapper.fromOrder(orderDetails));
    }

    public StructureRS findAll(BaseListingRQ req){
        Page<OrderDetailsEntity> page = orderDetailsRepository.findAll(req.getPageable());
        return response(page.stream().map(orderDetailMapper::fromOrder),page);
    }

    public void softDelete(Long id){
        OrderDetailsEntity orderDetails = orderDetailsRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Order Not Found"));

        orderDetails.setDeletedDate(Instant.now());
        orderDetailsRepository.save(orderDetails);
    }

    public StructureRS restore(Long id){
        OrderDetailsEntity orderDetails = orderDetailsRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.BAD_REQUEST,"order detail has not found"));

        orderDetails.setDeletedDate(null);
        orderDetails= orderDetailsRepository.save(orderDetails);
        return response(orderDetailMapper.fromOrder(orderDetails));
    }

    public StructureRS update (Long id ,OrderDetailRequest req){
        OrderDetailsEntity orderDetails = orderDetailsRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"order detail has not found"));

        UserEntity user = userRepository.save(userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST,"user has not found")));

        orderDetails.setUser(user);
        orderDetails = orderDetailsRepository.save(orderDetails);

        return response(orderDetailMapper.fromOrder(orderDetails));
    }
}
