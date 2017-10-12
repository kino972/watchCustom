package com.kino.adapter;

import java.util.List;

import com.kino.entity.sub_step;

public interface sub_stepAdapterInterface {

	List<sub_step> getSubstepbyId(int id);

	List<sub_step> getSubstepbycategoryid(int id);
	
	public List<sub_step> getSubstep();

}