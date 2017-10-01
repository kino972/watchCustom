package com.kino.adapter;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.kino.dao.productDao;


@RequestScoped
public class productAdapter implements productAdapterInterface{
	
	@Inject
	@RequestScoped
	private productDao productDao;
	
	final static Logger logger = Logger.getLogger(productAdapter.class);
	public List<?> getProducts(){
		
		logger.info("adapt product from dao");
    	 return productDao.readAllProduct();
    	
    }

}
