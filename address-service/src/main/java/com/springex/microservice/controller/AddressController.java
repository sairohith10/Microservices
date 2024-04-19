package com.springex.microservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springex.microservice.entity.Address;
import com.springex.microservice.model.AddressDetails;
import com.springex.microservice.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;

	@PostMapping("/savedetails")
	public Address saveAddressDetails(@RequestBody AddressDetails addressDetails ) {
		
		Address address = new Address();
		
		address.setCity(addressDetails.getCity());
		address.setStreet(addressDetails.getStreet());
		  
	return addressService.storeAddressDetails(address);
		
	
	}
	
	@GetMapping("/getdetails")
		public List<Address> getAllDetails() {
			
			return addressService.getallAddresses();
		}
	
	
	@GetMapping("id/{id}")
	 public Optional<Address> getDetailsById(@PathVariable long id) {
		return addressService.getAddressById(id);
	}
	
}
