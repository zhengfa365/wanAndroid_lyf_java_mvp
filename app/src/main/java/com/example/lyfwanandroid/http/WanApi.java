package com.example.lyfwanandroid.http;

import com.example.lyfwanandroid.http.ApiService;

import per.goweii.rxhttp.request.Api;

public class WanApi extends Api {

    public static final String BASE_URL = "https://www.wanandroid.com/";

    public static final int ERROR = 1000;

    public static final int SUCCESS = 0;

    public static ApiService api(){
        return api(ApiService.class);
    }
}
