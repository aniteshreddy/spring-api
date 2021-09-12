package com.anitesh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


import com.anitesh.bean.InventoryItem;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	@CircuitBreaker(name="quantity" , fallbackMethod="getQuantityByIdFallBack")
	public InventoryItem getQuantityById(long id) {
		try {
			return restTemplate.getForObject("http://localhost:9090/inventories/id/" + id, InventoryItem.class);
		} catch (HttpClientErrorException e) {
			
			return null;
		}
	}
	
	public InventoryItem getQuantityByIdFallBack(Exception e) {
		return new InventoryItem(0,"",0);
	}
	
	

}
