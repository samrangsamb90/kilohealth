package com.spring.demo_project.service;

import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.BaseService;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.entity.AddressEntity;
import com.spring.demo_project.entity.UserEntity;
import com.spring.demo_project.mapper.AddressMapper;
import com.spring.demo_project.model.request.AddressRequest;
import com.spring.demo_project.repository.AddressRepository;
import com.spring.demo_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AddressService extends BaseService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final UserRepository userRepository;

    public StructureRS create (AddressRequest req){

        UserEntity user= userRepository.findByIdAndDeletedDateNull(req.getUserId()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"user has not found"));

        AddressEntity address = addressMapper.toAddress(req);

        address.setUser(user);
        address=addressRepository.save(address);
        return response(addressMapper.fromAddress(address));
    }

    public StructureRS findById(Long id){
        AddressEntity address = addressRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"address has not found"));

        return response(addressMapper.fromAddress(address));
    }

    public StructureRS findAll(BaseListingRQ req){
        Page<AddressEntity> page = addressRepository.fetchAll(req.getQuery(), req.getPageable(req.getSort(), req.getOrder()));

        return response(page.stream().map(addressMapper::fromAddress));
    }

    public void softDelete(Long id){
        AddressEntity address =addressRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"address has not found"));

        address.setDeletedDate(Instant.now());
        address=addressRepository.save(address);
    }

    public StructureRS restore(Long id){
        AddressEntity address = addressRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"address has not found"));

        address.setDeletedDate(null);
        address=addressRepository.save(address);
        return response(addressMapper.fromAddress(address));
    }

    public StructureRS update(Long id, AddressRequest req){
        AddressEntity address = addressRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"address has not found"));

        Optional<UserEntity> user = userRepository.findByIdAndDeletedDateNull(req.getUserId());
        if(user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user has not found");
        }

        address.setTitle(req.getTitle());
        address.setAddress(req.getAddress());
        address.setCity(req.getCity());
        address.setCountry(req.getCountry());
        address.setPhoneNumber(req.getPhoneNumber());
        address.setUser(user.get());
        address = addressRepository.save(address);

        return response(addressMapper.fromAddress(address));

    }
}
