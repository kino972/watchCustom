package com.kino.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tag")
public class tag {
	
	private int tag_id;
	private String name;
	
	
	@Id
	@Column(name = "tag_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getTag_id(){
		return this.tag_id;
	}
	
	public void setTag_id(int id){
		this.tag_id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
}

