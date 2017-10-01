package com.kino.entity;
 
import javax.persistence.*;

@Entity
@Table(name = "product")
public class product {
	
	private int product_id;
	private String title;
	private String description;
	private float price;
	
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public String toString(){
		return "product_id "+product_id+" "+" title "+ title+ " description "+ description + " price "+ price;
	}
}
