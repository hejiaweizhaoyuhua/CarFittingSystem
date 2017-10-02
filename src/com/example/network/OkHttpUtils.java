package com.example.network;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OkHttpUtils {
	private static OkHttpClient client = new OkHttpClient();
	
	/**
	 * get«Î«Û
	 * @param url
	 * @param map
	 * @param callback
	 */
	public static void get(String url, HashMap<String, String> map, 
			NetCallback callback) {
		get(StringUtils.convertUrl(url, map), callback);
	}
	
	/**
	 * get«Î«Û
	 * @param url
	 * @param callback
	 */
	public static void get(final String url, final NetCallback callback){
		System.out.println("url=" + url);
		
		Request request = new Request.Builder()
		.url(url)
		.build();
	
		try {
			client.newCall(request).enqueue(callback);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * post«Î«Û
	 * @param url
	 * @param map
	 * @param callback
	 */
	public static void post(final String url, 
			final HashMap<String, String> map, 
			final NetCallback callback){
		
			FormBody.Builder builder = new FormBody.Builder();
			Iterator iterator = map.entrySet().iterator();
			while (iterator.hasNext()){
				Map.Entry<String, String> entry = 
						(Map.Entry) iterator.next();
				String name = entry.getKey();
				String value = entry.getValue();
				builder.add(name, value);
			}
			
			RequestBody requestBody = builder.build();
			
			Request request = new Request.Builder()
					.url(url)
					.post(requestBody)
					.build();
			
			client.newCall(request).enqueue(callback);
	}
	
	public static void download(){
		
	}
}
