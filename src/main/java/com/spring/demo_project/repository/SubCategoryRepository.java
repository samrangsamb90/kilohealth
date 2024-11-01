package com.spring.demo_project.repository;

import com.spring.demo_project.entity.SubCategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity, Long> {

    @Query("select s from SubCategoryEntity s where s.id = ?1 and s.deletedDate is null")
    Optional<SubCategoryEntity> findByIdAndDeletedDateNull(Long id);

    @Query("select s from SubCategoryEntity s join fetch s.parent where s.deletedDate is null and (:query ='All' or s.name like concat('%', :query ,'%') )")
    Page<SubCategoryEntity> fetchAll(String query, Pageable pageable);
}