package com.spring.demo_project.repository;

import com.spring.demo_project.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("select p from ProductEntity p where p.id = ?1 and p.deletedDate is null")
    Optional<ProductEntity> findByIdAndDeletedDateNull(Long id);

    @Query("select p from ProductEntity p join fetch p.subCategories where p.deletedDate is null and (:query ='All' or p.name like concat('%', :query , '%') )")
    Page<ProductEntity> fetchAll(String query, Pageable pageable);
}