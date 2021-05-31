package com.web.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Closing {
	public void closeConnection(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}
	public void closeConnection(Connection con) {
		if(con!=null) {
			try {
				con.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}
	public void closeConnection(Statement stmt) {
		if(stmt!=null) {
			try {
				stmt.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}

}
