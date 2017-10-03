package com.example.callback;

public interface FileDownloadCallback {
	/**
	 * 下载成功回调
	 * @param path
	 */
	void downloadSuccess(String path);
	
	/**
	 * 下载失败回调
	 */
	void downloadFail(String error);
}
