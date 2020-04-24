package com.bawei.movie.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.movie.R;
import com.bawei.movie.base.BaseActivity;
import com.bawei.movie.bean.RegisterBean;
import com.bawei.movie.mvp.register.RegisterContract;
import com.bawei.movie.mvp.register.RegisterPresenter;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.RegisterView {

    private android.widget.EditText etName;
    private android.widget.EditText etEmail;
    private android.widget.EditText etPwd;
    private android.widget.EditText etCode;
    private android.widget.TextView textLogin;
    private android.widget.Button btnLogin;
    private String name;
    private String email;
    private String pwd;
    private Button btnCode;
    private String code;

    @Override
    public int initLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public RegisterPresenter initModel() {
        return new RegisterPresenter();
    }

    @Override
    public void initView() {
        etName = (EditText) findViewById(R.id.et_name);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPwd = (EditText) findViewById(R.id.et_pwd);
        etCode = (EditText) findViewById(R.id.et_code);
        textLogin = (TextView) findViewById(R.id.text_login);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnCode = (Button) findViewById(R.id.btn_code);
    }

    @Override
    public void initListener() {
        //设置点击text
        textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //设置点击按钮的点击事件
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etName.getText().toString();
                email = etEmail.getText().toString();
                pwd = etPwd.getText().toString();
                //点击获取验证码
                btnCode.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
                code = etCode.getText().toString();
                p.register(name,pwd,email,"523273");
            }
        });

    }

    @Override
    public void initData() {}

    @Override
    public void onSuccessJson(RegisterBean registerBean) {
        Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onFailurejson(String msg) {
        Toast.makeText(this, "失败"+msg, Toast.LENGTH_SHORT).show();
    }
}
