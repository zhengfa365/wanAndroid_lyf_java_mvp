package com.example.lyfwanandroid.core

import android.app.Application
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator

class MyInitTasks {
}

class X5InitTask : AsyncInitTask() {
    override fun level(): Int {
        return 2
    }

    override fun init(application: Application) {
    }
}

class SmartRefreshInitTask : SyncInitTask() {
    override fun level(): Int {
        return 1
    }

    override fun init(application: Application) {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, _ -> ClassicsHeader(context) }
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, _ -> ClassicsFooter(context) }
    }

}