package com.example.lib.core.mvp;

import com.example.lib.core.RxLife;

import io.reactivex.disposables.Disposable;

public class BasePresenter extends MvpPresenter{
    private RxLife rxLife;

    @Override
    public void attach(MvpView baseView) {
        super.attach(baseView);
        rxLife= RxLife.create();
    }

    @Override
    public void detach() {
        super.detach();
        rxLife.destroy();
        rxLife=null;
    }

    public void addToRxLife(Disposable disposable){
        if(rxLife!=null){
            rxLife.add(disposable);
        }
    }
}
