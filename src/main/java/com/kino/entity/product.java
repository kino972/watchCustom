package com.kino.entity;
 
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class product {
	
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;
	
	private String title;
	
	private String description;
	
	private float price;
//	private int fk_category_id;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "product_tag", joinColumns = { @JoinColumn(name = "fk_product_id") }, inverseJoinColumns = { @JoinColumn(name = "fk_tag_id") })
	private Set<tag> tag = new HashSet<tag>(0);
	
	@ManyToOne
	@JoinColumn(name = "fk_category_id")
	private category category;
	

	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
/*
	public void setFk_category_id(int fK_category_id){
		this.fk_category_id = fK_category_id;
	}
	
	public int getFk_category_id(){
		return this.fk_category_id;
	}
*/
	public Set<tag> getTag(){
		return this.tag;	
	}
	
	public void setTag(Set<tag> tag){
		this.tag= tag;
	}
	
}
