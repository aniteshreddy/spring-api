package com.anitesh.helper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.anitesh.bean.InventoryItem;

public class InventoryRowMapper implements RowMapper<InventoryItem> {

	@Override
	public InventoryItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		InventoryItem inventoryItem = new InventoryItem();
		inventoryItem.setId(rs.getLong("id"));
		inventoryItem.setInventoryCode(rs.getString("inventoryCode"));
		inventoryItem.setAvailableQuantity(rs.getInt("avaiableQuantity"));
		
		return inventoryItem;
	}

}
