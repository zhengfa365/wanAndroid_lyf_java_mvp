package com.example.lyfwanandroid.core;

import android.app.Application;

public class WanApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        new InitTaskRunner(this)
                .add(new X5InitTask())
                .start();
    }
}
