package com.web.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.web.exep.Myexception;
import com.web.util.Closing;
import com.web.util.Connector;

public class FetchJson {
//	String sql = "select book.id,book.name,book.price,author.id,author.name from book,author";
	String sql = "select * from book left join book_author on book.id = book_author.book_id left join author on book_author.author_id=author.id  order by book.id asc";
	Closing close = new Closing();

	public List<JSONObject> fetch() throws Myexception {

		Connector connection = new Connector();
		Connection con = null;
//		PreparedStatement stmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<JSONObject> jsonData = new ArrayList<JSONObject>();
		try {

			con = connection.getConnector();
//			stmt = con.prepareStatement(sql);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
//			stmt.getUpdateCount();
//			int row=stmt.executeUpdate();
//			rs = stmt.executeQuery();

			System.out.println(rs);
			System.out.println("result set " + stmt.getResultSet());
			System.out.println("count update  " + stmt.getUpdateCount() + " ..");
			int count = 0;
			int authCount = 1;

			while (rs.next()) {

				System.out.println(rs.getString(1) + " name " + rs.getString(2) + "author " + rs.getString(8));
//				JSONArray jsonArray=new JSONArray();
				System.out.println("creating json obj");

				JSONObject jsonObject = new JSONObject();
				System.out.println("creating json array");

				JSONArray jsonArray = null;

//				if ((jsonData.size() != 0) && (jsonData.get(count - 1).containsKey("Authors"))) {
				
				if ((jsonData.size() != 0) && (jsonData.get(count - 1).containsValue(rs.getString(2)))) {
					System.out.println("in if 111");
					
					// adding author to existing author array
					
				System.out.println(jsonData.get(count - 1).get("name")+"if name");	
				System.out.println(rs.getString(2));	
					
					JSONObject jsonObjectAuthor = new JSONObject();
					jsonObjectAuthor.put("id", rs.getString(7));
					jsonObjectAuthor.put("name", rs.getString(8));
					System.out.println("authors arr  " + jsonData.get(count - 1).get("Authors"));
					
					JSONArray jsonArrayAuth = (JSONArray) jsonData.get(count - 1).get("Authors");
					jsonArrayAuth.add(authCount, jsonObjectAuthor);
					
//					jsonArray.set(authCount, jsonObjectAuthor);
					
					System.out.println("author" + jsonArrayAuth.get(0));
					System.out.println("author" + jsonArrayAuth.get(1));
					authCount++;
					System.out.println("out if");
				} else {
					System.out.println("in ielse"+count);
					
					authCount = 1;
					jsonObject.put("id", rs.getString(1));
					jsonObject.put("name", rs.getString(2));
					jsonObject.put("price", rs.getString(3));
					jsonArray = new JSONArray();
					JSONObject jsonObjectAuthor = new JSONObject();
					jsonObjectAuthor.put("id", rs.getString(7));
					jsonObjectAuthor.put("name", rs.getString(8));
					jsonArray.add(0, jsonObjectAuthor);
					
//					jsonArray.set(count, jsonObjectAuthor);
					
					System.out.println("jsonArray of authors" + jsonArray);
					count++;
					System.out.println("outing else");
					jsonObject.put("Authors", jsonArray);
					
					System.out.println("json added to list  " + jsonObject);
					jsonData.add(jsonObject);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" while fetching" + " " + e.getMessage() + " cause " + e.getCause());
		} finally {
			close.closeConnection(rs);
			close.closeConnection(stmt);
			close.closeConnection(con);
		}
		System.out.println("json data==  " + jsonData);
		return jsonData;
	}

}
