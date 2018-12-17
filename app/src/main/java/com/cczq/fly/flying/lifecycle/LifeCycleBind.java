package com.cczq.fly.flying.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

public class LifeCycleBind implements LifecycleObserver {

    public static final String TAG = LifeCycleBind.class.getSimpleName();
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void init(){
        Log.e(TAG, "init: activity onCreate");
    }

}
