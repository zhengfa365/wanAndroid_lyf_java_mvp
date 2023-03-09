package com.example.lyfwanandroid.core

import android.app.Application

class MyInitTasks {
}

class X5InitTask:AsyncInitTask(){
    override fun level(): Int {
        return 2
    }

    override fun init(application: Application) {
        TODO("Not yet implemented")
    }

}