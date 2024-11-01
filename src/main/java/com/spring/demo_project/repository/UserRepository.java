package com.spring.demo_project.repository;

import com.spring.demo_project.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("select u from UserEntity u join fetch u.roles r left join fetch r.permissions where u.deletedDate is null and (:query = 'ALL' or u.userName like concat('%', :query, '%') )")
    Page<UserEntity> fetchAll(@Param("query") String query, Pageable pageable);

    @Query("select u from UserEntity u where u.id = ?1 and u.deletedDate is null")
    Optional<UserEntity> findByIdAndDeletedDateNull(Long id);

}
