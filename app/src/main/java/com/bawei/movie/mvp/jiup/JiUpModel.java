package com.bawei.movie.mvp.jiup;

import com.bawei.movie.bean.JiUpBean;
import com.bawei.movie.util.ApiService;
import com.bawei.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class JiUpModel implements JiUpContract.JiUpModel {
    @Override
    public void jiup(int page, int count, final JiUpCallBack jiUpCallBack) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiService apiService = instance.apiService();
        Observable<JiUpBean> jiUp = apiService.getJiUp(page, count);
        jiUp.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JiUpBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onNext(JiUpBean jiUpBean) {
                        jiUpCallBack.onSuccessJson(jiUpBean);
                    }
                    @Override
                    public void onError(Throwable e) {
                        jiUpCallBack.onFailureJson(e.getMessage());
                    }
                    @Override
                    public void onComplete() {}
                });
    }
}
