package com.example.day03_2.model;

import com.example.day03_2.contract.MainContract;
import com.example.day03_2.utils.net.ResultCallback;
import com.example.day03_2.utils.net.RetrofitUtils;

public class MainModel implements MainContract.IMainModel {
    private MainContract.IMainPresenter presenter;

    public MainModel(MainContract.IMainPresenter presenter) {

        this.presenter = presenter;
    }

    @Override
    public void getLoginData(String url, ResultCallback callback) {
        presenter.loginResult("登录成功");
        RetrofitUtils.getInstance().get(url,callback);
    }
}
