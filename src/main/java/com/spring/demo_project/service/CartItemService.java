package com.spring.demo_project.service;

import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.BaseService;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.entity.CartEntity;
import com.spring.demo_project.entity.CartItemEntity;
import com.spring.demo_project.entity.ProductEntity;
import com.spring.demo_project.entity.ProductSkuEntity;
import com.spring.demo_project.mapper.CartItemMapper;
import com.spring.demo_project.model.request.CartItemRequest;
import com.spring.demo_project.repository.CartItemRepository;
import com.spring.demo_project.repository.CartRepository;
import com.spring.demo_project.repository.ProductRepository;
import com.spring.demo_project.repository.ProductSkuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartItemService extends BaseService {
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final ProductSkuRepository productSkuRepository;
    private final CartItemMapper cartItemMapper;

    public StructureRS create (CartItemRequest req){
        CartEntity cart = cartRepository.findById(req.getCartId()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.BAD_REQUEST,"cart has bean not found"));

        ProductEntity product = productRepository.findById(req.getProductId()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.BAD_REQUEST,"product has bean not found"));

        Set<ProductSkuEntity> productSku = req.getProductSkuId().stream().map(productId ->
                productSkuRepository.findById(productId).orElseThrow(()->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST,"product sku has bean not found"))).collect(Collectors.toSet());

        CartItemEntity cartItem = cartItemMapper.to(req);
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setProductSkus(productSku);
        cartItem = cartItemRepository.save(cartItem);

        return response(cartItemMapper.from(cartItem));
    }

    public StructureRS findById(Long id){
        CartItemEntity cart = cartItemRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"cart item has bean not found"));
        return response(cartItemMapper.from(cart));
    }

    public StructureRS findAll(BaseListingRQ req){
        Page<CartItemEntity> page = cartItemRepository.findAll(req.getPageable());
        return response(page.stream().map(cartItemMapper::from),page);
    }

    public void softDelete(Long id){
        CartItemEntity cartItem = cartItemRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"cart item has not found"));

        cartItem.setDeletedDate(Instant.now());
        cartItemRepository.save(cartItem);
    }
}
