package com.ordermanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanagement.entity.Vendor;
import com.ordermanagement.repository.VendorRepository;
import com.ordermanagement.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorRepository vendorRepository;

	@Override
	public Vendor save(Vendor vendor) {
		return vendorRepository.save(vendor);
	}

	@Override
	public List<Vendor> findAll() {
		return vendorRepository.findAll();
	}

}
