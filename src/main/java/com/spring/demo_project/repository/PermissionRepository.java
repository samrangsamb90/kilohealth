package com.spring.demo_project.repository;

import com.spring.demo_project.entity.PermissionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {

    @Query("select p from PermissionEntity p where p.deletedDate is null and(:query = 'All' or p.name like %:query%)")
    Page<PermissionEntity> fetchAll(@Param("query") String query, Pageable pageable);

    @Query("select p from PermissionEntity p where p.id = ?1 and p.deletedDate is null")
    Optional<PermissionEntity> findByIdAndDeletedDateNull(Long id);
}