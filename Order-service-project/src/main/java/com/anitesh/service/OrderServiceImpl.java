package com.anitesh.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.anitesh.bean.InventoryItem;
import com.anitesh.bean.OrderItem;
import com.anitesh.bean.OrderTable;
import com.anitesh.bean.Product;
import com.anitesh.persistance.OrderDao;
import com.anitesh.persistance.OrderItemDao;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;

	@Autowired
	OrderItemDao orderItemDao;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ProductService productService;

	@Autowired
	InventoryService inventoryService;

	@Override
	public OrderTable getOrderById(long id) {

		return orderDao.getById(id);

	}

	@Override
	public boolean addOrders(OrderTable orderTable) {

		try {

			List<OrderItem> newItems = new ArrayList<>();

			for (OrderItem item : orderTable.getItems()) {
				Product product = productService.getPriceById(item.getProductId());
				
				System.out.println("==================================================================");
				System.out.println(product.getPrice());

				if (product != null) {
					item.setProductPrice(new BigDecimal(product.getPrice()));
					System.out.println("up");

					InventoryItem inventoryItem = inventoryService.getQuantityById(product.getId());
					System.out.println("here");
					if (inventoryItem != null)
						if (inventoryItem.getAvailableQuantity() - item.getQuantity() >= 0)
							newItems.add(item);
				}
			}
			orderTable.getItems().clear();
			orderTable.setItems(newItems);

			orderTable.getItems().stream().forEach(e -> orderItemDao.save(e));
			orderDao.save(orderTable);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
