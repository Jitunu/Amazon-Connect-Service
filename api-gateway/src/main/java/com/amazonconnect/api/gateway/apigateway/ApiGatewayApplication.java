package com.amazonconnect.api.gateway.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


import java.util.ArrayList;

@EnableEurekaClient
@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}




//	@RestController
//	class CoolCarController {
//
//		private final CarClient carClient;
//
//		public CoolCarController(CarClient carClient) {
//			this.carClient = carClient;
//		}
//
//		private Collection<Car> fallback() {
//			return new ArrayList<>();
//		}
//
//		@GetMapping("/cool-cars")
//		@CrossOrigin
//		@HystrixCommand(fallbackMethod = "fallback")
//		public Collection<Car> goodCars() {
//			return "HELLO INITIAL PROJECT";
//		}
//	}

}
