package com.web.services;

import org.json.JSONObject;
import org.json.XML;

public class JsonToXml {
	public String toXml(String toJson) {

		JSONObject obj = new JSONObject(toJson);
		// converting json to xml
		String xml_data = XML.toString(obj);
		System.out.println(xml_data);
		return xml_data;
	}

}
