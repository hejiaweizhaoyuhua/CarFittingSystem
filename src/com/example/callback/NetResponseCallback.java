package com.example.callback;

import java.io.IOException;

import okhttp3.Call;

public interface NetResponseCallback {
	/**
	 * 调用成功
	 * @param result
	 */
	void onResponseSuccess(String result);
	/**
	 * 调用不成功
	 * @param result
	 */
	void onResponseFail(String result, String failReason);
	/**
	 * 回调失败
	 * @param arg0
	 * @param arg1
	 */
	void onFail(Call arg0, IOException arg1);
}
