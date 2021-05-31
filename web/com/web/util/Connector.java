package com.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.web.exep.Myexception;



public class Connector {
	public Connection getConnector() throws SQLException, Myexception {
	Connection connect=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			String url="jdbc:mysql://localhost:3306/playerJson";
			String url="jdbc:mysql://localhost:3306/jsonReview";
			String user="root";
			String password="1234";
			
			connect=DriverManager.getConnection(url, user, password);
			System.out.println("connection sucess");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		//	throw new Myexception("class not found");
		}
	
		return connect;
		
	}

}
