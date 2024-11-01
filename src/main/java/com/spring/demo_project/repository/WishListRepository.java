package com.spring.demo_project.repository;

import com.spring.demo_project.entity.WishListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface WishListRepository extends JpaRepository<WishListEntity, Long> {

    @Query("select w from WishListEntity w where w.id = ?1 and w.deletedDate is null")
    Optional<WishListEntity> findByIdAndDeletedDateNull(Long id);
//
//   // @Query("select w from WishListEntity w join fetch w.product join fetch w.user where w.deletedDate is null and (:query = 'All' or w.product like %:query%)")
//    Page<WishListEntity> fetchAll(String query, Pageable pageable);
}