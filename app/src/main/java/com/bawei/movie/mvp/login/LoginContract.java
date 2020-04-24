package com.bawei.movie.mvp.login;

import com.bawei.movie.base.IBaseView;
import com.bawei.movie.bean.LoginBean;

public interface LoginContract {
    interface LoginView extends IBaseView{
        void onSuccessJson(LoginBean loginBean);
        void onFailureJson(String msg);
    }
    interface LoginModel{
        void login(String email,String pwd,LoginCallBack loginCallBack);
        interface LoginCallBack{
            void onSuccessJson(LoginBean loginBean);
            void onFailureJson(String msg);
        }
    }
    interface LoginPresenter{
        void login(String email,String pwd);
    }
}
