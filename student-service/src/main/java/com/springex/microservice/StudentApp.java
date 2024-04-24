package com.springex.microservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class StudentApp {

	public static void main(String[] args) {
		SpringApplication.run(StudentApp.class, args);
	}

//    @Bean
//    RestTemplate restTemplate() {
//    	  return new RestTemplate();
//      }
//   
//	@Value("${address.service.url}")
//	private String addresserviceurl;
//	@Bean
//	public WebClient webClient() {
//		WebClient webClient =WebClient
//				             .builder()
//				             .baseUrl(addresserviceurl)
//				             .build();
//		return webClient;
//				
//	}
	
	
}
