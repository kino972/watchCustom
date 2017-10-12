package com.kino.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.kino.entity.product;

@RequestScoped
public class productDao implements productDaoInterface{
	
	final static Logger logger = Logger.getLogger(productDao.class);
	
	
	@Inject
	private Session session;
	
	public List<?> readAllProductsByCategory(int category_id){
		String hql = "FROM product p WHERE p.fk_category_id=:category_id";
        Query query = session.createQuery(hql);
        query.setInteger("category_id",category_id);
        List<?> categories = query.list();
        return categories;
	}
	
	public List<?> readAllProductsByTagId(int id){
		String hql = "FROM product p JOIN p.tag t WHERE t.tag_id=:id";
        Query query = session.createQuery(hql);
        query.setInteger("id",id);
        List<?> products = query.list();
        return products;
	}
	
	public List<?> readAllProductsByTagName(String name){
		String hql = "FROM product p JOIN p.tag t WHERE t.name=:name";
		 Query query = session.createQuery(hql);
	     query.setString("id",name);
	     List<?> products = query.list();
	        return products;
	}
	
	public List<?> readAllProducts(){
		String hql = "FROM product";
		try{
			Query query = session.createQuery(hql);
			List<?> productResults = query.list();
			logger.info("getting products query string: "+query.getQueryString());
			return productResults;
		}
		catch(Exception e){
			logger.fatal("error while getting product from hibernate session object "+e.getMessage());
			return null;
		}
		
	}
	
	public List<?> getproductByCategoryId(int id){
		try{
		String hql = "select p FROM product p JOIN p.category c WHERE c.category_id=:id";
		Query query = session.createQuery(hql);
        query.setInteger("id",id);
        List<?> products = query.list();
        return products;
		}
		catch(Exception e){
			logger.fatal("error while getting category by id"+e.getMessage());
			return null;
		}
	}
	
	public product readProductById(int id) {
        // code to get a product
        return session.get(product.class, id);
        
    }
	
	public void create(product p) {
        session.beginTransaction(); 
        session.save(p);
        session.getTransaction().commit();
        session.close();
    }
	
	public void update(product p) {  	 
	    session.beginTransaction();
	    session.update(p);
	    session.getTransaction().commit();
	    session.close();
    }
 
	public void delete(product p) {
        session.beginTransaction();
        session.delete(p);
        session.getTransaction().commit();
        session.close();
    }
	/*
	public void exit() {
        // code to close Hibernate Session factory
    	sessionFactory.close();
    }*/

}
