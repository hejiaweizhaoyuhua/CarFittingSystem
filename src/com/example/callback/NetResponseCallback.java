package com.example.callback;

import java.io.IOException;

import okhttp3.Call;

public interface NetResponseCallback {
	/**
	 * ���óɹ�
	 * @param result
	 */
	void onResponseSuccess(String result);
	/**
	 * ���ò��ɹ�
	 * @param result
	 */
	void onResponseFail(String result, String failReason);
	/**
	 * �ص�ʧ��
	 * @param arg0
	 * @param arg1
	 */
	void onFail(Call arg0, IOException arg1);
}
