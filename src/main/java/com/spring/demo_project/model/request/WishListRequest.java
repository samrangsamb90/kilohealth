package com.spring.demo_project.model.request;

import lombok.Data;

@Data
public class WishListRequest {
    private Long userId;
    private Long productId;
}
