package com.spring.demo_project.repository;

import com.spring.demo_project.entity.RoleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    @Query("select r from RoleEntity r join fetch r.permissions where r.deletedDate is null and (:query = 'All' or r.name like %:query%)")
    Page<RoleEntity> fetchAll(String query, Pageable pageable);

    @Query("select r from RoleEntity r where r.id = ?1 and r.deletedDate is null")
    Optional<RoleEntity> findByIdAndDeletedDateNull(Long id);
}