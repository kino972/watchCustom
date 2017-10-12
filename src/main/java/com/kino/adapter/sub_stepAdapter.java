package com.kino.adapter;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.kino.dao.sub_stepDao;
import com.kino.entity.sub_step;

@RequestScoped
public class sub_stepAdapter implements sub_stepAdapterInterface {
	
	@Inject
	sub_stepDao sub_stepDao;
	
	/* (non-Javadoc)
	 * @see com.kino.adapter.sub_stepAdapterInterface#getSubstepbyId(int)
	 */
	public List<sub_step> getSubstepbyId(int id){
		return (List<sub_step>) sub_stepDao.getSubstepById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.kino.adapter.sub_stepAdapterInterface#getSubstepbycategoryid(int)
	 */
	public List<sub_step> getSubstepbycategoryid(int id){
		return (List<sub_step>) sub_stepDao.getSubstepByCategoryId(id);
	}

	public List<sub_step> getSubstep(){
		return (List<sub_step>) sub_stepDao.getSubstep();
	}
	
	public List<sub_step> getSubStepByName(String name){
		return (List<sub_step>) sub_stepDao.getSubStepByName(name);
	}
}
