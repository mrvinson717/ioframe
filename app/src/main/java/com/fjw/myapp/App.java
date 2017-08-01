package com.fjw.myapp;

import android.app.Application;

/**
 * Created by 范佳伟 on 2017/7/31.
 */

public class App extends Application {

    public static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static App getInstance() {
        return mInstance;
    }
}