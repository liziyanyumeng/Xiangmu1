package com.bawei.movie.mvp.remen;

import com.bawei.movie.bean.RemenBean;
import com.bawei.movie.util.ApiService;
import com.bawei.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RemenModel implements RemenContract.RemenModel {
    @Override
    public void remen(int page, int count, final RemenCallBack remenCallBack) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiService apiService = instance.apiService();
        Observable<RemenBean> remen = apiService.getRemen(page, count);
        remen.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RemenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onNext(RemenBean remenBean) {
                        remenCallBack.onSuccessJson(remenBean);
                    }
                    @Override
                    public void onError(Throwable e) {
                        remenCallBack.onFailureJson(e.getMessage());
                    }
                    @Override
                    public void onComplete() {}
                });
    }
}
