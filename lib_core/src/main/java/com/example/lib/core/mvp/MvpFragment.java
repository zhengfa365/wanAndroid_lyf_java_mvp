package com.example.lib.core.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class MvpFragment<T extends MvpPresenter> extends Fragment implements MvpView {

    private View mRootView = null;
    private T presenter;

    abstract int getLayoutRes();

    abstract T initPresenter();

    abstract void loadData();

    abstract void initView();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            if (getLayoutRes() > 0) {
                mRootView = getLayoutInflater().inflate(getLayoutRes(), container, false);
            }
        }
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        attachPresenter();
        initialize();
    }

    void initialize() {
        initView();
        loadData();
    }

    void attachPresenter() {
        if (presenter == null) {
            presenter = initPresenter();
        }
        if (presenter != null) {
            presenter.attach(this);
        }
    }

    @Override
    public void onDestroyView() {
        presenter.detach();
        super.onDestroyView();
    }

    public View getmRootView() {
        return mRootView;
    }
}
