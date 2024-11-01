package com.spring.demo_project.repository;

import com.spring.demo_project.entity.ProductAttributesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductAttributesRepository extends JpaRepository<ProductAttributesEntity, Long> {

    @Query("select p from ProductAttributesEntity p where p.id = ?1 and p.deletedDate is null")
    Optional<ProductAttributesEntity> findByIdAndDeletedDateNull(Long id);

    @Query("select p from ProductAttributesEntity p where p.deletedDate is null")
    Page<ProductAttributesEntity> fetchALl(Pageable pageable);
}