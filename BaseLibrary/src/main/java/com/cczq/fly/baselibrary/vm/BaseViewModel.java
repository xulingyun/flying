package com.cczq.fly.baselibrary.vm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.util.Log;

import com.cczq.fly.baselibrary.api.Repository;
import com.cczq.fly.baselibrary.room.DatabaseUtil;
import com.cczq.fly.baselibrary.room.bean.Student;

import java.util.List;

public class BaseViewModel extends ViewModel {

    LiveData<List<Student>> students;
    LiveData<Student> student;
    MutableLiveData<Boolean> isShow = new MutableLiveData<>();
    LiveData<PagedList<Student>> studentList;

    public BaseViewModel() {
    }

    public BaseViewModel(String ss) {
        Log.e("TAG", "BaseViewModel: -----------------------"+ss);
    }


    public void init(){
        isShow.setValue(false);
        students = Repository.getStudent(this);
        studentList = new LivePagedListBuilder<>(DatabaseUtil.getDatabase().studentDao().queryAll2(),10).build();
    }

    public LiveData<List<Student>> getStudents() {
        return students;
    }

    public LiveData<Student> getStudent() {
        return student;
    }

    public void setSS(Student ss){
        DatabaseUtil.getDatabase().studentDao().updateStrdent(ss);
    }

    public LiveData<Boolean> getIsShow() {
        return isShow;
    }

    public void setIsShow(MutableLiveData<Boolean> isShow) {
        this.isShow.setValue(!this.isShow.getValue());
    }

    public LiveData<PagedList<Student>> getStudentList() {
        return studentList;
    }

    public void setStudentList(LiveData<PagedList<Student>> studentList) {
        this.studentList = studentList;
    }
}
