package com.kino.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "category")
public class category {
	
	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int category_id;
	
	private String name;
	
	@ManyToOne
    @JoinColumn(name="fk_sub_step_id")
	private sub_step sub_step;
	
	@OneToMany(mappedBy="category")
	private Set<product> product;
	
	public int getCategory_id(){
		return this.category_id;
	}
	
	public void setCategory_id(int category_id){
		this.category_id = category_id;
	}

	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public Set<product> getProduct_id(){
		return this.product;
	}
	
	public void setProduct(Set<product> product){
		this.product = product;
	}
	
}
