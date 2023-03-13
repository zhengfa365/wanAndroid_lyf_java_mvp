package com.example.lib.core.mvp;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends MvpFragment {
    private Unbinder mUnbinder = null;

    @Override
    void initialize() {
        if (getmRootView() != null) {
            mUnbinder = ButterKnife.bind(this, getmRootView());
        }
        super.initialize();
    }

    @Override
    public void onDestroyView() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroyView();
    }
}
