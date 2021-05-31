package com.web.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.web.dao.InsertDao;
import com.web.exep.Myexception;
import com.web.model.playerModel;

@WebServlet("/Insert")
public class PlayerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));

		String json = "";
		if (br != null) {
			json = br.readLine();
		}
		System.out.println(json);
		List<playerModel> pm = new ArrayList<playerModel>();
		JSONParser parser = new JSONParser();
		try {
			JSONObject jsonObj = (JSONObject) parser.parse(json);
			JSONArray jsonArray = (JSONArray) jsonObj.get("players_data");// selecting array in json obj
			for (Object object : jsonArray) {
				playerModel pmObj = new playerModel();
				JSONObject record = (JSONObject) object;
//				System.out.println(record.get("ID"));
//
//				System.out.println(record.get("First_Name"));
//				System.out.println(record.get("Country"));
				int id = Integer.parseInt((String) record.get("ID"));
				pmObj.setId(id);
				pmObj.setName((String) record.get("First_Name"));
				pmObj.setCountry((String) record.get("Country"));
				pm.add(pmObj);
				
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			new InsertDao().insert(pm);
		} catch (Myexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
