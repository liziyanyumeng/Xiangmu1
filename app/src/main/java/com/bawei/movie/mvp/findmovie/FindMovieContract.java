package com.bawei.movie.mvp.findmovie;

import com.bawei.movie.base.IBaseView;
import com.bawei.movie.bean.FindModelBean;

public interface FindMovieContract {
    interface FindMovieView extends IBaseView{
        void onSuccessJson(FindModelBean findModelBean);
        void onFailureJson(String msg);
    }
    interface FindMovieModel{
        void findmovie(int page,int count,FindMovieCallBack findMovieCallBack);
        interface FindMovieCallBack{
            void onSuccessJson(FindModelBean findModelBean);
            void onFailureJson(String msg);
        }
    }
    interface FindMoviePresenter{
        void findmovie(int page,int count);
    }
}
