package com.example.wanandroid_lyf_java_mvp.model.test;

import com.example.wanandroid_lyf_java_mvp.basic.base.BasePresenter;

public class TestPresenter extends BasePresenter<TestView> {
    private int count=0;
    public void showCountNum(){
        count++;
        if(count%3==0){
            mvpView.show3TimeNum(count);
        }else{
            mvpView.showNot3TimeNum();
        }
    }
}
