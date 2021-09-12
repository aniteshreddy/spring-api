package com.anitesh.bean;



import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class InventoryItem {

	private long id;
	private String inventoryCode;
	private int availableQuantity;

}
