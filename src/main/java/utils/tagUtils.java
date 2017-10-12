package utils;

import java.util.List;

import com.kino.entity.tag;

public class tagUtils {

	public static String getTagNames(List<tag> li){
		String description ="";
		if(li!=null){
			for(tag t:li)
			{
				if(t != null){
					description =description + "tag: " + t.getName()+" ";
				}
			}
		}
		return description;
	}
	
}
