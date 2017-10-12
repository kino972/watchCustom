package com.kino.adapter;

import java.util.List;

import com.kino.entity.product;

public interface productAdapterInterface {
	public List<product> getProducts();

	public List<product> getProductsByTagName(String name);
	
	public List<product> getProductByTagId(int id);
}
