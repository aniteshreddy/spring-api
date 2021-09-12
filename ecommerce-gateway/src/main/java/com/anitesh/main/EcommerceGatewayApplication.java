package com.anitesh.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EcommerceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceGatewayApplication.class, args);
	}

}
