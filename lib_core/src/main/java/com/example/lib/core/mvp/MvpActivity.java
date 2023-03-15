package com.example.lib.core.mvp;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class MvpActivity<P extends MvpPresenter> extends AppCompatActivity implements MvpView {
    P presenter;

    void initWindow() {
    }

    protected abstract int getLayoutId();

    protected abstract P initPresenter();

    protected abstract void initView();

    protected abstract void loadData();

    protected void initialize() {
        initView();
        loadData();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindow();
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
        }
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
        initialize();
    }

    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.attach(this);
        }
        super.onDestroy();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
