package com.bawei.movie.mvp.register;

import com.bawei.movie.base.IBasePresenter;
import com.bawei.movie.bean.RegisterBean;

public class RegisterPresenter extends IBasePresenter<RegisterContract.RegisterView> implements RegisterContract.RegisterPresenter {

    private RegisterModel registerModel;

    @Override
    public void initModel() {
        registerModel = new RegisterModel();
    }
    @Override
    public void register(String nickName, String pwd, String email, String code) {
        registerModel.register(nickName, pwd, email, code, new RegisterContract.RegisterModel.RegisterCallBack() {
            @Override
            public void onSuccessJson(RegisterBean registerBean) {
                view.onSuccessJson(registerBean);
            }
            @Override
            public void onFailurejson(String msg) {
                view.onFailurejson(msg);
            }
        });
    }
}
