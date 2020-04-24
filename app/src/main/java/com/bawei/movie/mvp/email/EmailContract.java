package com.bawei.movie.mvp.email;

import com.bawei.movie.base.IBaseView;
import com.bawei.movie.bean.EmailBean;

public interface EmailContract {
    interface EmailView extends IBaseView{
        void onSuccessJson(EmailBean emailBean);
        void onFailureJson(String msg);
    }
    interface EmailModel{
        void email(String email,EmailCallBack emailCallBack);
        interface EmailCallBack{
            void onSuccessJson(EmailBean emailBean);
            void onFailureJson(String msg);
        }
    }
    interface EmailPresenter{
        void email(String email);
    }
}
