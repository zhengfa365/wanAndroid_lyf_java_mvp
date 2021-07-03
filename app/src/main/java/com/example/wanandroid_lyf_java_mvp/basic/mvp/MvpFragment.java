package com.example.wanandroid_lyf_java_mvp.basic.mvp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public abstract class MvpFragment<P extends MvpPresenter> extends Fragment implements MvpView{
    protected abstract int getLayoutRes();
    protected abstract P initPresenter();
    protected View mRootView = null;
    P presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
//        if(getLayoutRes()>0){
//            return inflater.inflate(getLayoutRes(),container,false);
//        }
//        return null;
        if (mRootView == null) {
            final int layoutId = getLayoutRes();
            if (layoutId > 0) {
                mRootView = inflater.inflate(getLayoutRes(), container, false);
            }
        }
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter=initPresenter();
        if(presenter!=null){
            presenter.attach(this);
        }
        initialize();
    }

    protected  void initialize(){
        initView();
        loadData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(presenter!=null){
            presenter.detach();
        }
    }

    public Context getContext(){
        return getActivity();
    }

    public Fragment getFragment() {
        return this;
    }

    protected abstract void loadData();

    protected abstract void initView();
    


}
