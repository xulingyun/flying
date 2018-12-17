package com.cczq.fly.flying;

import android.arch.lifecycle.LifecycleObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cczq.fly.flying.lifecycle.LifeCycleBind;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flying_activity_main);
        getLifecycle().addObserver(new LifeCycleBind());
    }
}
