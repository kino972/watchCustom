package com.kino.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

@RequestScoped
public class categoryDao implements categoryDaoInterface{
	
final static Logger logger = Logger.getLogger(categoryDao.class);
	
	
	@Inject
	private Session session;
	
	public List<?> readAllCategoryById(int category_id){
		String hql = "SELECT c FROM category c WHERE c.category_id=:category_id";
        Query query = session.createQuery(hql);
        query.setInteger("category_id",category_id);
        List<?> categories = query.list();
        return categories;
	}
	
	public List<?> readAllCategoryByName(String category_name){
		String hql = "SELECT c FROM category c WHERE c.name=:category_name";
        Query query = session.createQuery(hql);
        query.setString("category_id",category_name);
        List<?> categories = query.list();
        return categories;
	}
	
	public List<?> readAllCategory(){
		String hql = "SELECT c FROM category";
		try{
			Query query = session.createQuery(hql);
			List<?> categories = query.list();
			logger.info("getting category query string: "+query.getQueryString());
			return categories;
		}
		catch(Exception e){
			logger.fatal("error while getting category from hibernate session object "+e.getMessage()+e.getStackTrace().toString());
			return null;
		}
		
	}
	
	public List<?> getCategoriesBySubStepId(int id){
		try{
			String hql = "SELECT c FROM category c JOIN c.sub_step ss WHERE ss.sub_step_id=:id";
	        Query query = session.createQuery(hql);
	        query.setInteger("id",id);
	        List<?> categories = query.list();
	        return categories;
		}
		catch(Exception e){
			logger.fatal("error while getting categories by substep id" + e.getMessage());
			return null;
		}
	}

}
