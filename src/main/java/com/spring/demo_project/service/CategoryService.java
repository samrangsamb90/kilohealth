package com.spring.demo_project.service;

import com.spring.demo_project.base.BaseListingRQ;
import com.spring.demo_project.base.BaseService;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.entity.CategoryEntity;
import com.spring.demo_project.mapper.CategoryMapper;
import com.spring.demo_project.model.request.CategoryRequest;
import com.spring.demo_project.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class CategoryService extends BaseService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public StructureRS create (CategoryRequest req){
        CategoryEntity category = categoryMapper.toCategory(req);
        categoryRepository.save(category);
        return response(categoryMapper.fromCategory(category));
    }

    public StructureRS findAll(BaseListingRQ req){
        Page<CategoryEntity> page = categoryRepository.fetchAll(req.getQuery(), req.getPageable(req.getSort(),req.getOrder()));
        return response(page.stream().map(categoryMapper::fromCategory),page);
    }

    public StructureRS findById(Long id){
        CategoryEntity category = categoryRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found"));
        return response(categoryMapper.fromCategory(category));
    }

    public void softDelete(Long id){
        CategoryEntity category = categoryRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found"));

        category.setDeletedDate(Instant.now());
    }

    public StructureRS restore(Long id){
        CategoryEntity category = categoryRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found"));

        category.setDeletedDate(null);
        category = categoryRepository.save(category);
        return response(categoryMapper.fromCategory(category));
    }

    public StructureRS update(Long id, CategoryRequest req){
        CategoryEntity category = categoryRepository.findByIdAndDeletedDateNull(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.BAD_REQUEST,"Category not found"));

        category.setName(req.getName());
        category.setDescription(req.getDescription());
        category = categoryRepository.save(category);

        return response(categoryMapper.fromCategory(category));
    }
}
