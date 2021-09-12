package com.anitesh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddToCartImpl implements AddToCart {

	@Autowired
	InventoryService inventoryService;

	@Override
	public boolean checkAddToCart(int id, int quantity) {
		if (inventoryService.getInventoryById(id).getAvailableQuantity() > quantity)
			return true;
		return false;
	}

}
