package com.cczq.fly.flying;

import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cczq.fly.flying.lifecycle.LifeCycleBind;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flying_activity_main);
        getLifecycle().addObserver(new LifeCycleBind());
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(10)
                .setPageSize(5)
                .setPrefetchDistance(150)
                .build();
//        new LivePagedListBuilder(,config);
    }
}
