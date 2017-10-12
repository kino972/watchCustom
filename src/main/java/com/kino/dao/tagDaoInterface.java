package com.kino.dao;

import java.util.List;

public interface tagDaoInterface {
	
	public List<?> readAllTagByName(int name);
	
	public List<?> readAllTagById(int id);
	
	public List<?>readAllTag();
	
	public List<?> getTagByProductId(int id);

}
