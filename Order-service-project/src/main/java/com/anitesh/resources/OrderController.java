package com.anitesh.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anitesh.bean.OrderTable;
import com.anitesh.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

//	@SuppressWarnings("finally")
	@GetMapping(path = "/{id}", produces = "Application/json")
	public ResponseEntity<OrderTable> getOrderById(@PathVariable("id") long id) {

		try {

			OrderTable orderTable = orderService.getOrderById(id);
			if (orderTable.getItems()!=null) {
				return ResponseEntity.status(HttpStatus.OK).body(orderTable);
			}
		} catch (Exception e) {

		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

	}

	@PostMapping(path = "", consumes = "Application/json")
	public ResponseEntity<Object> addData(@RequestBody OrderTable orderTable) {

		if (orderService.addOrders(orderTable)) {
			return ResponseEntity.status(HttpStatus.CREATED).body(null);
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

	}

}
