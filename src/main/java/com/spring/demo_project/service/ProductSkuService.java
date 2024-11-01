package com.spring.demo_project.service;

import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.BaseService;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.entity.ProductAttributesEntity;
import com.spring.demo_project.entity.ProductEntity;
import com.spring.demo_project.entity.ProductSkuEntity;
import com.spring.demo_project.mapper.ProductSkuMapper;
import com.spring.demo_project.model.request.ProductAttributeRequest;
import com.spring.demo_project.model.request.ProductSkuRequest;
import com.spring.demo_project.repository.ProductAttributesRepository;
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
public class ProductSkuService extends BaseService {
    private final ProductSkuRepository productSkuRepository;
    private final ProductAttributesRepository productAttributesRepository;
    private final ProductSkuMapper productSkuMapper;
    private final ProductRepository productRepository;

    public StructureRS create (ProductSkuRequest req){
        ProductEntity product = productRepository.findByIdAndDeletedDateNull(req.getProductId()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.BAD_REQUEST,"product ahs bean not found"));

        Set<ProductAttributesEntity> productAttribute = req.getProductAttributeId().stream().map(prodcut ->
                productAttributesRepository.findByIdAndDeletedDateNull(prodcut).orElseThrow(()->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST,"product attribute has bean not found"))).collect(Collectors.toSet());

        ProductSkuEntity productSku = productSkuMapper.to(req);
        productSku.setProduct(product);
        productSku.setProductAttributes(productAttribute);
        productSku =productSkuRepository.save(productSku);

        return response(productSkuMapper.from(productSku));
    }

    public StructureRS findAll(BaseListingRQ req){
        Page<ProductSkuEntity> page = productSkuRepository.fetchAll(req.getQuery(),req.getPageable(req.getSort(),req.getOrder()));
        return response(page.stream().map(productSkuMapper::from),page);
    }

    public StructureRS findById(Long id){
        ProductSkuEntity productSKU = productSkuRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"productSku has not found"));

        return response(productSkuMapper.from(productSKU));
    }

    public void softDelete(Long id){
        ProductSkuEntity productSku = productSkuRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"product sku has not found"));
        productSku.setDeletedDate(Instant.now());
        productSku = productSkuRepository.save(productSku);
    }

    public StructureRS restore(Long id){
        ProductSkuEntity productSku = productSkuRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"product sku has not found"));

        productSku.setDeletedDate(null);
        productSku = productSkuRepository.save(productSku);

        return response(productSkuMapper.from(productSku));
    }

    public StructureRS update(Long id , ProductAttributeRequest req){
        ProductSkuEntity productSku = productSkuRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"product sku has not found"));
        ;
        return null;
    }
}
