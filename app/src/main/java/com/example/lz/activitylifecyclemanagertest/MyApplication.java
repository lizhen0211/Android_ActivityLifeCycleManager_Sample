package com.example.lz.activitylifecyclemanagertest;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by LZ on 2016/5/29.
 */
public class MyApplication extends Application {

    private ArrayList<Activity> activities;

    private CrashHandler crashHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        crashHandler = new CrashHandler(this);
        Thread.setDefaultUncaughtExceptionHandler(crashHandler);

        activities = new ArrayList<Activity>();
        registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    private ActivityLifecycleCallbacks activityLifecycleCallbacks = new ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            activities.add(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            activities.remove(activity);
        }
    };

    public void exitApplication() {
        for (int i = activities.size() - 1; i >= 0; i--) {
            Activity activity = activities.get(i);
            activity.finish();
        }
        activities.clear();
        killProcess();
    }

    public void finishActivity(Class<?>... activityClasses) {
        for (int i = activities.size() - 1; i >= 0; i--) {
            for (int j = 0; j < activityClasses.length; j++) {
                Activity activity = activities.get(i);
                if (activity.getComponentName().getClassName().equals(activityClasses[j].getName())) {
                    activity.finish();
                }
            }
        }
    }

    public void killProcess() {
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
