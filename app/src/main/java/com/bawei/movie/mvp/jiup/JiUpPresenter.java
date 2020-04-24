package com.bawei.movie.mvp.jiup;

import com.bawei.movie.base.IBasePresenter;
import com.bawei.movie.bean.JiUpBean;

public class JiUpPresenter extends IBasePresenter<JiUpContract.JiUpView> implements JiUpContract.JiUpPresenter {

    private JiUpModel jiUpModel;

    @Override
    public void initModel() {
        jiUpModel = new JiUpModel();
    }
    @Override
    public void jiup(int page, int count) {
        jiUpModel.jiup(page, count, new JiUpContract.JiUpModel.JiUpCallBack() {
            @Override
            public void onSuccessJson(JiUpBean jiUpBean) {
                view.onSuccessJson(jiUpBean);
            }
            @Override
            public void onFailureJson(String msg) {
                view.onFailureJson(msg);
            }
        });
    }
}
