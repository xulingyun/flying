package com.cczq.fly.baselibrary;

import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.ButterKnife;

public abstract class BaseActivity<T extends LifecycleObserver> extends AppCompatActivity {

    public View loadingView;
    public T lifeCycleBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout();
        ButterKnife.bind(this);
        initView();
        initListener();
        observe();
        initLoading();
    }

    public void initLoading() {
        loadingView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.base_loading_layout, null, false);
        loadingView.setOnTouchListener((v, event) -> true);
        getWindow().addContentView(loadingView, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        loadingView.setVisibility(View.INVISIBLE);
    }

    protected abstract void initListener();

    protected abstract void observe();

    protected abstract void initView();

    protected abstract void setLayout();

}
