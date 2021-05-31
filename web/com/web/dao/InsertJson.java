package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.web.model.Author;
import com.web.model.Book;
import com.web.model.MapperJson;
import com.web.model.Pair;
import com.web.util.Closing;
import com.web.util.Connector;

public class InsertJson {

	String sqlBooks = "insert into book values(?,?,?)";
	String sqlAuth = "insert into author values(?,?)";
	String sqlMap = "insert into book_author (book_id,author_id) values(?,?)";
	Closing close = new Closing();

	public void insert(List<Author> authorsDup, List<Book> books, List<MapperJson> mapJson) {

		Connector connection = new Connector();
		Connection con = null;
		PreparedStatement stmtBook = null;
		PreparedStatement stmtAuth = null;
		PreparedStatement stmtMap = null;
	

		try {
			con = connection.getConnector();
			stmtBook = con.prepareStatement(sqlBooks);
			stmtAuth = con.prepareStatement(sqlAuth);
			stmtMap=con.prepareStatement(sqlMap);
			for (Book book : books) {
				System.out.println("inserting books");
				System.out.println(book.getId());
				stmtBook.setString(1, book.getId());
				stmtBook.setString(2, book.getName());
				stmtBook.setLong(3, book.getPrice());

				stmtBook.executeUpdate();

			}
			for (Author auth : authorsDup) {
				System.out.println("inserting authors");
				System.out.println(auth.getId());
				stmtAuth.setString(1, auth.getId());
				stmtAuth.setString(2, auth.getName());
				stmtAuth.executeUpdate();
			}
//			for (MapperJson mapperJson : mapJson) {
//				
//				System.out.println("inserting mapping");
//				System.out.println("book id"+mapperJson.getBookId());
//				System.out.println("auth id "+mapperJson.getAuthId());
//				
//				stmtMap.setString(1, mapperJson.getBookId());
//				stmtMap.setString(2, mapperJson.getAuthId());
//			}

			System.out.println("inserting finished");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close.closeConnection(stmtMap);
			close.closeConnection(stmtBook);
			close.closeConnection(stmtAuth);
			close.closeConnection(con);
		}

	}

	public void mapping(Pair<String, String> pair) {
		Connector connection = new Connector();
		Connection con = null;
	
		PreparedStatement stmtMap = null;
	

		try {
			con = connection.getConnector();
			
			stmtMap=con.prepareStatement(sqlMap);
		
				System.out.println("inserting mapper");
				System.out.println(pair.getFirst());
				stmtMap.setString(1, pair.getSecond());
				stmtMap.setString(2, pair.getFirst());
				
				stmtMap.executeUpdate();

		

			System.out.println("inserting finished");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close.closeConnection(stmtMap);
		
			close.closeConnection(con);
		}
		// TODO Auto-generated method stub
		
	}

	
}
