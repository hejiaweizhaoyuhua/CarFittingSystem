package com.example.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {
	/**
	 * 写入数据到文件中
	 * @param path 存入的路径
	 * @param fileName 文件名称
	 * @param content 文件内容
	 */
	public static boolean writeToFile(String path, String fileName, 
			String content) throws IOException{
		
		File pathFile = new File(path);
		if (pathFile != null && !pathFile.exists()) {
			pathFile.mkdirs();
		}
		
		File file = new File(path, fileName);
		if (file != null && !file.exists() && file.isFile()){
			file.createNewFile();
		}
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			byte [] contentInBytes = content.getBytes();
			fos.write(contentInBytes);
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 读取文件数据
	 * @param path
	 * @param fileName
	 * @return
	 */
	public static String readFile(String path, String fileName)
			throws Exception{
		String result = "";
		
		File file = new File(path, fileName);
		if (file != null && !file.exists()) {
			return null;
		}
		
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		try {
			String read = null;
			while((read = bufferedReader.readLine()) != null){
				result = result + read;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
			if (fileReader != null) {
				fileReader.close();
			}
		}
		
		return result;
	}
}
