package com.springex.microservice.fiegnclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "currency-exchange", url = "http://localhost:8002")
public interface CurrencyExchangeService {

    @GetMapping("/rate")
    ResponseEntity<Double> getConversionRate(@RequestParam("from") String from, @RequestParam("to") String to);
}
