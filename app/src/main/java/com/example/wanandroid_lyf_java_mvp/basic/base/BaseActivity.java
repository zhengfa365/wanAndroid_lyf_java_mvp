package com.example.wanandroid_lyf_java_mvp.basic.base;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.wanandroid_lyf_java_mvp.basic.mvp.MvpActivity;

public abstract class BaseActivity<P extends BasePresenter> extends MvpActivity<P> {
    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showLoading() {
        Toast.makeText(this,"show load",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dismissLoading() {
        Toast.makeText(this,"dismiss load",Toast.LENGTH_SHORT).show();
    }
}
