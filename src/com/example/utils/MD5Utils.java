package com.example.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Utils {
	public static String EncodeByMD5(String str){
		String result = null;
		
		try{
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(str.getBytes());
			result = new BigInteger(1, digest.digest()).toString();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
}
