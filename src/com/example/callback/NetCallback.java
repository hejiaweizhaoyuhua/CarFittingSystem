package com.example.callback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class NetCallback implements Callback{

	@Override
	public void onFailure(Call arg0, IOException arg1) {
		arg1.printStackTrace();
	}

	@Override
	public void onResponse(Call arg0, Response arg1) throws IOException {
		System.out.println("result=" + arg1.body().string());
	}
	
}
