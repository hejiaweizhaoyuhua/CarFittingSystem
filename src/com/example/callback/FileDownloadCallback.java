package com.example.callback;

public interface FileDownloadCallback {
	/**
	 * ���سɹ��ص�
	 * @param path
	 */
	void downloadSuccess(String path);
	
	/**
	 * ����ʧ�ܻص�
	 */
	void downloadFail(String error);
}
