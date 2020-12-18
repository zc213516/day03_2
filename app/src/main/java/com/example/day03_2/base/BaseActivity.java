package com.example.day03_2.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {
    public T presenter;
    @Override
    //我加了一行新东西


    //我再ddd分值中添加了遗憾
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        if(presenter!=null){
            presenter=getPresenter();
            presenter.aVoid(this);
        }
        initView();
        initData();
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract T getPresenter();

    protected abstract int getLayoutID();
}
