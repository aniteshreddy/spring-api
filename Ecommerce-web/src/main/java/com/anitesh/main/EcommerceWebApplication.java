package com.anitesh.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.anitesh.bean.UserAccount;
import com.anitesh.persistance.UserDao;

@SpringBootApplication(scanBasePackages = "com.anitesh")
@EntityScan(basePackages = "com.anitesh.bean")
@EnableJpaRepositories(basePackages = "com.anitesh.persistance")
@EnableEurekaClient
public class EcommerceWebApplication implements CommandLineRunner {

	@Autowired
	UserDao userDao;
	
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(EcommerceWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		userDao.save(new UserAccount("reddyanitesh@gmail.com", "123"));

	}
}







