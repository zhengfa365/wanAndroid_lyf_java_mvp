package com.example.wanandroid_lyf_java_mvp.basic.mvp;

import android.content.Context;

public interface MvpView {
    Context getContext();
    void showLoading();
    void dismissLoading();
}
