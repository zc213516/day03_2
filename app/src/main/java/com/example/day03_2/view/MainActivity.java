package com.example.day03_2.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.day03_2.R;
import com.example.day03_2.base.BaseActivity;
import com.example.day03_2.ben.UserBean;
import com.example.day03_2.contract.MainContract;
import com.example.day03_2.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.IMainView {

    private EditText editTextTextPersonName;
    private EditText editTextTextPassword;
    private Button button;
    @Override
    protected void initView() {
        editTextTextPersonName = (EditText) findViewById(R.id.editTextTextPersonName);
        editTextTextPassword = (EditText) findViewById(R.id.editTextTextPassword);
        button = (Button) findViewById(R.id.button);
    }

    @Override
    protected void initData() {
        presenter.login(getUserName(),getPassWord());
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public String getUserName() {
        return editTextTextPersonName.getText().toString();
    }

    @Override
    public String getPassWord() {
        return editTextTextPassword.getText().toString();
    }

    @Override
    public void getLoginData(UserBean userBean) {

    }


    public void loginButton(View view) {
        if (!TextUtils.isEmpty(getUserName())&&!TextUtils.isEmpty(getPassWord())){
            presenter.login(getUserName(),getPassWord());
        }
    }
}