package com.bawei.movie.base;

public abstract class IBasePresenter<View> {
    public View view;
    public IBasePresenter() {
        initModel();
    }

    public void attachView(View view){
        this.view = view;
    }
    public void detachView(){
        //判断
        if (view != null){
            view = null;
        }
    }
    public abstract void initModel();
}
