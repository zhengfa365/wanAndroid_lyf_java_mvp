package com.example.wanandroid_lyf_java_mvp.model.test;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.wanandroid_lyf_java_mvp.R;
import com.example.wanandroid_lyf_java_mvp.basic.base.BaseActivity;
import com.example.wanandroid_lyf_java_mvp.basic.mvp.MvpPresenter;
import com.google.android.material.snackbar.Snackbar;

public class TestActivity extends BaseActivity<TestPresenter> implements TestView{
    private Button button;
    @Override
    public void initWindow() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_test;
    }

    @Override
    public TestPresenter initPresenter() {
        return new TestPresenter();
    }

    @Override
    public void initView() {
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.showCountNum();
            }
        });
    }

    @Override
    public void loadData() {

    }

    @Override
    public void show3TimeNum(int num) {
//        Toast.makeText(this,"the num is 3 times:"+num,Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"the num is  3 times: "+num,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNot3TimeNum() {
        Snackbar.make(button,"the num is not 3 times:",200).show();
    }
}
