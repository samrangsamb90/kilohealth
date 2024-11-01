package com.spring.demo_project.mapper;

import com.spring.demo_project.entity.WishListEntity;
import com.spring.demo_project.model.request.WishListRequest;
import com.spring.demo_project.model.response.WishListResponse;
import org.mapstruct.Mapper;

@Mapper
public interface WishListMapper {
    WishListResponse fromWish(WishListEntity wishList);
    WishListEntity toWish(WishListRequest wishList);
}
