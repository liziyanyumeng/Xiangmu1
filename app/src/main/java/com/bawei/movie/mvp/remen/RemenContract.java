package com.bawei.movie.mvp.remen;

import com.bawei.movie.base.IBaseView;
import com.bawei.movie.bean.RemenBean;

public interface RemenContract {
    interface RemenView extends IBaseView{
        void onSuccessJson(RemenBean remenBean);
        void onFailureJson(String msg);
    }
    interface RemenModel{
        void remen(int page,int count,RemenCallBack remenCallBack);
        interface RemenCallBack{
            void onSuccessJson(RemenBean remenBean);
            void onFailureJson(String msg);
        }
    }
    interface RemenPresenter{
        void remen(int page,int count);
    }
}
