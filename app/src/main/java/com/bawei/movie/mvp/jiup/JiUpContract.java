package com.bawei.movie.mvp.jiup;

import com.bawei.movie.base.IBaseView;
import com.bawei.movie.bean.JiUpBean;

public interface JiUpContract {
    interface JiUpView extends IBaseView{
        void onSuccessJson(JiUpBean jiUpBean);
        void onFailureJson(String msg);
    }
    interface JiUpModel{
        void jiup(int page,int count,JiUpCallBack jiUpCallBack);
        interface JiUpCallBack{
            void onSuccessJson(JiUpBean jiUpBean);
            void onFailureJson(String msg);
        }
    }
    interface JiUpPresenter{
        void jiup(int page,int count);
    }
}
