package com.example.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {
	/**
	 * д�����ݵ��ļ���
	 * @param path �����·��
	 * @param fileName �ļ�����
	 * @param content �ļ�����
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
	 * ��ȡ�ļ�����
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
