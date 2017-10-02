package com.example.network;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StringUtils {
	public static String convertUrl(String url, 
			HashMap<String, String> map){
		String result = url + "?";
		
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()){
			Map.Entry<String, String> entry = (Map.Entry) iterator.next();
			String key = entry.getKey();
			String value = entry.getValue();
			result = result + key + "=" + value;
			if (iterator.hasNext()){
				result = result + "&";
			}
		}
		
		return result;
	}
}
