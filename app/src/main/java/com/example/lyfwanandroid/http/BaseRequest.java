package com.example.lyfwanandroid.http;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import per.goweii.rxhttp.request.RxRequest;
import per.goweii.rxhttp.request.base.BaseResponse;
import per.goweii.rxhttp.request.exception.ExceptionHandle;

public class BaseRequest {

    public static <T> Disposable request(Observable<WanResponse<T>> observable, RequestListener listener){
        return RxRequest.create(observable)
                .listener(new RxRequest.RequestListener() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onError(ExceptionHandle exceptionHandle) {
                        listener.onFailed(WanApi.ERROR,exceptionHandle.getMsg());
                    }

                    @Override
                    public void onFinish() {

                    }
                }).request(new RxRequest.ResultCallback<T>() {
                    @Override
                    public void onSuccess(int i, T t) {
                        listener.onSuccess(i,t);
                    }

                    @Override
                    public void onFailed(int i, String s) {
                        listener.onFailed(i,s);
                    }
                });
    }
}
