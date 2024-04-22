package com.springex.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springex.microservice.entity.ConversionResponse;
import com.springex.microservice.fiegnclient.CurrencyExchangeService;
@RestController
public class CurrencyConversionController {
	@Autowired
    CurrencyExchangeService currencyExchangeService;

    @GetMapping("/convert")
    public ConversionResponse convertCurrency(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double value
    ) {
    	ResponseEntity<Double> responseEntity = currencyExchangeService.getConversionRate(from.toUpperCase(), to.toUpperCase());
    	if (responseEntity.getStatusCode().is2xxSuccessful()) {
    	    double conversionRate = responseEntity.getBody();
    	    double conversionValue = value * conversionRate;
    	    return new ConversionResponse(from.toUpperCase(), to.toUpperCase(), value, conversionRate, conversionValue);
    	} else {
    	    // Handle error response
    	    throw new RuntimeException("Failed to get conversion rate. Status code: " + responseEntity.getStatusCodeValue());
    	}
    }
}
