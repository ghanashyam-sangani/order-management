package com.ordermanagement.service;

import java.util.List;

import com.ordermanagement.entity.Vendor;

public interface VendorService {
	
	Vendor save(Vendor vendor);
	
	List<Vendor> findAll();
	
}
