package com.kino.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.kino.entity.sub_step;

@RequestScoped
public class sub_stepDao implements sub_stepDaoInterface {
	
	final static Logger logger = Logger.getLogger(sub_stepDao.class);
	
	@Inject
	private Session session;
	
	/* (non-Javadoc)
	 * @see com.kino.dao.sub_stepDaoInterface#getSubstep()
	 */
	public List<sub_step> getSubstep(){
		String hql = "select ss FROM sub_step ss";
        Query query = session.createQuery(hql);
        @SuppressWarnings("unchecked")
		List<sub_step> sub_steps =  query.list();
        return sub_steps;
	}
	
	/* (non-Javadoc)
	 * @see com.kino.dao.sub_stepDaoInterface#getSubstepById(int)
	 */
	public List<sub_step> getSubstepById(int id){
		String hql = "FROM sub_step ss WHERE ss.sub_step_id=:id";
        Query query = session.createQuery(hql);
        query.setInteger("id",id);
        @SuppressWarnings("unchecked")
		List<sub_step> sub_steps =  query.list();
        return sub_steps;
	}
	
	/* (non-Javadoc)
	 * @see com.kino.dao.sub_stepDaoInterface#getSubstepByStepId(int)
	 */
	public List<sub_step> getSubstepByStepId(int id){
		String hql = "FROM sub_step ss JOIN ss.step s WHERE s.id=:id";
        Query query = session.createQuery(hql);
        query.setInteger("id",id);
        @SuppressWarnings("unchecked")
		List<sub_step> sub_steps =  query.list();
        return sub_steps;
	}
	
	public List<sub_step> getSubstepByCategoryId(int id){
		String hql = "FROM sub_step ss JOIN ss.category c WHERE c.id=:id";
		Query query = session.createQuery(hql);
        query.setInteger("id",id);
        @SuppressWarnings("unchecked")
		List<sub_step> sub_steps = query.list();
        return sub_steps;
	}
	
	public List<sub_step> getSubStepByName(String name){
		try{
		String hql = "FROM sub_step ss WHERE ss.name=:name";
		Query query = session.createQuery(hql);
		query.setString("name",name);
		@SuppressWarnings("unchecked")
		List<sub_step> sub_steps = query.list();
		return sub_steps;
		}
		catch(Exception e){
			logger.fatal("error while getting sub step by name "+e.getMessage());
			return null;
		}
	}
}


