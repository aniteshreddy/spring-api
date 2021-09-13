package com.anitesh.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anitesh.bean.InventoryItem;

@Repository
public interface InventoryItemDoa extends JpaRepository<InventoryItem,Long>{
	
	@Query("from InventoryItem where inventoryCode=:code ")
	public InventoryItem getInventoryItemByCode(@Param("code") String code);
	
	
	@Query("from InventoryItem")
	List<InventoryItem> findAllInventoryItems();
	
	@Transactional
	@Modifying
	@Query("update InventoryItem set availableQuantity=:aq where id=:code")
	public int  updateInventoryById(@Param("aq")int quantity,@Param("code")long code);

}
