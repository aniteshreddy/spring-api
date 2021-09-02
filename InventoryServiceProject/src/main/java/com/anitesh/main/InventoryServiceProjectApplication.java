package com.anitesh.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.anitesh")
@EntityScan(basePackages = "com.anitesh.bean")
@EnableJpaRepositories(basePackages = "com.anitesh.persistance")
public class InventoryServiceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceProjectApplication.class, args);
	}

}
