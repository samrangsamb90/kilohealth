package com.spring.demo_project.model.response;

import com.spring.demo_project.entity.WishListEntity;
import lombok.Data;

@Data
public class WishListResponse {
    private Long id;
    private UserRS user;
    private ProductRS product;

}
