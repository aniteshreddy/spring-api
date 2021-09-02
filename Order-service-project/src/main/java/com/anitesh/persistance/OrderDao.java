package com.anitesh.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.anitesh.bean.OrderTable;
import com.fasterxml.jackson.databind.JsonMappingException;

@Repository
public interface OrderDao extends JpaRepository<OrderTable, Long> {
	@Query("from OrderTable where id=:id")
	public OrderTable findById(@Param("id") long id);
}
