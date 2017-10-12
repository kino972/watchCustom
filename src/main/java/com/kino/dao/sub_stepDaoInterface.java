package com.kino.dao;

import java.util.List;

import com.kino.entity.sub_step;

public interface sub_stepDaoInterface {

	List<sub_step> getSubstep();

	List<sub_step> getSubstepById(int id);

	List<sub_step> getSubstepByStepId(int id);
	
	public List<sub_step> getSubstepByCategoryId(int id);
	

}