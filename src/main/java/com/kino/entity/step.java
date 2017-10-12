package com.kino.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "step")
public class step {

	
	@Id
	@Column(name="step_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int step_id;
	
	private String name;
	
	@OneToMany(mappedBy="sub_step_id")
    private Set<sub_step> sub_step;
	

	public int getStep_id(){
		return this.step_id;
	}
	
	public void setStep_id(int id){
		this.step_id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	
	public Set<sub_step> getSub_step(){
		return this.sub_step;
	}
	
	public void setSub_step(Set<sub_step> sub_step){
		this.sub_step = sub_step;
	}
	
	
}
