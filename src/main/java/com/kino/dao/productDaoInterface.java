package com.kino.dao;

import java.util.List;
import com.kino.entity.product;

public interface productDaoInterface {
	       
	public List<?> readAllProduct();
	
	public product readProductById(int id);
	
	public void create(product p);
	
	public void update(product p);
 
	public void delete(product p);
	
}
