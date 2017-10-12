package com.kino.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

@RequestScoped
public class tagDao implements tagDaoInterface{

final static Logger logger = Logger.getLogger(tagDao.class);
	
	
	@Inject
	private Session session;
	
	public List<?> readAllTagByName(int name){
		String hql = "FROM tag t WHERE t.name=:name";
        Query query = session.createQuery(hql);
        query.setInteger("name",name);
        List<?> tags = query.list();
        return tags;
	}
	
	public List<?> readAllTagById(int id){
		String hql = "FROM tag t WHERE t.tag_id=:id";
        Query query = session.createQuery(hql);
        query.setInteger("id",id);
        List<?> tags = query.list();
        return tags;
	}
	
	public List<?>readAllTag(){
		String hql = "FROM tag t";
        Query query = session.createQuery(hql);
        List<?> tags = query.list();
        return tags;
	}
	
	public List<?> getTagByProductId(int id){
		try{
			String hql = "SELECT t FROM product p JOIN p.tag t WHERE p.product_id=:id";
	        Query query = session.createQuery(hql);
	        query.setInteger("id",id);
	        List<?> tags = query.list();
	        return tags;
		}
		catch(Exception e){
			logger.fatal("error while getting tag by product id"+e.getMessage());
			return null;
		}
	}
	
}
