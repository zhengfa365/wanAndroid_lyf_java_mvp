package com.example.wanandroid_lyf_java_mvp.basic.mvp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class MvpActivity<P extends MvpPresenter> extends AppCompatActivity implements MvpView{
    public P presenter;
    public abstract void initWindow();
    public abstract int getLayoutId();
    public abstract P initPresenter();
    public abstract void initView();
    public abstract void loadData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindow();
        if(getLayoutId()>0){
            setContentView(getLayoutId());
        }
        presenter=initPresenter();
        if(presenter!=null){
            presenter.attach(MvpActivity.this);
        }
        initialize();
    }

    private void initialize() {
        initView();
        loadData();
    }
}
