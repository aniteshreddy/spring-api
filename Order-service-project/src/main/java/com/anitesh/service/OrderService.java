package com.anitesh.service;

import com.anitesh.bean.OrderTable;

public interface OrderService {
	public OrderTable getOrderById(long id);
	public boolean addOrders(OrderTable id);
	
	
}
