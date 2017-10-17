package com.example.callback;

import java.io.IOException;

import com.example.entity.respone.BaseResponeEntity;
import com.example.utils.JsonUtils;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public abstract class NetCallback implements 
	Callback, NetResponseCallback{

	@Override
	public void onFailure(Call arg0, IOException arg1) {
		onFail(arg0, arg1);
		arg1.printStackTrace();
	}

	@Override
	public void onResponse(Call arg0, Response arg1) throws IOException {
		String result = arg1.body().string();
		System.out.println("result=" + result);
		BaseResponeEntity entity = JsonUtils.formJson(result, 
				BaseResponeEntity.class);
		if (entity.getCode() == 0) {
			onResponseSuccess(result);
		} else if (entity.getCode() == 3001){
			onResponseFail(result, "数据库连接失败");
		} else if (entity.getCode() == 4001 || entity.getCode() == 4002){
			onResponseFail(result, entity.getMessage());
		}
	}
	
}
