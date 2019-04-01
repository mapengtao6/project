package com.bw.myproject.model;

import android.util.Log;

import com.bw.myproject.api.Api;
import com.bw.myproject.api.ApiService;
import com.bw.myproject.bean.DetailBean;
import com.bw.myproject.bean.ShopSelBean;
import com.bw.myproject.bean.SynShop;
import com.bw.myproject.utils.RetrofitUtils;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import okhttp3.MediaType;
import okhttp3.RequestBody;


/**
 * Time:2019.03.22--21:17
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class DetailModel {

    //    详情
    public void detail(String commodityId) {

        ApiService apiService = RetrofitUtils.getInstance().setCreate(ApiService.class);

        Flowable<DetailBean> flowable = apiService.getDetail(commodityId);

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<DetailBean>() {
                    @Override
                    public void onNext(DetailBean detailBean) {

//                        DetailBean.ResultBean result = detailBean.getResult();

//                        Log.i("llll",result.toString());

                        if (detailLisenter != null) {
                            detailLisenter.onDetail(detailBean);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //    查询购物车
    public void shopcarsel(String userId, String sessionId) {

        ApiService apiService = RetrofitUtils.getInstance().setCreate(ApiService.class);

        Flowable<ShopSelBean> flowable = apiService.getSelShop(userId, sessionId);

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<ShopSelBean>() {
                    @Override
                    public void onNext(ShopSelBean shopSelBean) {

//                        Log.i("sss", shopSelBean.getResult().size() + "");
//                        判断
                        if (shopCarLisenter != null) {
                            shopCarLisenter.onShopSel(shopSelBean);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    //    同步购物车
    public void synShop(String userId, String sessionId, String s) {

        ApiService apiService = RetrofitUtils.getInstance().setCreate(ApiService.class);
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), s);

        Log.i("uuuu", requestBody.toString());
        Flowable<SynShop> flowable = apiService.getSynShop(Integer.parseInt(userId), sessionId, requestBody);

        Log.i("hhhh", userId + sessionId + requestBody);

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<SynShop>() {
                    @Override
                    public void onNext(SynShop synShop) {

                        Log.i("tttt", synShop.getMessage());

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    //    详情接口
    public interface onDetailLisenter {
        void onDetail(DetailBean detailBean);
    }

    public onDetailLisenter detailLisenter;

    public void setDetailLisenter(onDetailLisenter onDetailLisenter) {
        this.detailLisenter = onDetailLisenter;
    }

    //    查询购物车接口、
    public interface onShopCarLisenter {

        void onShopSel(ShopSelBean shopSelBean);
    }

    public onShopCarLisenter shopCarLisenter;

    public void setShopCarLisenter(onShopCarLisenter onShopCarLisenter) {
        this.shopCarLisenter = onShopCarLisenter;
    }
}
