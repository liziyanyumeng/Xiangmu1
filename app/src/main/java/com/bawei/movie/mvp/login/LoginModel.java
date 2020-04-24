package com.bawei.movie.mvp.login;

import com.bawei.movie.bean.LoginBean;
import com.bawei.movie.util.ApiService;
import com.bawei.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginModel implements LoginContract.LoginModel {
    @Override
    public void login(String email, String pwd, final LoginCallBack loginCallBack) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiService apiService = instance.apiService();
        final Observable<LoginBean> login = apiService.login(email, pwd);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onNext(LoginBean loginBean) {
                        loginCallBack.onSuccessJson(loginBean);
                    }
                    @Override
                    public void onError(Throwable e) {
                        loginCallBack.onFailureJson(e.getMessage());
                    }
                    @Override
                    public void onComplete() {}
                });
    }
}
