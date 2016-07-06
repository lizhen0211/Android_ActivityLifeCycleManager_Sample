package com.example.lz.activitylifecyclemanagertest;

import android.util.Log;

/**
 * Created by LZ on 2016/5/30.
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {

    MyApplication application;

    public CrashHandler(MyApplication application) {
        this.application = application;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        application.exitApplication();
    }
}
