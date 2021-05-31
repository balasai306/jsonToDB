package com.web.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.web.dao.InsertJson;
import com.web.model.Author;
import com.web.model.Book;
import com.web.model.MapperJson;
import com.web.model.Pair;

public class InsertService {
	public void divide(String json) throws ParseException {
		System.out.println("serivce" + json);
		List<Book> books = new ArrayList<Book>();
		List<Author> authors = new ArrayList<Author>();
		List<MapperJson> mapJson = new ArrayList<MapperJson>();
	
		System.out.println(mapJson.size() + "mapjosn size");

		JSONParser parser = new JSONParser();
//		try {
//			JSONObject jsonObj = (JSONObject) parser.parse(json);
		JSONArray jsonArray = (JSONArray) parser.parse(json);
		for (Object object : jsonArray) {
			Book b = new Book();
			List<Author> authorsBook = new ArrayList<Author>();
			JSONObject record = (JSONObject) object;
//
//System.out.println(record.get("id"));
//System.out.println(record.get("title"));
//System.out.println(record.get("price"));
			b.setId((String) record.get("id"));
			b.setName((String) record.get("title"));
			b.setPrice((Long) record.get("price"));

			JSONArray jsonArrayAuth = (JSONArray) record.get("authors");
			for (Object auth : jsonArrayAuth) {
				Author a = new Author();

				JSONObject recordAuth = (JSONObject) auth;
				System.out.println(recordAuth.get("id"));
				System.out.println(recordAuth.get("name"));
				a.setId((String) recordAuth.get("id"));
				a.setName((String) recordAuth.get("name"));
				authors.add(a);
				authorsBook.add(a);
				System.out.println("authors " + authors);
			}
//			b.setAuthor(authors);
			b.setAuthor(authorsBook);
			System.out.println("authBooks" + authorsBook);
			books.add(b);

		}

		Map<Integer, Author> map = new HashMap<>();
		for (Author author : authors) {
			int i = Integer.parseInt(author.getId());
			if (!map.containsKey(i)) {
				map.put(i, author);

			}

		}
		System.out.println("itr map");
		List<Author> authorsDup = new ArrayList<Author>();

		for (int a : map.keySet()) {
//			System.out.println(map.get(a));
			Author auth = map.get(a);
			authorsDup.add(auth);
		}
		for (Author author : authorsDup) {
			System.out.println(author);

		}

		InsertJson insert = new InsertJson();
		for (int i = 0; i < books.size(); ++i) {
			for (int j = 0; j < books.get(i).getAuthor().size(); ++j) {
				 Pair<String, String> pair = new Pair<>();
			 pair.setFirst(books.get(i).getAuthor().get(j).getId());
			 pair.setSecond(books.get(i).getId());
	                insert.mapping(pair);
			 System.out.println(pair+"this is pair");
			}
		}
//		for (int i = 0; i < books.size(); ++i) {
//			MapperJson mapping = new MapperJson();
//			System.out.println(i + "i");
//			System.out.println("books.get(i).getId()" + books.get(i).getId());
//		
//			for (int j = 0; j < books.get(i).getAuthor().size(); ++j) {
//				//setting book id
//				String book_id=books.get(i).getId();
//				mapping.setBookId(book_id);
//				
//				System.out.println(j + "j");
//
//				System.out.println("auth" + books.get(i).getAuthor().get(j).getId());
//				String auth_id=books.get(i).getAuthor().get(j).getId();
//				mapping.setAuthId(auth_id);
//				System.out.println(mapping + "in auth");
//				mapJson.add(mapping);

//				
//				System.out.println("mapper:....." + mapJson);
//				System.out.println("next auth");
//			}
//			System.out.println("next book");
//		}
//		System.out.println(pair+"pair");
//		 System.out.println("books " +books);
//		 System.out.println("authors " +authors);
//	System.out.println("maping " +mapJson);
//		insert.insert(authorsDup,books,mapJson);
	}

}
