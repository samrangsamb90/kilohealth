package com.spring.demo_project.service;

import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.BaseService;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.entity.OrderDetailsEntity;
import com.spring.demo_project.entity.OrderItemEntity;
import com.spring.demo_project.entity.ProductEntity;
import com.spring.demo_project.entity.ProductSkuEntity;
import com.spring.demo_project.mapper.OrderItemMapper;
import com.spring.demo_project.model.request.OrderItemRequest;
import com.spring.demo_project.repository.OrderDetailsRepository;
import com.spring.demo_project.repository.OrderItemRepository;
import com.spring.demo_project.repository.ProductRepository;
import com.spring.demo_project.repository.ProductSkuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderItemService extends BaseService {
    private final OrderItemRepository orderItemRepository;
    private final OrderDetailsRepository orderDetailsRepository;
    private final ProductRepository productRepository;
    private final ProductSkuRepository productSkuRepository;

    private final OrderItemMapper orderItemMapper;

    public StructureRS create(OrderItemRequest req) {

        Optional<OrderDetailsEntity> orderDetails = orderDetailsRepository.findById(req.getOrderDetailId());
        if (orderDetails.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "orderDetails not found");
        }

        Optional<ProductEntity> product = productRepository.findByIdAndDeletedDateNull(req.getProductId());
        if (product.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "product not found");
        }

        Set<ProductSkuEntity> productSkus = req.getProductSkuId().stream().map(productId ->
                productSkuRepository.findByIdAndDeletedDateNull(productId).orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST))).collect(Collectors.toSet());

        OrderItemEntity orderItem = orderItemMapper.to(req);
        orderItem.setOrderDetail(orderDetails.get());
        orderItem.setProduct(product.get());
        orderItem.setProductSkus(productSkus);

        orderItem = orderItemRepository.save(orderItem);

        return response(orderItemMapper.from(orderItem));
    }

    public StructureRS findById(Long id) {
        OrderItemEntity orderItem = orderItemRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "orderItem not found"));

        return response(orderItemMapper.from(orderItem));
    }

    public StructureRS findAll(BaseListingRQ req) {
        Page<OrderItemEntity> orderItem = orderItemRepository.findAll(req.getPageable());

        return response(orderItem.stream().map(orderItemMapper::from),orderItem);
    }

    public StructureRS softDelete(Long id){
        OrderItemEntity orderItem = orderItemRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"order detail has not found"));

        orderItem.setDeletedDate(Instant.now());
        orderItem = orderItemRepository.save(orderItem);

        return response(orderItemMapper.from(orderItem));
    }

    public StructureRS restore(Long id){
        OrderItemEntity orderItem = orderItemRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"order item has not found"));

        orderItem.setDeletedDate(null);
        orderItem =orderItemRepository.save(orderItem);

        return response(orderItemMapper.from(orderItem));
    }

    public StructureRS update (Long id, OrderItemRequest req){
        OrderItemEntity orderItem = orderItemRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"order item has not found"));

        ProductEntity product = productRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.BAD_REQUEST,"product has not found"));

        Set<ProductSkuEntity> productSku = req.getProductSkuId().stream().map(productId ->
                productSkuRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST,"product sku has not found"))).collect(Collectors.toSet());

        OrderItemEntity orderItem1 = orderItemMapper.to(req);
        orderItem1.setProduct(product);
        orderItem1.setProductSkus(productSku);
        orderItem1 = orderItemRepository.save(orderItem1);
        return response(orderItemMapper.from(orderItem1));
    }
}
