package com.kino.front;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.kino.adapter.categoryAdapter;
import com.kino.adapter.productAdapter;
import com.kino.adapter.sub_stepAdapter;
import com.kino.adapter.tagAdapter;
import com.kino.entity.category;
import com.kino.entity.product;
import com.kino.entity.sub_step;
import com.kino.entity.tag;

import utils.categoryUtils;
import utils.productUtils;
import utils.sub_stepUtils;
import utils.tagUtils;


public class homeManager  extends HttpServlet implements javax.servlet.Servlet{
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = -5105618880164454766L;
	final static Logger logger = Logger.getLogger(homeManager.class);
	 
			
		@Inject
		public productAdapter productAdapter;
		
		@Inject
		public categoryAdapter categoryAdapter;
		
		@Inject 
		public tagAdapter tagAdapter;
		
		@Inject
		public sub_stepAdapter sub_stepAdapter;
		
	    @Override
	    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    		int sub_step_id;
	    		List<sub_step> sub_steps;
	    		//if navigation have been made to non default breadcrumb
	    		if(getUrlParam(request.getPathInfo(),1) != -1){
	    			sub_step_id = getUrlParam(request.getPathInfo(),1);
	    			sub_steps = sub_stepAdapter.getSubstepbyId(sub_step_id);
	    			logger.info("navigation detected"+sub_step_id);
	    		}
	    		//get root sub step to param
	    		else{
	    			sub_steps = sub_stepAdapter.getSubStepByName("choose your movement");
	    			logger.info("no navigation detected");
	    		}
	    		logger.info("sub steps list: "+sub_stepUtils.getSubStepNames(sub_steps));
	    		
	    		List<sub_step> all_sub_steps = sub_stepAdapter.getSubstep();
	    		logger.info("all sub steps list: "+sub_stepUtils.getSubStepNames(all_sub_steps));
	    		
	    		//get category corresponding to substep
	    		List<category> categories = (List<category>) new ArrayList<category>();
	    		for(sub_step sub_step:sub_steps){
	    			if(sub_step != null){
	    				logger.debug("sub step id"+sub_step.getSub_step_id());
	    				categories.addAll(categoryAdapter.getCategoriesBySubStepId(sub_step.getSub_step_id()));
	    			}
	    		}
	    		logger.info("category list: "+categoryUtils.getCategoryNames(categories));
	    		
    			//get product corresponding to to category;
	    		List<product> products = new ArrayList<product>();
	    		for(category category: categories){
	    			if(category !=null){
		    			logger.debug("category id"+category.getCategory_id());
		    			products.addAll(productAdapter.getProductsByCategoryId(category.getCategory_id()));
	    			}
	    		}		
	    		logger.info("product list: "+productUtils.getProductsDescription(products));
	    		
    			//get tag available for product selection
	    		List<tag> tags = new ArrayList<tag>();
	    		for(product product:products){
	    			if(product != null){
		    			logger.debug("product id"+product.getProduct_id());
		    			tags.addAll(tagAdapter.getTagByProductId(product.getProduct_id()));
	    			}
	    		}
	    		logger.info("tag list: "+tagUtils.getTagNames(tags));
	    		
	    		request.setAttribute("categories", categories);
	    		request.setAttribute( "products", products );
	    		request.setAttribute("tags", tags);
	    		request.setAttribute("sub_steps", all_sub_steps);
	    		
		    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.xhtml");
	    		dispatcher.forward(request,response);
	    	}
	  
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	request.setAttribute( "products", productAdapter.getProducts() );
	    	//request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	    }
	    
	    public int getUrlParam(String s,int index){
	    	if(!s.isEmpty()){
		    	String[] splited_url = s.split("/");
		    	if (splited_url.length > index){
		    		logger.info("getting parameter string "+splited_url[index]);
		    		return Integer.valueOf(splited_url[index]);
		    	}
		    	else{
		    		logger.fatal("wrong index paremeter value, String value"+s);
		    		return -1;
		
		    	}
	    	}
	    	else{
	    		logger.fatal("no request passed in parameter, String value"+s);
	    		return -2;
	    		
	    	}
	    }
	      
	  
	}

