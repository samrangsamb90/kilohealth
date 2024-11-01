package com.spring.demo_project.model.response;

import com.spring.demo_project.Enum.GroupType;
import lombok.Data;

@Data
public class ProductAttributeResponse {
    private Long id;
    private GroupType type;
    private String value;
}
