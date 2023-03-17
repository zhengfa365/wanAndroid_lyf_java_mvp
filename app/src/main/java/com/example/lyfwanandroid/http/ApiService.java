package com.example.lyfwanandroid.http;

import com.example.lyfwanandroid.module.main.model.ListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {


    /**
     * 问答
     * pageId,拼接在链接上，例如上面的1
     */
    @GET("wenda/list/{page}/json")
    Observable<WanResponse<ListBean>> getQuestionList(@Path("page") int page);
}
