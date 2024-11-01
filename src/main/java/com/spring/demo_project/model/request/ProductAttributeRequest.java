package com.spring.demo_project.model.request;

import com.spring.demo_project.Enum.GroupType;
import lombok.Data;

@Data
public class ProductAttributeRequest {
    private GroupType type;
    private String value;
}
