package com.cczq.fly.baselibrary.api;

import com.cczq.fly.baselibrary.room.bean.Student;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiRequest {

    @GET("")
    Observable<Student> getStudent();



}
