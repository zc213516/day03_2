package com.example.day03_2.utils.net;

import java.util.HashMap;

public interface NetWorkInterface {
    <T> void get(String url,ResultCallback<T> callback);
    <T> void post(String url,ResultCallback<T> callback);
    <T> void post(String url, HashMap<String,String> map, ResultCallback<T> callback);
}
