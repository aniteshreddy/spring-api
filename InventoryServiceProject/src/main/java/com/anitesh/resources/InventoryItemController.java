package com.anitesh.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anitesh.bean.InventoryItem;
import com.anitesh.service.InventoryService;

@RestController
@RequestMapping("/inventories")
public class InventoryItemController {

	@Autowired
	InventoryService inventoryService;

	@GetMapping(produces = "Application/json")
	public ResponseEntity<List<InventoryItem>> getAllInventory() {
		return ResponseEntity.status(HttpStatus.OK).body(inventoryService.getInventory());
	}

	@GetMapping(path = "/code/{code}", produces = "Application/json")
	public ResponseEntity<InventoryItem> getInventoryByCode(@PathVariable("code") String code) {
		InventoryItem inventoryItem = inventoryService.findInventoryByCode(code);
		if (inventoryItem != null) {
			return ResponseEntity.status(HttpStatus.OK).body(inventoryItem);

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

	}

	@GetMapping(path = "/id/{id}", produces = "Application/json")
	public ResponseEntity<InventoryItem> getInventoryByCode(@PathVariable("id") long id) {
		InventoryItem inventoryItem = inventoryService.findInventoryById(id).orElse(null);
		if (inventoryItem != null) {
			return ResponseEntity.status(HttpStatus.OK).body(inventoryItem);

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

	}

	@PutMapping(path = "/id/{id}/{availableQuantity}")
	public ResponseEntity<Object> updateInventoryItemQuantityByProductId(@PathVariable("id") int code,
			@PathVariable("availableQuantity") int quantity) {
		if (inventoryService.updateInventoryByIdService(quantity, code) > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(null);

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

	}

}
