package com.cczq.fly.baselibrary.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {

    private static RetrofitUtil retrofitUtil;
    private static ApiRequest apiRequest;

    private RetrofitUtil(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        apiRequest = retrofit.create(ApiRequest.class);
    }

    public static ApiRequest getInstance(){
        if(retrofitUtil==null){
            synchronized (RetrofitUtil.class){
                if(retrofitUtil==null){
                    retrofitUtil = new RetrofitUtil();
                }
            }
        }
        return apiRequest;
    }

}
