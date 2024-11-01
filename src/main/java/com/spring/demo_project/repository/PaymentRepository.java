package com.spring.demo_project.repository;

import com.spring.demo_project.entity.PaymentDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentDetailsEntity, Long> {
}