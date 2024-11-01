package com.spring.demo_project.repository;

import com.spring.demo_project.entity.AddressEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    @Query("select a from AddressEntity a where a.id = ?1 and a.deletedDate is null")
    Optional<AddressEntity> findByIdAndDeletedDateNull(Long id);


    @Query("select a from AddressEntity a join fetch  a.user where a.deletedDate is null and (:query= 'All' or a.address like concat(' %' , :query , '%'))")
    Page<AddressEntity> fetchAll(String query, Pageable pageable);
}