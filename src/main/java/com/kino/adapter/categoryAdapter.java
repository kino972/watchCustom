package com.kino.adapter;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.kino.dao.categoryDao;
import com.kino.entity.category;


@RequestScoped
public class categoryAdapter implements categoryAdapterInterface{
	
	@Inject
	private categoryDao categoryDao;
	
	final static Logger logger = Logger.getLogger(categoryAdapter.class);
	
	@SuppressWarnings("unchecked")
	public List<category> getCategories(){	
		logger.info("adapt category from dao");
    	 return (List<category>) categoryDao.readAllCategory();
    }
	
	
	public List<String> getCategoryNames(){
		List<category> categories = (List<category>) this.getCategories();
		ArrayList<String> categoryNames = new ArrayList<String>();
		for(category category:categories){
			categoryNames.add(category.getName());
			logger.info(category.getName());
		}
		return categoryNames;
	}
	
	@SuppressWarnings("unchecked")
	public List<category> getCategoriesBySubStepId(int id){
		return (List<category>) categoryDao.getCategoriesBySubStepId(id);
	}


}
