package com.kino.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

@ApplicationScoped
public class hibernateSessionFactory implements hibernateSessionFactoryInterface{
	
	final static Logger logger = Logger.getLogger(hibernateSessionFactory.class);	
	
	@Produces
	@Named("session")
	public Session setup() {
		
        // code to load Hibernate Session factory
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    	        .configure("hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
    	        .build();
    	try {
    		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
       		Session session =  sessionFactory.openSession();
       		logger.info("successfully getting hibernate session");
       		return session;

    	} catch (Exception ex) {
    		logger.fatal("something went wrong when getting hibernate session returning null "+ ex.getMessage());
    	    StandardServiceRegistryBuilder.destroy(registry);
    	    return null;
    	}
    }

}
