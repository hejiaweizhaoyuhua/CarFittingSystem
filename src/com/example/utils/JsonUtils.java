package com.example.utils;

import com.google.gson.Gson;

public class JsonUtils {
	/**
	 * ����Json����
	 * @param json
	 * @param classOfT
	 * @return
	 */
	public static <T> T formJson(String json, Class<T> classOfT){
		Gson gson = new Gson();
		return gson.fromJson(json, classOfT);
	}
	
	/**
	 * ����Json����
	 * @param t
	 * @return
	 */
	public static <T> String toJson(T t){
		Gson gson = new Gson();
		return gson.toJson(t);
	}
}
