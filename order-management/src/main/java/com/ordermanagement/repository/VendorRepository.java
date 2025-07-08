package com.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordermanagement.entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
