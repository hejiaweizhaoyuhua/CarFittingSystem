package com.example.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StringUtils {
	/**
	 * urlƴ��
	 * @param url
	 * @param map
	 * @return
	 */
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
	
	public static boolean isNull(String str){
		if (str == null || str.length() == 0 || str.equals(" ")) {
			return true;
		}
		
		return false;
	}
}
