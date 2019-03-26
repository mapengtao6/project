package com.bw.myproject.model;

import android.util.Log;

import com.bw.myproject.api.Api;
import com.bw.myproject.api.ApiService;
import com.bw.myproject.bean.RegBean;
import com.bw.myproject.utils.RetrofitUtils;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Time:2019.03.23--15:42
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class RegModel {

    public void reg(Map<String, String> param) {

        ApiService apiService = RetrofitUtils.getInstance().setCreate(ApiService.class);

        Flowable<RegBean> flowable = apiService.getReg(param);

//        Log.i("kkkk",phone+pwd);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<RegBean>() {
                    @Override
                    public void onNext(RegBean regBean) {

//                        Log.i("oooo",regBean.getStatus().toString());

//                        Log.i("rrrr", regBean.toString());

                        if (reginLisenter != null) {
                            reginLisenter.onReg(regBean);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.i("rrrr", t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface onReginLisenter {
        void onReg(RegBean regBean);
    }

    public onReginLisenter reginLisenter;

    public void setReginLisenter(onReginLisenter onReginLisenter) {
        this.reginLisenter = onReginLisenter;
    }
}
