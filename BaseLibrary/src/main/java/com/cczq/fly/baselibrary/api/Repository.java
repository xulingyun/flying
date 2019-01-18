package com.cczq.fly.baselibrary.api;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.cczq.fly.baselibrary.room.DatabaseUtil;
import com.cczq.fly.baselibrary.room.bean.Student;
import com.cczq.fly.baselibrary.vm.BaseViewModel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Repository {


    public static LiveData<List<Student>> getStudent(final BaseViewModel viewModel){
        LiveData<List<Student>> students = DatabaseUtil.getDatabase().studentDao().queryAll();
        Disposable subscribe = Observable.interval(4000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .doOnNext(aLong -> {
                    Student student = students.getValue().get(0);
                    student.setName("阿里巴巴与四十大盗");
                    DatabaseUtil.getDatabase().studentDao().updateStrdent(student);
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    MutableLiveData<Boolean> lv = new MutableLiveData<>();
                    lv.setValue(true);
                    viewModel.setIsShow(lv);
                });
        return students;
    }


}
