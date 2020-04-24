package com.bawei.movie.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<p extends IBasePresenter> extends AppCompatActivity implements IBaseView {

    private int i;
    public p p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        i = initLayoutId();
        setContentView(i);
        p = initModel();
        //判空
        if (p!=null) {
            //绑定视图
            p.attachView(this);
        }
        initView();
        initListener();
        initData();
    }

    public abstract int initLayoutId();
    public abstract p initModel();
    public abstract void initView();
    public abstract void initListener();
    public abstract void initData();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (p!=null) {
            p.detachView();
        }
    }
}
