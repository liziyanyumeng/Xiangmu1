package com.bawei.movie.mvp.findmovie;

import com.bawei.movie.bean.FindModelBean;
import com.bawei.movie.util.ApiService;
import com.bawei.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FindMovieModel implements FindMovieContract.FindMovieModel {
    @Override
    public void findmovie(int page, int count, final FindMovieCallBack findMovieCallBack) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiService apiService = instance.apiService();
        Observable<FindModelBean> findmovie = apiService.findmovie(page, count);
        findmovie.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindModelBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onNext(FindModelBean findModelBean) {
                        findMovieCallBack.onSuccessJson(findModelBean);
                    }
                    @Override
                    public void onError(Throwable e) {
                        findMovieCallBack.onFailureJson(e.getMessage());
                    }
                    @Override
                    public void onComplete() {}
                });
    }
}
