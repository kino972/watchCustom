package utils;

import java.util.List;

import com.kino.entity.product;

public class productUtils {

	public static String getProductsDescription(List<product> li){
		String description ="";
		if(li!=null){
			for(product p:li)
			{
				if(p != null){
					description = p.toString();
				}
			}
		}
		return description;
	}
	
}
