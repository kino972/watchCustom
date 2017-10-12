package com.kino.adapter;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.kino.dao.productDao;
import com.kino.entity.product;

@RequestScoped
public class productAdapter implements productAdapterInterface{
	
	@Inject
	private productDao productDao;
	
	final static Logger logger = Logger.getLogger(productAdapter.class);
	
	@SuppressWarnings("unchecked")
	public List<product> getProducts(){
		logger.info("adapt product from dao");
    	 return (List<product>) productDao.readAllProducts();
    	
    }

	@SuppressWarnings("unchecked")
	public List<product> getProductsByTagName(String name){
		return (List<product>) productDao.readAllProductsByTagName(name);
	}
	
	@SuppressWarnings("unchecked")
	public List<product> getProductByTagId(int id){
		return (List<product>) productDao.readAllProductsByTagId(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<product> getProductsByCategoryId(int id){
		logger.info("adapting product by category");
		return (List<product>) productDao.getproductByCategoryId(id);
	}

}
