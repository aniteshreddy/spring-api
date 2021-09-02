package com.anitesh.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.anitesh.bean.InventoryItem;

@Repository
public interface InventoryItemDoa extends JpaRepository<InventoryItem,Long>{
	
	@Query("from InventoryItem where inventoryCode=:code ")
	public InventoryItem getInventoryItemByCode(@Param("code") String code);
	
	
	@Query("from InventoryItem")
	List<InventoryItem> findAllInventoryItems();


}
