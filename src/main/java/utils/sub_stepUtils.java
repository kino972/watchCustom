package utils;

import java.util.List;

import com.kino.entity.sub_step;

public class sub_stepUtils {
	
	public static String getSubStepNames(List<sub_step> li){
		String description ="";
		if(li!=null){
			for(sub_step ss:li)
			{
				if(ss != null){
					description =description + "sub step: " + ss.getName()+" ";
				}
			}
		}
		return description;
	}

}
