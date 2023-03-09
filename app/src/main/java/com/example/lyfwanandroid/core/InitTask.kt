package com.example.lyfwanandroid.core

import android.app.Application
import android.os.AsyncTask

class InitTaskRunner(private val application: Application) {
    private val mTasks: ArrayList<InitTask> = arrayListOf()

    fun add(initTask: InitTask): InitTaskRunner {
        mTasks.add(initTask)
        return this
    }

    fun start() {
        val syncTasks: ArrayList<InitTask> = arrayListOf()
        val asyncTasks: ArrayList<InitTask> = arrayListOf()
        for (task in mTasks) {
            if (task.async()) {
                asyncTasks.add(task)
            } else {
                syncTasks.add(task)
            }
        }
        runSync(syncTasks)
        runAsync(asyncTasks)
    }

    private fun runSync(syncTasks: ArrayList<InitTask>) {
        for (syncTask in syncTasks) {
            syncTask.init(application)
        }
    }

    private fun runAsync(asyncTasks: ArrayList<InitTask>) {
        asyncTasks.sortBy { it.level() }
        AsyncRunner(application, asyncTasks)
    }
}

class AsyncRunner(private val application: Application, private val tasks: ArrayList<InitTask>) :
    AsyncTask<Unit, Unit, Unit>() {
    override fun doInBackground(vararg p0: Unit?) {
        for (task in tasks) {
            task.init(application)
        }
    }

}


interface InitTask {
    fun async(): Boolean
    fun isMainProcess(): Boolean
    fun level(): Int
    fun init(application: Application)
}

abstract class SyncInitTask : InitTask {
    override fun async(): Boolean {
        return false
    }

    override fun isMainProcess(): Boolean {
        return true
    }

}

abstract class AsyncInitTask : InitTask {
    override fun async(): Boolean {
        return true
    }

    override fun isMainProcess(): Boolean {
        return true
    }

}