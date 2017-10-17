package com.example.network;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.attribute.DosFileAttributes;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.example.callback.FileDownloadCallback;
import com.example.callback.NetCallback;
import com.example.constants.PathConstants;
import com.example.utils.MD5Utils;
import com.example.utils.StringUtils;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtils {
	private static OkHttpClient client = new OkHttpClient();
	
	/**
	 * get请求
	 * @param url
	 * @param map
	 * @param callback
	 */
	public static void get(String url, HashMap<String, String> map, 
			NetCallback callback) {
		get(StringUtils.convertUrl(url, map), callback);
	}
	
	/**
	 * get请求
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
	 * post请求
	 * @param url
	 * @param map
	 * @param callback
	 */
	public static void post(final String url, 
			final HashMap<String, String> map, 
			final NetCallback callback){
		System.out.println("url=" + url);
		
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
	
	/**
	 * 文件下载，保存到指定路径
	 * @param url
	 * @param callback
	 */
	public static void download(String url, 
			final FileDownloadCallback callback){
		System.out.println("picture url=" + url);
		
		final String fileName = MD5Utils.EncodeByMD5(url);
		File file1 = new File(PathConstants.PIC_PATH);
		if (file1 != null && !file1.exists()){
			file1.mkdirs();
		}
		final File file2 = new File(PathConstants.PIC_PATH + 
				fileName + ".png");
		if (file2 != null && file2.exists()){
			System.out.println("文件已存在！");
			callback.downloadSuccess(file2.getPath());
			return;
		}
		
		Request request = new Request.Builder()
		.url(url)
		.build();
		
		client.newCall(request).enqueue(new Callback() {
			
			@Override
			public void onResponse(Call arg0, Response arg1) throws IOException {
				InputStream is = null;
				byte[] buf = new byte[2048];
				int len = 0;
				FileOutputStream fos = null;
				try{
					long total = arg1.body().contentLength();
					long current = 0;
					is = arg1.body().byteStream();
					fos = new FileOutputStream(file2);
					while((len = is.read(buf)) != -1){
						current += len;
						fos.write(buf, 0, len);
					}
					fos.flush();
					callback.downloadSuccess(file2.getPath());
				} catch (Exception e){
					e.printStackTrace();
				} finally {
					try{
						if (is != null)
							is.close();
						if (fos != null)
							fos.close();
					} catch (Exception e){
						e.printStackTrace();
					}
				}
			}
			
			@Override
			public void onFailure(Call arg0, IOException arg1) {
				callback.downloadFail(arg1.toString());
				arg1.printStackTrace();
			}
		});
	}
}
