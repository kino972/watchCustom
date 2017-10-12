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
@Table(name = "sub_step")
public class sub_step {


		@Id
		@Column(name="sub_step_id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int sub_step_id;
		
		private String name;
		
		@ManyToOne
	    @JoinColumn(name="fk_step_id")
	    private step step;
		
		@OneToMany(mappedBy="category_id")
	    private Set<category> category;
		

		public int getSub_step_id(){
			return this.sub_step_id;
		}
		
		public void setSub_step_id(int id){
			this.sub_step_id = id;
		}
		
		public String getName(){
			return this.name;
		}
		
		public void setName(String name){
			this.name = name;
		}
		
		public step getStep(){
			return this.step;
		}
		
		public void setStep(step step){
			this.step = step;
		}
		
		public Set<category> getCategory(){
			return this.category;
		}
		
		public void setCategory(Set<category> category){
			this.category = category;
		}
}
