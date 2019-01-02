package com.example.lenovo.myapplication.model;

import android.os.Handler;
import android.text.TextUtils;

import com.example.lenovo.myapplication.api.UserApi;
import com.example.lenovo.myapplication.contract.IShowContract;
import com.example.lenovo.myapplication.entity.User;
import com.example.lenovo.myapplication.net.OkhttpCallback;
import com.example.lenovo.myapplication.net.OkhttpUtils;
import com.example.lenovo.myapplication.net.RequestCallback;
import com.google.gson.Gson;

import java.util.HashMap;

public class ShowModel implements IShowContract.IShowModel {
    private Handler handler=new Handler();
    @Override
    public void show(HashMap<String, String> params, final RequestCallback requestCallback) {
        OkhttpUtils.getmInstance().doPost(UserApi.User_SHOW, params, new OkhttpCallback() {
            @Override
            public void onFailUre(String msg) {
                if (requestCallback!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            requestCallback.onFailUre("网络异常，请稍后再试");
                        }
                    });
                }
            }

            @Override
            public void onSuccess(String result) {
                if (!TextUtils.isEmpty(result)){
                    resultCall(result,requestCallback);
                }
            }
        });
    }

    private void resultCall(String result, final RequestCallback requestCallback) {
        final User user = new Gson().fromJson(result, User.class);
        if (requestCallback!=null){
            handler.post(new Runnable() {
                @Override
                public void run() {
                    requestCallback.onSuccess(user);
                }
            });
        }
    }
}
