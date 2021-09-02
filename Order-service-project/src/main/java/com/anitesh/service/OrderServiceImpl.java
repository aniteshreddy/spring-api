package com.anitesh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.anitesh.bean.OrderTable;
import com.anitesh.persistance.OrderDao;
import com.anitesh.persistance.OrderItemDao;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;

	@Autowired
	OrderItemDao orderItemDao;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public OrderTable getOrderById(long id) {
		
		

		return orderDao.getById(id);

	}

	@Override
	public boolean addOrders(OrderTable orderTable) {

		try {
			orderTable.getItems().forEach(e -> orderItemDao.save(e));
			orderDao.save(orderTable);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	

	@Override
	public MovieRatingBean[] getMovieRatingByUserId(int id) {

		return restTemplate.getForObject("http://localhost:8085/movie-rating/" + id, MovieRatingBean[].class);

	}

}
