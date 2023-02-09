package Org.Player.list;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import groovy.json.JsonException;
import io.restassured.RestAssured;

public class TestCases  {
	String jsonDataString ="{\r\n"
			+ "  \"name\": \"Royal Challengers Bangalore\",\r\n"
			+ "  \"location\": \"Bangalore\",\r\n"
			+ "  \"player\": [\r\n"
			+ "    {\r\n"
			+ "      \"name\": \"Faf Du Plessis\",\r\n"
			+ "      \"country\": \"South Africa\",\r\n"
			+ "      \"role\": \"Batsman\",\r\n"
			+ "      \"price-in-crores\": \"7\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"name\": \"Virat Kohli\",\r\n"
			+ "      \"country\": \"India\",\r\n"
			+ "      \"role\": \"Batsman\",\r\n"
			+ "      \"price-in-crores\": \"15\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"name\": \"Glenn Maxwell\",\r\n"
			+ "      \"country\": \"Australia\",\r\n"
			+ "      \"role\": \"Batsman\",\r\n"
			+ "      \"price-in-crores\": \"11\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"name\": \"Mohammad Siraj\",\r\n"
			+ "      \"country\": \"India\",\r\n"
			+ "      \"role\": \"Bowler\",\r\n"
			+ "      \"price-in-crores\": \"7\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"name\": \"Harshal Patel\",\r\n"
			+ "      \"country\": \"India\",\r\n"
			+ "      \"role\": \"Bowler\",\r\n"
			+ "      \"price-in-crores\": \"10.75\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"name\": \"Wanindu Hasaranga\",\r\n"
			+ "      \"country\": \"Srilanka\",\r\n"
			+ "      \"role\": \"Bowler\",\r\n"
			+ "      \"price-in-crores\": \"10.75\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"name\": \"Dinesh Karthik\",\r\n"
			+ "      \"country\": \"India\",\r\n"
			+ "      \"role\": \"Wicket-keeper\",\r\n"
			+ "      \"price-in-crores\": \"5.5\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"name\": \"Shahbaz Ahmed\",\r\n"
			+ "      \"country\": \"India\",\r\n"
			+ "      \"role\": \"All-Rounder\",\r\n"
			+ "      \"price-in-crores\": \"2.4\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"name\": \"Rajat Patidar\",\r\n"
			+ "      \"country\": \"India\",\r\n"
			+ "      \"role\": \"Batsman\",\r\n"
			+ "      \"price-in-crores\": \"0.20\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"name\": \"Josh Hazlewood\",\r\n"
			+ "      \"country\": \"Australia\",\r\n"
			+ "      \"role\": \"Bowler\",\r\n"
			+ "      \"price-in-crores\": \"7.75\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"name\": \"Mahipal Lomror\",\r\n"
			+ "      \"country\": \"India\",\r\n"
			+ "      \"role\": \"Bowler\",\r\n"
			+ "      \"price-in-crores\": \"7.75\"\r\n"
			+ "    }\r\n"
			+ "  ]\r\n"
			+ "}";
	
	
	 @Test
	 public void smoketest() {
	 
	 
			/*
			 * RestAssured.baseURI="";
			 * 
			 * String response= given().body(jsonData()). when().post("Resource").
			 * then().assertThat().statusCode(200).extract().asString();
			 */
	 
	 }

	@Test
	public void GET4ForeignPlayers() throws JsonException {
		

	        JSONObject jsonObject = new JSONObject(jsonDataString);
	        List<String> list = new ArrayList<String>();
	        JSONArray jsonArray = jsonObject.getJSONArray("player");
	        System.out.println("RCB 4 Foreign players are:");
	        for (int i = 0; i < jsonArray.length(); i++) {
	            String country = jsonArray.getJSONObject(i).getString("country");
	            if(!country.equalsIgnoreCase("India"))
	            {
	                String name = jsonArray.getJSONObject(i).getString("name");
	                System.out.println(name);
	            }
	        }
	    }

	@Test
	public void GETWicketKeeper() throws JSONException {

	    JSONObject jsonObject = new JSONObject(jsonDataString);
	    List<String> list = new ArrayList<String>();
	    JSONArray jsonArray = jsonObject.getJSONArray("player");
	    System.out.println("RCB Wicket keeper details : ");
	    for (int i = 0; i < jsonArray.length(); i++) {
	        String role = jsonArray.getJSONObject(i).getString("role");
	        if(role.equalsIgnoreCase("Wicket-keeper"))
	        {
	            AssertJUnit.assertEquals("Wicket-keeper",role);
	            System.out.println(jsonArray.getJSONObject(i));
	        }
	    }
	}
	}
	


