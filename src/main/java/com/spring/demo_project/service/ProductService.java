package com.spring.demo_project.service;

import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.BaseService;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.entity.ProductEntity;
import com.spring.demo_project.entity.SubCategoryEntity;
import com.spring.demo_project.mapper.ProductMapper;
import com.spring.demo_project.model.request.ProductRequest;
import com.spring.demo_project.repository.ProductRepository;
import com.spring.demo_project.repository.SubCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService extends BaseService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final SubCategoryRepository subCategoryRepository;

    public StructureRS create(ProductRequest req){

        Set<SubCategoryEntity> subCategory = req.getSubCategoryId().stream().map(subCategroyId ->
                subCategoryRepository.findById(subCategroyId).orElseThrow(()->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST,"subCategory has not found"))).collect(Collectors.toSet());

        ProductEntity product = productMapper.toProduct(req);

        product.setSubCategories(subCategory);
        productRepository.save(product);
        return response(productMapper.fromProduct(product));
    }

    public StructureRS findById(Long id){
        ProductEntity product = productRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Product has bean not found"));

        return response(productMapper.fromProduct(product));
    }

    public StructureRS findAll(BaseListingRQ req){
        Page<ProductEntity> page = productRepository.findAll(req.getPageable());

        return response(page.map(productMapper::fromProduct),page);
    }

    public void softDelete(Long id){
        ProductEntity product = productRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Product has bean not found"));

        product.setDeletedDate(Instant.now());
        productRepository.save(product);
    }

    public StructureRS restore (Long id){
        ProductEntity product = productRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"product has not found"));

        product.setDeletedDate(null);
        product= productRepository.save(product);

        return response(productMapper.fromProduct(product));
    }

    public StructureRS update(@PathVariable Long id, ProductRequest req){
        ProductEntity product = productRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"product hs not found"));

        Set<SubCategoryEntity> subCategories = req.getSubCategoryId().stream().map(subId ->
                subCategoryRepository.findByIdAndDeletedDateNull(subId).orElseThrow(()->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST,"sub has not found"))).collect(Collectors.toSet());

        product.setName(req.getName());
        product.setDescription(req.getDescription());
        product.setSummary(req.getSummary());
        product.setSubCategories(subCategories);

        product =productRepository.save(product);

        return response(productMapper.fromProduct(product));
    }

}
