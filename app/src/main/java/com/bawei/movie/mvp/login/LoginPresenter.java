package com.bawei.movie.mvp.login;

import com.bawei.movie.base.IBasePresenter;
import com.bawei.movie.bean.LoginBean;

public class LoginPresenter extends IBasePresenter<LoginContract.LoginView> implements LoginContract.LoginPresenter {

    private LoginModel loginModel;

    @Override
    public void initModel() {
        loginModel = new LoginModel();
    }
    @Override
    public void login(String email, String pwd) {
        loginModel.login(email, pwd, new LoginContract.LoginModel.LoginCallBack() {
            @Override
            public void onSuccessJson(LoginBean loginBean) {
                view.onSuccessJson(loginBean);
            }
            @Override
            public void onFailureJson(String msg) {
                view.onFailureJson(msg);
            }
        });
    }
}
