package com.cczq.fly.baselibrary.room;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.cczq.fly.baselibrary.MyApplication;

public class DatabaseUtil {

    private static AppDatabase database;

    public static void init(Application app) {
        if (database==null){
            synchronized (MyApplication.class){
                if(database==null){
                    database = Room.databaseBuilder(app,AppDatabase.class,"flying").build();
                }
            }
        }
    }

    public static AppDatabase getDatabase() {
        return database;
    }
}
