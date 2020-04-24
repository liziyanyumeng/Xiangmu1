package com.bawei.movie.mvp.email;

import com.bawei.movie.bean.EmailBean;
import com.bawei.movie.util.ApiService;
import com.bawei.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class EmailModel implements EmailContract.EmailModel {
    @Override
    public void email(String email, final EmailCallBack emailCallBack) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiService apiService = instance.apiService();
        Observable<EmailBean> code = apiService.code(email);
        code.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EmailBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onNext(EmailBean emailBean) {
                        emailCallBack.onSuccessJson(emailBean);
                    }
                    @Override
                    public void onError(Throwable e) {
                        emailCallBack.onFailureJson(e.getMessage());
                    }
                    @Override
                    public void onComplete() {}
                });
    }
}
