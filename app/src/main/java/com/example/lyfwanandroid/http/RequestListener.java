package com.example.lyfwanandroid.http;

import per.goweii.rxhttp.request.exception.ExceptionHandle;


public interface RequestListener<E> {
    void onStart();

    void onSuccess(int code, E data);

    void onFailed(int code, String msg);

    void onError(ExceptionHandle handle);

    void onFinish();
}
