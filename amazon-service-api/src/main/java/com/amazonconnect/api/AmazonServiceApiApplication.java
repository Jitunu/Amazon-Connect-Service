package com.amazonconnect.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication

public class AmazonServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonServiceApiApplication.class, args);
	}

}
