package com.bw.myproject.model;

import android.util.Log;

import com.bw.myproject.api.Api;
import com.bw.myproject.api.ApiService;
import com.bw.myproject.bean.HomeBean;
import com.bw.myproject.bean.SearchBean;
import com.bw.myproject.utils.RetrofitUtils;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Time:2019.03.20--19:20
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class HomeModel {

    public void home() {

        ApiService apiService = RetrofitUtils.getInstance().setCreate(ApiService.class);

        Flowable<HomeBean> flowable = apiService.getHome();

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<HomeBean>() {
                    @Override
                    public void onNext(HomeBean homeBean) {

//                        Log.i("xxxx", homeBean.getResult().getMlss().getCommodityList().toString());

                        if (homeLisenter != null) {

                            homeLisenter.onRusult(homeBean);
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



    //    创建
    public interface onHomeLisenter {

        void onRusult(HomeBean homeBean);
    }

    //    定义
    public onHomeLisenter homeLisenter;

    //    监听
    public void setHomeLisenter(onHomeLisenter onHomeLisenter) {
        this.homeLisenter = onHomeLisenter;
    }


}
