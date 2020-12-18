package com.example.day03_2.utils.net;

public interface ResultCallback<T>{
    void onSuccess(T t);
    void onFail(String msg);
}
