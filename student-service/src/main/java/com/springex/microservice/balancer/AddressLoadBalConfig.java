package com.springex.microservice.balancer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import feign.Feign;

@LoadBalancerClient(value = "add")
public class AddressLoadBalConfig {
          
	
	@LoadBalanced
	@Bean
	public Feign.Builder feignBuilder(){
		return Feign.builder();
	}
}
