package com.example.day03_2.contract;

import com.example.day03_2.base.BaseView;
import com.example.day03_2.ben.UserBean;
import com.example.day03_2.utils.net.ResultCallback;

public class MainContract {

    public interface IMainView extends BaseView {
        String getUserName();
        String getPassWord();
        void getLoginData(UserBean userBean);
    }

    public interface IMainPresenter{
        void login(String name,String password);
        void loginResult(String result);
    }

    public interface IMainModel{
      <T>  void getLoginData(String url, ResultCallback<T>  callback);
    }
}
