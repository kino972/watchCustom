package com.kino.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public interface categoryDaoInterface {
	public List<?> readAllCategoryById(int category_id);
	public List<?> readAllCategoryByName(String category_name);
	public List<?> readAllCategory();
	public List<?> getCategoriesBySubStepId(int id);
}