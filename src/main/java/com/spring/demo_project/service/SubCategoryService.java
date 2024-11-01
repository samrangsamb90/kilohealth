package com.spring.demo_project.service;

import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.BaseService;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.entity.CategoryEntity;
import com.spring.demo_project.entity.SubCategoryEntity;
import com.spring.demo_project.mapper.CategoryMapper;
import com.spring.demo_project.mapper.SubCategoryMapper;
import com.spring.demo_project.model.request.SubCategoryRequest;
import com.spring.demo_project.repository.CategoryRepository;
import com.spring.demo_project.repository.SubCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubCategoryService extends BaseService {
    private final SubCategoryRepository subCategoryRepository;
    private final SubCategoryMapper subCategoryMapper;
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public StructureRS create(SubCategoryRequest req){

        CategoryEntity category = categoryRepository.findByIdAndDeletedDateNull(req.getParentId()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.BAD_REQUEST,"category not found"));

        SubCategoryEntity subCategory = subCategoryMapper.toSubCategory(req);
        subCategory.setParent(category);
        subCategory= subCategoryRepository.save(subCategory);
        return response(subCategoryMapper.fromSubCategory(subCategory));
    }

    public StructureRS findAll(BaseListingRQ req){
        Page<SubCategoryEntity> page = subCategoryRepository.fetchAll(req.getQuery(), req.getPageable(req.getSort(),req.getOrder()));
        return response(page.stream().map(subCategoryMapper::fromSubCategory));
    }

    public StructureRS findById(Long id){
        SubCategoryEntity subCategory = subCategoryRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.BAD_REQUEST,"category not found"));
        return response(subCategoryMapper.fromSubCategory(subCategory));
    }

    public void softDelete(Long id){
        SubCategoryEntity subCategory = subCategoryRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"category not found"));
        subCategory.setDeletedDate(Instant.now());
        subCategoryRepository.save(subCategory);
    }

    public StructureRS restore(Long id){
        SubCategoryEntity subCategory = subCategoryRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"sub category has bean has found"));

        subCategory.setDeletedDate(null);
        subCategory =subCategoryRepository.save(subCategory);

        return response(subCategoryMapper.fromSubCategory(subCategory));
    }

    public StructureRS update (Long id, SubCategoryRequest req){
        SubCategoryEntity subCategory = subCategoryRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"sub categrory has ben not found"));

        Optional<CategoryEntity> category = categoryRepository.findByIdAndDeletedDateNull(req.getParentId());
        if (category.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"category has bean nnot found");
        }

        subCategory.setName(req.getName());
        subCategory.setDescription(req.getDescription());
        subCategory.setParent(category.get());
        subCategory =subCategoryRepository.save(subCategory);

        return response(subCategoryMapper.fromSubCategory(subCategory));
    }
}
