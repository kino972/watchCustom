package com.kino.front;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.kino.adapter.productAdapter;
import com.kino.entity.product;

import utils.productUtils;


public class homeManager  extends HttpServlet implements javax.servlet.Servlet{
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = -5105618880164454766L;
	final static Logger logger = Logger.getLogger(homeManager.class);
	 
			
		@Inject
		public productAdapter productAdapter;
		
	    @Override
	    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	//request.setAttribute( "products", productAdapter.getProducts() );
	    	
	    	try{
	    		List<product> products = (List<product>) productAdapter.getProducts();
	    		request.setAttribute( "products", products );
		    	logger.info("product list: "+productUtils.getProductsDescription(products));
	    	}
	    	catch(Exception e){
	    		request.setAttribute( "product", e );
	    		logger.fatal("could not get product list "+e.getMessage());
	    	}
	    	
	    	try{
	    		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
	    		dispatcher.forward(request,response);
	    		//request.getRequestDispatcher("index.jsp").forward(request,response);
	    	}
	    	catch(Exception e){
	    		logger.error(e.getMessage());
	    	}
	    }
	  
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	request.setAttribute( "products", productAdapter.getProducts() );
	    	//request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	    }
	      
	  
	}

