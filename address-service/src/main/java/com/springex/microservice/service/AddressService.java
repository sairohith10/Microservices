package com.springex.microservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springex.microservice.entity.Address;
import com.springex.microservice.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	public Address storeAddressDetails(Address address) {

		Address addresssaved = new Address();
		addresssaved = addressRepository.save(address);

		return addresssaved;
	}

	public List<Address> getallAddresses() {
		return addressRepository.findAll();
	}

	public Optional<Address> getAddressById(long id) {
		Optional<Address> addressfound ;
		addressfound = addressRepository.findById(id);

		return addressfound;
	}
}
