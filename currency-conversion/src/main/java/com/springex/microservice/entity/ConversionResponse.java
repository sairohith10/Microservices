package com.springex.microservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConversionResponse {

	 private String from;
     private String to;
     private double value;
     private double conversionRate;
     private double convertedValue;

	
}
