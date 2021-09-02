package com.anitesh.service;

import java.util.List;

import com.anitesh.bean.InventoryItem;

public interface InventoryService {
	public InventoryItem findInventoryByCode(String code);
	public List<InventoryItem> getInventory();
}
