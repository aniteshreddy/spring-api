package com.anitesh.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class OrderTable {

	private String customerEmail;
	private String customerAddress;
	private List<CartItem> items;
}
