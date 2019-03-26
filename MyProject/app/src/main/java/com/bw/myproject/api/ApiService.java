package com.bw.myproject.api;

import com.bw.myproject.bean.DetailBean;
import com.bw.myproject.bean.HomeBean;
import com.bw.myproject.bean.LoginBean;
import com.bw.myproject.bean.RegBean;
import com.bw.myproject.bean.SearchBean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Time:2019.03.20--19:08
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public interface ApiService {

    //    首页、
    //    http://172.17.8.100/small/commodity/v1/commodityList
    @GET(Api.Home_Url)
    Flowable<HomeBean> getHome();

    //    搜索
    //    http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=%E9%AB%98%E8%B7%9F%E9%9E%8B&page=1&count=10
    @GET(Api.Search_Url)
    Flowable<SearchBean> getSerach(@Query("keyword") String keyword, @Query("page") int page, @Query("count") int count);

    //    详情
    //    http://172.17.8.100/small/commodity/v1/findCommodityDetailsById?commodityId=44
    @GET(Api.Detals_Url)
    Flowable<DetailBean> getDetail(@Query("commodityId") String commodityId);

    //    注册
    //    http://172.17.8.100/small/user/v1/
    @POST(Api.Regist_Url)
    @FormUrlEncoded
    Flowable<RegBean> getReg(@FieldMap Map<String, String> map);


    //    登录
    @POST(Api.Login_Url)
    @FormUrlEncoded
    Flowable<LoginBean> getLogin(@FieldMap Map<String, String> map);
}
