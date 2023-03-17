package com.example.lyfwanandroid.module.question.presenter

import com.example.lib.core.mvp.BasePresenter
import com.example.lyfwanandroid.http.BaseRequest
import com.example.lyfwanandroid.http.RequestListener
import com.example.lyfwanandroid.http.WanApi
import com.example.lyfwanandroid.module.main.model.ArticleBean
import com.example.lyfwanandroid.module.main.model.ArticleListBean
import per.goweii.rxhttp.request.RxRequest.ResultCallback

class QuestionPresenter : () {
    fun getQuestionList(page: Int, listener: RequestListener) {
        request(WanApi.api().getQuestionList(page),listener)
    }
}