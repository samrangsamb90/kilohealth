package com.spring.demo_project.entity;

import com.spring.demo_project.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "address")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AddressEntity extends BaseEntity {
    private String title;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private String landmark;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
