package com.ijp.json;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileHandler {

	public static String getStream(String filepath){
		try{
			
			InputStream input = FileHandler.class.getClassLoader().getResourceAsStream(filepath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			String line = reader.readLine();
			StringBuilder stringBuilder = new StringBuilder();
			
			while(line!=null){
				
				stringBuilder.append(line).append("\n");
				line=reader.readLine();
			}
			
			String file = stringBuilder.toString();
			return file;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}