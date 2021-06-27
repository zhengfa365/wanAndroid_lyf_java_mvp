package com.example.wanandroid_lyf_java_mvp.basic.mvp;

import android.content.Context;

public abstract class MvpPresenter<V extends MvpView>{
    public V mvpView;
    public Context mContext;
    public void attach(V view){
        mvpView=view;
        mContext=mContext;
    }
    public void detach(){
        mvpView=null;
        mContext=null;
    }


}
