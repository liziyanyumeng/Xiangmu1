package com.bawei.movie.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.movie.R;
import com.bawei.movie.base.BaseActivity;
import com.bawei.movie.bean.LoginBean;
import com.bawei.movie.mvp.login.LoginContract;
import com.bawei.movie.mvp.login.LoginPresenter;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.LoginView {

    private android.widget.EditText etEmail;
    private android.widget.EditText etPwd;
    private android.widget.Button btnLogin;
    private android.widget.ImageView imageWx;
    private String email;
    private String pwd;
    private android.widget.TextView textRegister;

    @Override
    public int initLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginPresenter initModel() {
        return new LoginPresenter();
    }

    @Override
    public void initView() {
        etEmail = (EditText) findViewById(R.id.et_email);
        etPwd = (EditText) findViewById(R.id.et_pwd);
        btnLogin = (Button) findViewById(R.id.btn_login);
        imageWx = (ImageView) findViewById(R.id.image_wx);
        textRegister = (TextView) findViewById(R.id.text_register);
    }
    @Override
    public void initListener() {
        //点击登录按钮
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = etEmail.getText().toString();
                pwd = etPwd.getText().toString();
                p.login(email,pwd);
            }
        });
        //点击注册
        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到注册页面
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //点击微信头像进行跳转到微信注册
        imageWx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public void initData() {}

    @Override
    public void onSuccessJson(LoginBean loginBean) {
        Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onFailureJson(String msg) {
        Toast.makeText(this, "失败"+msg, Toast.LENGTH_SHORT).show();
    }
}
