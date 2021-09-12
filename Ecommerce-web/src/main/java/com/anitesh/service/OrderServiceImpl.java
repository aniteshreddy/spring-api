package com.anitesh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.anitesh.bean.OrderTable;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public boolean placeOrderService(OrderTable orderTable) {

		if (restTemplate.postForEntity("http://localhost:9090/orders", orderTable, OrderTable.class)
				.getStatusCodeValue() == 201)

			return true;

		return false;
	}

}
