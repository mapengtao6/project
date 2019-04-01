package com.bw.myproject.api;

import com.bw.myproject.bean.CircleBean;
import com.bw.myproject.bean.DetailBean;
import com.bw.myproject.bean.HomeBean;
import com.bw.myproject.bean.LoginBean;
import com.bw.myproject.bean.OneOrderBean;
import com.bw.myproject.bean.RegBean;
import com.bw.myproject.bean.SearchBean;
import com.bw.myproject.bean.SelOrderBean;
import com.bw.myproject.bean.ShopAddressBean;
import com.bw.myproject.bean.ShopSelBean;
import com.bw.myproject.bean.SynShop;
import com.bw.myproject.bean.TwoOrdeBean;

import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
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

    //    分类一级
    //    http://172.17.8.100/small/commodity/v1/findFirstCategory
    @GET(Api.Order_Url)
    Flowable<OneOrderBean> getOneOrder();

    //    分类二级
    //    http://172.17.8.100/small/commodity/v1/findSecondCategory?firstCategoryId=1001003
    @GET(Api.OrderTwo_Url)
    Flowable<TwoOrdeBean> getTwoOrder(@Query("firstCategoryId") String firstCategoryId);


    //    分类二级查询
    //    http://172.17.8.100/small/commodity/v1/findCommodityByCategory?page=1&count=5&categoryId=1001002001;
    @GET(Api.OrderSel_Url)
    Flowable<SelOrderBean> getSelOrder(@Query("categoryId") String categoryId);

    //    查询购物车
    @GET(Api.Shop_Sel)
    Flowable<ShopSelBean> getSelShop(@Header("userId") String userId, @Header("sessionId") String sessionId);

    //    同步购物车
//    http://172.17.8.100/small/order/verify/v1/syncShoppingCart
    @Multipart
    @PUT(Api.SynShop)
    Flowable<SynShop> getSynShop(@Header("userId") int userId, @Header("sessionId") String sessionId, @Part("data") RequestBody data);

    //    圈子
    //    http://172.17.8.100/small/circle/v1/findCircleList
    @GET(Api.Circle_Url)
    Flowable<CircleBean> getCircle(@Query("page") int page, @Query("count") int count);

    //    收货地址列表
//    http://172.17.8.100/small/user/verify/v1/receiveAddressList
    @GET(Api.ShopAddress)
    Flowable<ShopAddressBean> getShopAddress(@Header("userId") int userId, @Header("sessionId") String sessionId);

}
