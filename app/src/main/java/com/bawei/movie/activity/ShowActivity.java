package com.bawei.movie.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.movie.R;
import com.bawei.movie.fragment.CinemaFragment;
import com.bawei.movie.fragment.MineFragment;
import com.bawei.movie.fragment.MovieFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private TabLayout tablayout;
    private ArrayList<String> strings = new ArrayList<>();
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tablayout = (TabLayout) findViewById(R.id.tablayout);

        strings.add("电影");
        strings.add("影院");
        strings.add("我的");

        fragments.add(new MovieFragment());
        fragments.add(new CinemaFragment());
        fragments.add(new MineFragment());

        tablayout.setupWithViewPager(viewpager);
        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }
            @Override
            public int getCount() {
                return fragments.size();
            }
            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return strings.get(position);
            }
        });

    }
}
