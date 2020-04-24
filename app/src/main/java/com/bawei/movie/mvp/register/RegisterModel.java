package com.bawei.movie.mvp.register;

import com.bawei.movie.bean.RegisterBean;
import com.bawei.movie.util.ApiService;
import com.bawei.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RegisterModel implements RegisterContract.RegisterModel {
    @Override
    public void register(String nickName, String pwd, String email, String code, final RegisterCallBack registerCallBack) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiService apiService = instance.apiService();
        Observable<RegisterBean> register = apiService.register(nickName, pwd, email, code);
        register.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onNext(RegisterBean registerBean) {
                        registerCallBack.onSuccessJson(registerBean);
                    }
                    @Override
                    public void onError(Throwable e) {
                        registerCallBack.onFailurejson(e.getMessage());
                    }
                    @Override
                    public void onComplete() {}
                });
    }
}
