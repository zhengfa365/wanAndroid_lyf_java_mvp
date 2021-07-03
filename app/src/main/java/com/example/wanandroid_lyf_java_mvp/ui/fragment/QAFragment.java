package com.example.wanandroid_lyf_java_mvp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wanandroid_lyf_java_mvp.R;
import com.example.wanandroid_lyf_java_mvp.basic.base.BaseFragment;
import com.example.wanandroid_lyf_java_mvp.basic.mvp.MvpPresenter;



public class QAFragment extends BaseFragment {
    public static QAFragment newInstance() {
        QAFragment fragment=new QAFragment();
        return fragment;
    }

    @Override
    protected int getLayoutRes() {
        return 0;
    }

    @Override
    protected MvpPresenter initPresenter() {
        return null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qa, container, false);
//        initView(view);
        return view;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initView() {

    }

    private void initView(View view) {
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }
}
