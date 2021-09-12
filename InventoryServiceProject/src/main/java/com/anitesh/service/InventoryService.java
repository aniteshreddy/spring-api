package com.anitesh.service;

import java.util.List;
import java.util.Optional;

import com.anitesh.bean.InventoryItem;

public interface InventoryService {
	public InventoryItem findInventoryByCode(String code);
	public List<InventoryItem> getInventory();
	public Optional<InventoryItem> findInventoryById(long code);
	public int updateInventoryByIdService(int quantity,int code);
}
