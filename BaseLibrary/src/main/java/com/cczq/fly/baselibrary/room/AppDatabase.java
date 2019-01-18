package com.cczq.fly.baselibrary.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.cczq.fly.baselibrary.room.bean.Student;
import com.cczq.fly.baselibrary.room.dao.StudentDao;

@Database(entities = Student.class,version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract StudentDao studentDao();
}
