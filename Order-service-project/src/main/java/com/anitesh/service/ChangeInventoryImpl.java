package com.anitesh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChangeInventoryImpl implements ChangeInventory {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public boolean changeInventoryService(long id, int quantity) {
		HttpEntity<Object> request = new HttpEntity<>(new Object());
		ResponseEntity<Object> response = restTemplate.exchange(
				"http://localhost:9090/inventories/id/" + id + "/" + quantity, HttpMethod.PUT, request, Object.class);
		if (response.getStatusCodeValue() == 200)
			return true;
		return false;
	}

}
