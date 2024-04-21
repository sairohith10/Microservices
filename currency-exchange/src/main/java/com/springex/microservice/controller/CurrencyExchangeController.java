package com.springex.microservice.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class CurrencyExchangeController {

	@GetMapping("/rate")
	public ResponseEntity<Double> getConversionRate(
	        @RequestParam String from,
	        @RequestParam String to
	) {
	    String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + from;

	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

	    if (responseEntity.getStatusCode() == HttpStatus.OK) {
	        try {
	            JSONObject responseJson = new JSONObject(responseEntity.getBody());
	            Double rate = responseJson.getJSONObject("rates").getDouble(to);
	            return ResponseEntity.ok(rate);
	        } catch (JSONException e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    } else {
	        return ResponseEntity.status(responseEntity.getStatusCode()).build();
	    }
	}
}