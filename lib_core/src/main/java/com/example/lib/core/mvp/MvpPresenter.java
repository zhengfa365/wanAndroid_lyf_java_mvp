package com.example.lib.core.mvp;

public class MvpPresenter<V extends MvpView> {
//    Context context;
    private V baseView;

    public void attach(V baseView) {
        this.baseView = baseView;
    }

    public void detach() {
        this.baseView = null;
    }

    public V getBaseView(){
        return baseView;
    }
}
