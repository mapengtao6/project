package com.bw.myproject.model;

import android.util.Log;

import com.bw.myproject.api.Api;
import com.bw.myproject.api.ApiService;
import com.bw.myproject.bean.DetailBean;
import com.bw.myproject.utils.RetrofitUtils;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Time:2019.03.22--21:17
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class DetailModel {
    public void detail(String commodityId) {

        ApiService apiService = RetrofitUtils.getInstance().setCreate(Api.Details_Url, ApiService.class);

        Flowable<DetailBean> flowable = apiService.getDetail(commodityId);

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<DetailBean>() {
                    @Override
                    public void onNext(DetailBean detailBean) {

                        DetailBean.ResultBean result = detailBean.getResult();

                        Log.i("llll",result.toString());
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
