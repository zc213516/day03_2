package com.example.day03_2.presenter;

import com.example.day03_2.base.BasePresenter;
import com.example.day03_2.base.BaseView;
import com.example.day03_2.ben.UserBean;
import com.example.day03_2.contract.MainContract;
import com.example.day03_2.model.MainModel;
import com.example.day03_2.utils.net.ResultCallback;
import com.example.day03_2.view.MainActivity;

public class MainPresenter extends BasePresenter<MainContract.IMainView> implements MainContract.IMainPresenter {
    private MainContract.IMainView mainView;
    private MainContract.IMainModel mainModel;

    public MainPresenter(MainContract.IMainView mainView) {
        this.mainView = mainView;
        mainModel = new MainModel(this);
    }
    @Override
    public void login(String name, String password) {
       mainModel.getLoginData("", new ResultCallback<UserBean>() {
           @Override
           public void onSuccess(UserBean userBean) {
               iView.getLoginData(userBean);
           }

           @Override
           public void onFail(String msg) {

           }
       });
    }

    @Override
    public void loginResult(String result) {

    }
}
