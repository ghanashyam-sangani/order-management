package com.ordermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanagement.entity.Vendor;
import com.ordermanagement.service.VendorService;

@RestController
@RequestMapping("/vendors")
public class VendorController {

	@Autowired
	private VendorService vendorService;

	@PostMapping("/add")
	public ResponseEntity<Vendor> addVendor(@RequestBody Vendor vendor) {
		return ResponseEntity.ok(vendorService.save(vendor));
	}

	@GetMapping("/list")
	public ResponseEntity<List<Vendor>> listVendors() {
		return ResponseEntity.ok(vendorService.findAll());
	}
}
