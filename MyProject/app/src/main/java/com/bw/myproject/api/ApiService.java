package com.bw.myproject.api;

import com.bw.myproject.bean.HomeBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Time:2019.03.20--19:08
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public interface ApiService {

    //    http://172.17.8.100/small/commodity/v1/commodityList
    @GET("commodityList")
    Flowable<HomeBean> getHome();
}
