package com.anitesh.service;

import com.anitesh.bean.InventoryItem;
import com.anitesh.bean.OrderTable;
import com.anitesh.bean.Product;

public interface OrderService {
	public OrderTable getOrderById(long id);
	public boolean addOrders(OrderTable id);
	
	
	
	
}
