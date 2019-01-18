package com.cczq.fly.baselibrary.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cczq.fly.baselibrary.room.AppDatabase;
import com.cczq.fly.baselibrary.room.bean.Student;

import java.util.ArrayList;
import java.util.List;

public class LifeCycleBind implements LifecycleObserver {

    public static final String TAG = LifeCycleBind.class.getSimpleName();
    Context context;
    public LifeCycleBind(Context context) {
        this.context = context;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void init(){
        ARouter.getInstance().inject(context);
        initDatabaseData();
    }

    public void initDatabaseData(){
        new Thread(new Runnable() {//需要放在线程里面执行，因为这个是耗时操作
            List<Student> list = new ArrayList<>();
            @Override
            public void run() {
                for (int i = 0; i < 22; i++) {
                    Student student = new Student("张三"+i,"班级"+i,i);
                    list.add(student);
                }
                AppDatabase database = Room.databaseBuilder(context,AppDatabase.class,"flying").build();
                database.studentDao().insertStudents(list);
//                Log.e(TAG, "init: activity onCreate");
            }
        }).start();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void destroy(){
        ARouter.getInstance().destroy();
    }

}
