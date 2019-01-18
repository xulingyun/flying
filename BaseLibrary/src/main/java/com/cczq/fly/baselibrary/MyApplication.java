package com.cczq.fly.baselibrary;

import android.app.Application;

import com.cczq.fly.baselibrary.room.DatabaseUtil;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseUtil.init(this);
    }

}
