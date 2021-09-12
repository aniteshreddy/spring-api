package com.anitesh.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class OrderTable {

	private String customerEmail;
	private String customerAddress;
	private List<CartItem> items;
}
