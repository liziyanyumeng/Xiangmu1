package com.bawei.movie.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<f extends IBasePresenter> extends Fragment implements IBaseView {

    private int i;
    private View inflate;
    public f f;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        i = initLayoutId();
        inflate = inflater.inflate(i, container, false);
        f = initModel();
        if (f!=null) {
            //绑定视图
            f.attachView(this);
        }
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(inflate);
        initListener();
        initData();
    }
    public abstract int initLayoutId();
    public abstract f initModel();
    public abstract void initView(View inflate);
    public abstract void initListener();
    public abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (f!=null) {
            f.detachView();
        }
    }
}
