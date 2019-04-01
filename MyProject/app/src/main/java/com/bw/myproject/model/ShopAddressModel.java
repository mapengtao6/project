package com.bw.myproject.model;

import android.util.Log;

import com.bw.myproject.api.ApiService;
import com.bw.myproject.bean.ShopAddressBean;
import com.bw.myproject.utils.RetrofitUtils;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Time:2019.03.30--16:21
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class ShopAddressModel {
    public void shopaddress(String userId, String sessionId) {

        ApiService apiService = RetrofitUtils.getInstance().setCreate(ApiService.class);

        Flowable<ShopAddressBean> flowable = apiService.getShopAddress(Integer.parseInt(userId), sessionId);

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<ShopAddressBean>() {
                    @Override
                    public void onNext(ShopAddressBean shopAddressBean) {

//                        Log.i("llll", shopAddressBean.getResult().size() + "");

                        if (shopAddressLisenter != null) {
                            shopAddressLisenter.ShopAddress(shopAddressBean);
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

    public interface onShopAddressLisenter {
        void ShopAddress(ShopAddressBean shopAddressBean);
    }

    public onShopAddressLisenter shopAddressLisenter;

    public void setShopAddressLisenter(onShopAddressLisenter onShopAddressLisenter) {
        this.shopAddressLisenter = onShopAddressLisenter;
    }
}
