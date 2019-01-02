package com.example.lenovo.myapplication.net;

import com.example.lenovo.myapplication.entity.User;

public interface RequestCallback {
    void onFailUre(String msg);
    void onSuccess(User user);
    void onSuccessMsg(String msg);
}
