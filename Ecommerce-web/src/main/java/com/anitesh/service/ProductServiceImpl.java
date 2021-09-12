package com.anitesh.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.anitesh.bean.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public Product[] getAllProducts() {

		return restTemplate.getForObject("http://localhost:9090/api/products", Product[].class);
	}

}
