package com.bw.myproject.utils;

import android.util.Log;

import com.bw.myproject.api.Api;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Time:2019.03.20--18:53
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class RetrofitUtils {

    //    私有的静态常量
    private static RetrofitUtils retrofitUtils;

    //    私有的构造方法
    private RetrofitUtils() {

    }

    public static RetrofitUtils getInstance() {

//        步锁
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (retrofitUtils == null) {
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }

        return retrofitUtils;
    }

    //    获取ok
    private static OkHttpClient okHttpClient;

    private static synchronized OkHttpClient getOkHttpClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("mmm", message);
            }
        });

        okHttpClient = new OkHttpClient
                .Builder()
                .addInterceptor(interceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(3000, TimeUnit.MILLISECONDS)
                .readTimeout(3000, TimeUnit.MILLISECONDS)
                .build();

        return okHttpClient;
    }

    //    获取retrofit
    private static Retrofit retrofit;

    private static synchronized Retrofit getRetrofit() {

        retrofit = new Retrofit
                .Builder()
                .client(getOkHttpClient())
                .baseUrl(Api.Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


        return retrofit;
    }

    public <T> T setCreate( Class<T> apiService) {

        Retrofit retrofit = getRetrofit();

        T t = retrofit.create(apiService);

        return t;
    }
}
