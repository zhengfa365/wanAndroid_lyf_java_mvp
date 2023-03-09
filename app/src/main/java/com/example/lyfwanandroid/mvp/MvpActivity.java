package com.example.lyfwanandroid.mvp;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class MvpActivity<P extends MvpPresenter> extends AppCompatActivity implements MvpView {
    P presenter;

    void initWindow() {
    }

    abstract int getLayoutId();

    abstract P initPresenter();

    abstract void initView();

    abstract void loadData();

    protected void initialize(){
        initView();
        loadData();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
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
