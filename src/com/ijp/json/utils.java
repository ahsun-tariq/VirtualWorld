package com.ijp.json;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

public class utils {

	private static ObjectMapper mapper;
	
	static{
		mapper = new ObjectMapper();
	}
	

	public static String getJSONString(String filepath){
		Scanner jsonScan;
		String input = FileHandler.getStream(filepath);
		
//		String JSON = input.useDelimiter("\\z").next();
//		jsonScan.close();
//		System.out.println(input);
		return input;
		
	}
	
	public static JSONObject getObject(String filepath){
		try{
		return new JSONObject(getJSONString(filepath));
		}
		catch(Exception e){
			System.out.println("error");
			e.printStackTrace();
			
		}
		return null;
	}
	
	public static boolean checkObject(JSONObject obj, String key){
		Object object;
		try{
			object = obj;
		}
		catch(Exception e){
			return false;
		}
		return object!=null;
	}
	
	
}