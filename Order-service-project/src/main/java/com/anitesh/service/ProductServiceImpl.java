package com.anitesh.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.anitesh.bean.Product;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	RestTemplate restTemplate;
	

	@Override
	@CircuitBreaker(name="product", fallbackMethod = "getPriceByIdFallBack")
	public Product getPriceById(long id) {

		try {
			return restTemplate.getForObject("http://localhost:9090/api/products/id/" + id, Product.class);

		}

		catch (HttpClientErrorException e) {
			
			
			e.printStackTrace();

			return null;

		}

	}
	
	public Product getPriceByIdFallBack(Exception e) {
		return new Product(new Long(0),"","","",new Double(0.00));
	}

}
