package com.example.day03_2.base;

public class BasePresenter<V extends BaseView>{


    public V iView;

    public void aVoid(V v){
        iView = v;
    }
}
