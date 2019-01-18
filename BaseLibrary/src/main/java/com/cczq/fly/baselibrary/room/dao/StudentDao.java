package com.cczq.fly.baselibrary.room.dao;

import android.arch.lifecycle.LiveData;
import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cczq.fly.baselibrary.room.bean.Student;

import java.util.List;


@Dao
public interface StudentDao {

    @Query("SELECT * from Student ORDER BY id ASC")
    LiveData<List<Student>> queryAll();


    @Query("SELECT * from Student ORDER BY id ASC")
    DataSource.Factory<Integer, Student> queryAll2();


    @Query("SELECT * from Student WHERE id = :id")
    LiveData<Student> queryOne(int id);

    @Insert
    void insertStrdent(Student strudent);


    @Update
    void updateStrdent(Student strudent);

    @Insert
    void insertStudents(List<Student> Strudents);

}
