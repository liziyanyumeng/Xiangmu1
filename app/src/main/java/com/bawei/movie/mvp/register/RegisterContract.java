package com.bawei.movie.mvp.register;

import com.bawei.movie.base.IBaseView;
import com.bawei.movie.bean.RegisterBean;

//注册
public interface RegisterContract {
    interface RegisterView extends IBaseView{
        void onSuccessJson(RegisterBean registerBean);
        void onFailurejson(String msg);
    }
    interface RegisterModel{
        void register(String nickName,String pwd,String email,String code,RegisterCallBack registerCallBack);
        interface RegisterCallBack{
            void onSuccessJson(RegisterBean registerBean);
            void onFailurejson(String msg);
        }
    }
    interface RegisterPresenter{
        void register(String nickName,String pwd,String email,String code);
    }
}
