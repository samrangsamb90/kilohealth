package com.spring.demo_project.repository;

import com.spring.demo_project.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    @Query("select c from CategoryEntity c where c.id = ?1 and c.deletedDate is null")
    Optional<CategoryEntity> findByIdAndDeletedDateNull(Long id);

    @Query("SELECT c FROM CategoryEntity c WHERE c.deletedDate IS NULL AND (:query = 'All' OR c.name LIKE :query)")
    Page<CategoryEntity> fetchAll(@Param("query") String query, Pageable pageable);

}