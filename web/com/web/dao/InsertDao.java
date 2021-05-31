package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.web.exep.Myexception;
import com.web.model.playerModel;
import com.web.util.Closing;
import com.web.util.Connector;

public class InsertDao {
	String sql = "insert into player values (?,?,?)";
	Closing close = new Closing();

	public void insert(List<playerModel> pm) throws Myexception {

		Connector connection = new Connector();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		try {
			con = connection.getConnector();
			stmt = con.prepareStatement(sql);
		
			for (playerModel playerModel : pm) {
				stmt.setInt(1, playerModel.getId());
				stmt.setString(2, playerModel.getName());
				stmt.setString(3, playerModel.getCountry());
				stmt.executeUpdate();
				
				
			}

		} catch (Exception e) {
	e.printStackTrace();
		}
		finally {
			close.closeConnection(rs);
			close.closeConnection(stmt);
			close.closeConnection(con);
		}

		

	}

}
