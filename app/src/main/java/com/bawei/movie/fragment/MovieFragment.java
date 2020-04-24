package com.bawei.movie.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.movie.R;

public class MovieFragment extends Fragment {
    private RecyclerView hotMovieRecycler;
    private RecyclerView willMovieRecycler;
    private View inflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.moviefragment, container, false);
        return inflate;
    }
    private void initView() {
        hotMovieRecycler = (RecyclerView) inflate.findViewById(R.id.hot_movie_recycler);
        willMovieRecycler = (RecyclerView) inflate.findViewById(R.id.will_movie_recycler);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        hotMovieRecycler.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(RecyclerView.VERTICAL);
        willMovieRecycler.setLayoutManager(linearLayoutManager1);
    }
}
