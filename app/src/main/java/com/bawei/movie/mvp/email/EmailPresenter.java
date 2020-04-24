package com.bawei.movie.mvp.email;

import com.bawei.movie.base.IBasePresenter;
import com.bawei.movie.bean.EmailBean;

public class EmailPresenter extends IBasePresenter<EmailContract.EmailView> implements EmailContract.EmailPresenter {

    private EmailModel emailModel;

    @Override
    public void initModel() {
        emailModel = new EmailModel();
    }
    @Override
    public void email(String email) {
        emailModel.email(email, new EmailContract.EmailModel.EmailCallBack() {
            @Override
            public void onSuccessJson(EmailBean emailBean) {
                view.onSuccessJson(emailBean);
            }
            @Override
            public void onFailureJson(String msg) {
                view.onFailureJson(msg);
            }
        });
    }
}
