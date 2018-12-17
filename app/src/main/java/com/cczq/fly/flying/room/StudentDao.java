package com.cczq.fly.flying.room;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

public interface StudentDao {

    @Query("SELECT * from Student")
    public List<Student> queryAll();


    @Query("SELECT * from Student ORDER BY name COLLATE NOCASE ASC")
    public List<Student> queryPage(int start,int count);

    @Insert
    public void insertStrdent(Student strudent);

    @Insert
    public void insertStudents(List<Student> Strudents);

}
