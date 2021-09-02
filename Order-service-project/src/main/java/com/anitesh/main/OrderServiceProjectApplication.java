package com.anitesh.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.anitesh.bean.OrderItem;
import com.anitesh.bean.OrderTable;
import com.anitesh.persistance.OrderDao;
import com.anitesh.persistance.OrderItemDao;

@SpringBootApplication(scanBasePackages = "com.anitesh")
@EntityScan(basePackages = "com.anitesh.bean")
@EnableJpaRepositories(basePackages = "com.anitesh.persistance")
public class OrderServiceProjectApplication implements CommandLineRunner {
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderItemDao orderItemDao;

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		OrderItem o1 = new OrderItem(1, 1, 12, new BigDecimal(6433.2323));
		OrderItem o2 = new OrderItem(2, 2, 12, new BigDecimal(532.123213));
		OrderItem o3 = new OrderItem(3, 3, 124, new BigDecimal(1234.332323));
		orderItemDao.save(o1);
		orderItemDao.save(o2);
		orderItemDao.save(o3);
		

		List<OrderItem> items = new ArrayList<>(Arrays.asList(o1, o2, o3));

		OrderTable orderTable = new OrderTable(0, "reddyanitesh@gmail.com", "My adress", items);

		orderDao.save(orderTable);

	}

}
