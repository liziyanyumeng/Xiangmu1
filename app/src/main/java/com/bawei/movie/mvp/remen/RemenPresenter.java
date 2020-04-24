package com.bawei.movie.mvp.remen;

import com.bawei.movie.base.IBasePresenter;
import com.bawei.movie.bean.RemenBean;

public class RemenPresenter extends IBasePresenter<RemenContract.RemenView> implements RemenContract.RemenPresenter {

    private RemenModel remenModel;

    @Override
    public void initModel() {
        remenModel = new RemenModel();
    }
    @Override
    public void remen(int page, int count) {
        remenModel.remen(page, count, new RemenContract.RemenModel.RemenCallBack() {
            @Override
            public void onSuccessJson(RemenBean remenBean) {
                view.onSuccessJson(remenBean);
            }
            @Override
            public void onFailureJson(String msg) {
                view.onFailureJson(msg);
            }
        });
    }
}
