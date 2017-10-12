package com.kino.adapter;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.kino.dao.tagDao;
import com.kino.entity.tag;

@RequestScoped
public class tagAdapter implements tagAdapterInterface{
	
	final static Logger logger = Logger.getLogger(tagAdapter.class);
	
	@Inject
	private tagDao tagDao;
	
	@SuppressWarnings("unchecked")
	public List<tag> getTags(){
		return (List<tag>) tagDao.readAllTag();
	}
	
	@SuppressWarnings("unchecked")
	public List<tag> getTagByProductId(int id){
		logger.info("adapting tags by product id");
		return (List<tag>) tagDao.getTagByProductId(id);
	}

}
