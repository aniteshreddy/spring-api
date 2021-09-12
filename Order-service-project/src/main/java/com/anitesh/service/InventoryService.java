package com.anitesh.service;

import com.anitesh.bean.InventoryItem;

public interface InventoryService {
	public InventoryItem getQuantityById(long id);
}
