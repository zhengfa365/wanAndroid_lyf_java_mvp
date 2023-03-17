package com.example.lyfwanandroid.module.main.activity;

import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.example.lib.core.adapter.SimpleFragmentPagerAdapter;
import com.example.lib.core.mvp.BaseActivity;
import com.example.lib.core.mvp.MvpPresenter;
import com.example.lyfwanandroid.R;
import com.example.lyfwanandroid.module.main.fragment.DrawerFragment;
import com.example.lyfwanandroid.module.main.fragment.MainFragment;

import butterknife.BindView;

public class NewMainActivity extends BaseActivity {
    @BindView(R.id.vp)
    ViewPager vp;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_new_main;
    }

    @Override
    protected MvpPresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        vp.setOffscreenPageLimit(1);
        SimpleFragmentPagerAdapter simpleFragmentPagerAdapter=new SimpleFragmentPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(simpleFragmentPagerAdapter);
        simpleFragmentPagerAdapter.setFragmentList(new DrawerFragment(),new MainFragment());
        vp.setCurrentItem(1);
    }

    @Override
    protected void loadData() {

    }
}
