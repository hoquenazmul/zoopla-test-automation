package com.apitesting;

import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.parser.ParseException;
import org.apache.juneau.serializer.SerializeException;
import org.apache.juneau.xml.XmlSerializer;

public class ProductTest {

	public static void main(String[] args) throws SerializeException, ParseException {
		// serialization
		// POJO to json
		
		JsonSerializer  jsonSerializer  = JsonSerializer.DEFAULT_READABLE;
		String[] sellerNames = {"Oni", "TCS", "QA-Automation"};
		
		Product product = new Product("White", 1000, "MaccBookPro", sellerNames);
		
		String json =jsonSerializer.serialize(product);
		System.out.println(json);
		
		
		// POJO to xml
		
		XmlSerializer  xmlSerializer  = XmlSerializer.DEFAULT_NS_SQ_READABLE;
		String xml =xmlSerializer.serialize(product);
		System.out.println(xml);
		
		// POJO to html
		HtmlSerializer  htmlSerializer  = HtmlSerializer.DEFAULT_SQ_READABLE;
		String html =htmlSerializer.serialize(product);
		System.out.println(html);
		
		
		// deserialization
		
		JsonParser jsonParser  = JsonParser.DEFAULT;
		String jsonValue ="{\n"
				+ "	\"color\": \"White\",\n"
				+ "	\"name\": \"MaccBookPro\",\n"
				+ "	\"price\": 1000,\n"
				+ "	\"sellerNames\": [\n"
				+ "		\"Oni\",\n"
				+ "		\"TCS\",\n"
				+ "		\"QA-Automation\"\n"
				+ "	]\n"
				+ "}";
		
		Product pro = jsonParser.parse(jsonValue, Product.class);
		System.out.println(pro.getColor());
		
		System.out.println(pro);
	}
	
	
	
	
}
