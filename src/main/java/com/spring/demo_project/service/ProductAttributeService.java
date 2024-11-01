package com.spring.demo_project.service;

import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.BaseService;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.entity.ProductAttributesEntity;
import com.spring.demo_project.mapper.ProductAttributeMapper;
import com.spring.demo_project.model.request.ProductAttributeRequest;
import com.spring.demo_project.repository.ProductAttributesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ProductAttributeService extends BaseService {
    private final ProductAttributesRepository productAttributesRepository;
    private final ProductAttributeMapper productAttributeMapper;

    public StructureRS create (ProductAttributeRequest req){
        ProductAttributesEntity productAttributes = productAttributeMapper.to(req);

        productAttributesRepository.save(productAttributes);
        return response(productAttributeMapper.from(productAttributes));
    }

    public StructureRS findById(Long id){
        ProductAttributesEntity productAttributes = productAttributesRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"product attribute has not found"));
        return response(productAttributeMapper.from(productAttributes));
    }

    public StructureRS findAll(BaseListingRQ req){
        Page<ProductAttributesEntity> page = productAttributesRepository.fetchALl(req.getPageable(req.getSort(),req.getOrder()));
        return response(page.stream().map(productAttributeMapper::from),page);
    }

    public void softDelete(Long id){
        ProductAttributesEntity productAttributes = productAttributesRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"product attribute has not found"));

        productAttributes.setDeletedDate(Instant.now());
        productAttributes = productAttributesRepository.save(productAttributes);
    }

    public StructureRS restore (Long id){
        ProductAttributesEntity product= productAttributesRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"product attribute has not found"));

        product.setDeletedDate(null);
        product =productAttributesRepository.save(product);

        return response(productAttributeMapper.from(product));
    }

    public StructureRS update(Long id, ProductAttributeRequest req){
        ProductAttributesEntity product = productAttributesRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"product attribute has not found"));

        product.setType(req.getType());
        product.setValue(req.getValue());
        product= productAttributesRepository.save(product);

        return response(productAttributeMapper.from(product));
    }
}
