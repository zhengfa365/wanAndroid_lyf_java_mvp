package com.example.lyfwanandroid.mvp;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends MvpActivity {
    private Unbinder unbinder;

    @Override
    protected void initialize() {
        unbinder = ButterKnife.bind(this);
        super.initialize();
    }

    @Override
    protected void onDestroy() {
        if (unbinder!=null){
            unbinder.unbind();
        }
        super.onDestroy();
    }
}
