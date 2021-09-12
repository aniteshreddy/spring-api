package com.anitesh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.anitesh.bean.InventoryItem;

@Service
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	RestTemplate restTemplate;

	@Override
	public InventoryItem getInventoryById(int id) {

		return restTemplate.getForObject("http://localhost:9090/inventories/id/"+id,InventoryItem.class);
	}

}
