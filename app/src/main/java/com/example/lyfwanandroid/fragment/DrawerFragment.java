package com.example.lyfwanandroid.fragment;

import android.widget.TextView;

import com.example.lib.core.mvp.BaseFragment;
import com.example.lib.core.mvp.MvpPresenter;
import com.example.lyfwanandroid.R;

public class DrawerFragment extends BaseFragment {
    @Override
    protected int getLayoutRes() {
       return R.layout.fragment_drawer;
    }

    @Override
    protected MvpPresenter initPresenter() {
        return null;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initView() {

    }
}
