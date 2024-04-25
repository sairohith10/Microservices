package com.springex.microservice.openfiegn;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springex.microservice.entity.AddressResponse;

//@FeignClient(value  = "address-service",url = "${address.service.url}", path="address")




@FeignClient(name="address-service",value="address-service",path="address")
public interface AddressFeignClient {
@GetMapping("/id/{id}")
public AddressResponse getDetailsById(@PathVariable("id") long id);
}
