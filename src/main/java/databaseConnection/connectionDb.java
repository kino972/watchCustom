package databaseConnection;

import java.sql.Connection;

import javax.enterprise.inject.Produces;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class connectionDb {
	
	final static Logger logger = Logger.getLogger(connectionDb.class);
	
	@Produces
	public Connection connectDb(){
		try{
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)
			envCtx.lookup("jdbc/watchCustom");
			Connection conn = ds.getConnection();
			return conn;
			//conn.close();
		}
		catch (Exception e){
			logger.fatal("error getting connection"+ e);
			return null;
		}
	}
}
