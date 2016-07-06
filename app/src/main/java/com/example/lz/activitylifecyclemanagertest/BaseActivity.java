package com.example.lz.activitylifecyclemanagertest;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

/**
 * Created by LZ on 2016/5/29.
 */
public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void exitApplicationByActivityStack() {
        MyApplication application = (MyApplication) getApplication();
        application.exitApplication();
    }

    public void finishActivity(Class<?>... activityClasses) {
        MyApplication application = (MyApplication) getApplication();
        application.finishActivity(activityClasses);
    }
}
