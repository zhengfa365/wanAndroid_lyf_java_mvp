package com.example.lib.core;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class RxLife {
    private CompositeDisposable compositeDisposable;

    public static RxLife create(){
        return new RxLife();
    }
    public RxLife(){
        this.compositeDisposable=new CompositeDisposable();
    }

    public void add(Disposable d){
        if(compositeDisposable==null||compositeDisposable.isDisposed()){
            compositeDisposable=new CompositeDisposable();
        }
        compositeDisposable.add(d);
    }

    public void destroy(){
        if(compositeDisposable!=null&&compositeDisposable.isDisposed()){
           compositeDisposable.dispose();
        }
    }
}
