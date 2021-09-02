package com.anitesh.service;

import java.util.List;

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

}
