package com.example.lxy.goodsinfopage;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class HqApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
