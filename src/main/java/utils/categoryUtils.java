package utils;

import java.util.List;

import org.apache.log4j.Logger;

import com.kino.entity.category;

public class categoryUtils {
	
	final static Logger logger = Logger.getLogger(categoryUtils.class);
	
	public static String getCategoryDescription(List<category> li){
		String s = "";
		for (category c: li){
			s = s+"id: "+c.getCategory_id()+" name: "+c.getName();		
		}
		
		return s;
	}
	public static String getCategoryNames(List<category> li){
		
		String s = "";
		List<category> li2 = (List<category>) li;
		logger.info(li2.getClass());
		if(li2!=null){
			for (category c:li2){
				s = s+"category: "+c.getName()+" ";		
			}
		}
		return s;
	}
	
	

}
