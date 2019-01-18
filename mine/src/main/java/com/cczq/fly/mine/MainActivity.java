package com.cczq.fly.mine;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.core.LogisticsCenter;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cczq.fly.baselibrary.BaseActivity;
import com.cczq.fly.baselibrary.lifecycle.LifeCycleBind;
import com.cczq.fly.baselibrary.vm.BaseViewModel;

import java.lang.reflect.Constructor;

import butterknife.BindView;

@Route(path="/mine/main")
public class MainActivity extends BaseActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    BaseViewModel baseViewModel;
    @BindView(R2.id.but)
    Button but;
    @BindView(R2.id.tv)
    TextView tv;
    @BindView(R2.id.rv)
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lifeCycleBind = new LifeCycleBind(this);
        getLifecycle().addObserver(lifeCycleBind);
    }

    @Override
    protected void initListener() {
        but.setOnClickListener(v -> {
//            baseViewModel.getStudents().getValue().get(0).setName("dasdasdasdas");
            ARouter.getInstance().build("/seedot/main").withInt("key",100).withTransition(android.R.anim.fade_in,android.R.anim.fade_out).navigation();
        });
    }

    @Override
    protected void observe() {
        baseViewModel = ViewModelProviders.of(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                try {
                    Constructor<T> constructor = modelClass.getConstructor(String.class);
                    return constructor.newInstance("张飞爱吹牛逼");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        }).get(BaseViewModel.class);
        baseViewModel.init();
        baseViewModel.getStudents().observe(this, students -> {
            tv.setText(students.get(0).getName());
        });
        baseViewModel.getIsShow().observe(this, aBoolean -> {
            loadingView.setVisibility(aBoolean ? View.VISIBLE : View.INVISIBLE);
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    public void setLayout() {
        setContentView(R.layout.mine_activity_main);
    }

}
