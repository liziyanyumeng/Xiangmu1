package com.bawei.movie.mvp.findmovie;

import com.bawei.movie.base.IBasePresenter;
import com.bawei.movie.bean.FindModelBean;

public class FindMoviePresenter extends IBasePresenter<FindMovieContract.FindMovieView> implements FindMovieContract.FindMoviePresenter {

    private FindMovieModel findMovieModel;

    @Override
    public void initModel() {
        findMovieModel = new FindMovieModel();
    }
    @Override
    public void findmovie(int page, int count) {
        findMovieModel.findmovie(page, count, new FindMovieContract.FindMovieModel.FindMovieCallBack() {
            @Override
            public void onSuccessJson(FindModelBean findModelBean) {
                view.onSuccessJson(findModelBean);
            }
            @Override
            public void onFailureJson(String msg) {
                view.onFailureJson(msg);
            }
        });
    }
}
