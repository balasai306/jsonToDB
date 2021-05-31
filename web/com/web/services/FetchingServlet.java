package com.web.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.XML;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.web.dao.FetchJson;
import com.web.exep.Myexception;

@WebServlet("/fetch")
public class FetchingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		FetchJson fetchJson = new FetchJson();
		List<JSONObject> listData = new ArrayList<JSONObject>();
		System.out.println("insrvlet");
		try {
			listData = fetchJson.fetch();
			System.out.println("fetch is called ");
			System.out.println(listData + "  list data  ");

			Gson gson = new Gson();
			String toJson = gson.toJson(listData);
			
			JsonArray convertedArr = new Gson().fromJson(toJson, JsonArray.class);
			JSONObject jo=new JSONObject();
		
			jo.put("Books", convertedArr);
			System.out.println(jo);
			
			String toJson1 = gson.toJson(jo);	
			
			JsonToXml jsonToXml = new JsonToXml();
			String xml = jsonToXml.toXml(toJson1);
			
			System.out.println("xml is" + xml);
			// converting json to xml
//			import org.json.JSONObject;
//			import org.json.XML;

		} catch (Myexception e) {
			System.out.println("error in servlet");
		}

		for (JSONObject jsonObject : listData) {
			System.out.println(jsonObject + "..........");

		}

	}

}
