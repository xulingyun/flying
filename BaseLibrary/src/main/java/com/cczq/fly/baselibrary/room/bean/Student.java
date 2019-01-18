package com.cczq.fly.baselibrary.room.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "student")
public class Student {

    public Student() {
    }

    @Ignore
    public Student(String name, String clazz, int scroe) {
        this.name = name;
        this.clazz = clazz;
        this.scroe = scroe;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private String clazz;

    private int scroe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public int getScroe() {
        return scroe;
    }

    public void setScroe(int scroe) {
        this.scroe = scroe;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clazz='" + clazz + '\'' +
                ", scroe=" + scroe +
                '}';
    }
}
