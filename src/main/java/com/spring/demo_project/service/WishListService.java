package com.spring.demo_project.service;

import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.BaseService;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.entity.ProductEntity;
import com.spring.demo_project.entity.SubCategoryEntity;
import com.spring.demo_project.entity.UserEntity;
import com.spring.demo_project.entity.WishListEntity;
import com.spring.demo_project.mapper.WishListMapper;
import com.spring.demo_project.model.request.WishListRequest;
import com.spring.demo_project.repository.ProductRepository;
import com.spring.demo_project.repository.SubCategoryRepository;
import com.spring.demo_project.repository.UserRepository;
import com.spring.demo_project.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WishListService extends BaseService {
    private final WishListRepository wishListRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    private final WishListMapper wishListMapper;
    private final SubCategoryRepository subCategoryRepository;

    public StructureRS create(WishListRequest req){
        UserEntity user = userRepository.findById(req.getUserId()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.BAD_REQUEST,"user has not found"));

        ProductEntity product = productRepository.findById(req.getProductId()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.BAD_REQUEST,"product has not found"));

        WishListEntity wishList = wishListMapper.toWish(req);
        wishList.setUser(user);
        wishList.setProduct(product);
        wishList= wishListRepository.save(wishList);
        return response(wishListMapper.fromWish(wishList));
    }

    public StructureRS findAll(BaseListingRQ req){
        Page<WishListEntity> wishList = wishListRepository.findAll(req.getPageable());
        return response(wishList.stream().map(wishListMapper::fromWish),wishList);
    }

    public StructureRS findById(Long id){
        WishListEntity wishList = wishListRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"wishList has not found"));

        return response(wishListMapper.fromWish(wishList));
    }

    public void softDelete(Long id){
        WishListEntity wishList = wishListRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"wishList has not found"));

        wishList.setDeletedDate(Instant.now());
        wishList = wishListRepository.save(wishList);
    }

    public StructureRS restore(Long id){
        WishListEntity wishList = wishListRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"wishList has not found"));

        wishList.setDeletedDate(null);
        wishList = wishListRepository.save(wishList);

        return response(wishListMapper.fromWish(wishList));
    }

    public StructureRS update (Long id, WishListRequest req){

        WishListEntity wishList =wishListRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"user has not found"));

        Optional<ProductEntity> product = productRepository.findByIdAndDeletedDateNull(req.getProductId());
        if (product.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"product has not found");
        }

        Optional<UserEntity> user =userRepository.findByIdAndDeletedDateNull(req.getUserId());
        if(user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"user has not found");
        }

        WishListEntity wishList1 = wishListMapper.toWish(req);
        wishList1.setProduct(product.get());
        wishList1.setUser(user.get());

        wishList1 =wishListRepository.save(wishList1);
        return response(wishListMapper.fromWish(wishList1));
    }
}
