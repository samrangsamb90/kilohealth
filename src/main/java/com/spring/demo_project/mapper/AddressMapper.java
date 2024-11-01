package com.spring.demo_project.mapper;

import com.spring.demo_project.entity.AddressEntity;
import com.spring.demo_project.model.request.AddressRequest;
import com.spring.demo_project.model.response.AddressResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

@Mapper
public interface AddressMapper {

    //@Mapping(target = "user",source = "user")
    AddressResponse fromAddress(AddressEntity address);
    AddressEntity toAddress(AddressRequest address);
}
