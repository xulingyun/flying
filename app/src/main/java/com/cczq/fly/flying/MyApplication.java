package com.cczq.fly.flying;

import android.app.Application;
import android.database.DatabaseUtils;
import android.support.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cczq.fly.baselibrary.room.DatabaseUtil;

//import com.cczq.fly.baselibrary.room.DatabaseUtil;


public class MyApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseUtil.init(this);
        ARouter.init(this);
    }

}
