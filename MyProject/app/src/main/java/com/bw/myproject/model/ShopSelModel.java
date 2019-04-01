package com.bw.myproject.model;

import android.util.Log;

import com.bw.myproject.api.ApiService;
import com.bw.myproject.bean.ShopSelBean;
import com.bw.myproject.utils.RetrofitUtils;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Time:2019.03.28--15:31
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class ShopSelModel {

    public void shopsel(String userId, String sessionId) {

        ApiService apiService = RetrofitUtils.getInstance().setCreate(ApiService.class);

        Flowable<ShopSelBean> flowable = apiService.getSelShop(userId, sessionId);

        Log.i("uuu", userId + sessionId);


        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<ShopSelBean>() {
                    @Override
                    public void onNext(ShopSelBean shopSelBean) {

//                        Log.i("llll", shopSelBean.getResult().size() + "");

                        if (shopSelLisenter != null) {
                            shopSelLisenter.onShopSel(shopSelBean);
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

    public interface onShopSelLisenter {
        void onShopSel(ShopSelBean shopSelBean);
    }

    public onShopSelLisenter shopSelLisenter;

    public void setShopSelLisenter(onShopSelLisenter onShopSelLisenter) {
        this.shopSelLisenter = onShopSelLisenter;
    }
}
