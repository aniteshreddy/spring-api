package com.anitesh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anitesh.bean.InventoryItem;
import com.anitesh.persistance.InventoryItemDoa;


@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryItemDoa inventoryItemDoa;

	@Override
	public InventoryItem findInventoryByCode(String code) {

		return inventoryItemDoa.getInventoryItemByCode(code);

	}

	@Override
	public List<InventoryItem> getInventory() {

		return inventoryItemDoa.findAll();
	}
	
	@Override
	public Optional<InventoryItem> findInventoryById(long code) {

		return inventoryItemDoa.findById(code);

	}

	@Override
	public int updateInventoryByIdService(int quantity, int code) {
		
		return inventoryItemDoa.updateInventoryById(quantity, code);
	}

}
