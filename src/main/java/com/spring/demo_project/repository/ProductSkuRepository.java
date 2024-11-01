package com.spring.demo_project.repository;

import com.spring.demo_project.entity.ProductSkuEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductSkuRepository extends JpaRepository<ProductSkuEntity, Long> {

    @Query("select p from ProductSkuEntity p where p.id = ?1 and p.deletedDate is null")
    Optional<ProductSkuEntity> findByIdAndDeletedDateNull(Long id);

    @Query("select p from ProductSkuEntity p join fetch p.productAttributes where p.deletedDate is null and (:query = 'All' or p.sku like %:query%)")
    Page<ProductSkuEntity> fetchAll(String query, Pageable pageable);

}