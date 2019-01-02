package com.example.lenovo.myapplication.contract;

import com.example.lenovo.myapplication.entity.User;
import com.example.lenovo.myapplication.net.RequestCallback;

import java.util.HashMap;

public interface IShowContract {
    public abstract class ShowPresenter{
        public abstract void show(HashMap<String,String> params);
    }
    interface IShowModel{
        void show(HashMap<String,String> params, RequestCallback requestCallback);
    }
    interface IShowView{
        void onFailUre(String msg);
        void onSuccess(User user);
        void onSuccessMsg(String msg);
    }
}
