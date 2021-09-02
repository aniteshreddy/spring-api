package com.anitesh.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anitesh.bean.OrderItem;


@Repository
public interface OrderItemDao extends JpaRepository<OrderItem, Long> {

}
