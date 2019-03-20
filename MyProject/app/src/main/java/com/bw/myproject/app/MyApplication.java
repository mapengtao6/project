package com.bw.myproject.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Time:2019.03.20--19:42
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
    }
}
