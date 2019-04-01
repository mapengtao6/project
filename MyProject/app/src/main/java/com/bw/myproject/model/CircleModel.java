package com.bw.myproject.model;

import android.util.Log;

import com.bw.myproject.api.ApiService;
import com.bw.myproject.bean.CircleBean;
import com.bw.myproject.utils.RetrofitUtils;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Time:2019.03.30--14:53
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class CircleModel {

    public void circle(int page, int count) {

        ApiService apiService = RetrofitUtils.getInstance().setCreate(ApiService.class);

        Flowable<CircleBean> flowable = apiService.getCircle(page, count);

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<CircleBean>() {
                    @Override
                    public void onNext(CircleBean circleBean) {

//                        Log.i("jjj", circleBean.getResult().size() + "");

                        if (circleLisenter != null) {
                            circleLisenter.Circle(circleBean);
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

    public interface onCircleLisenter {
        void Circle(CircleBean circleBean);
    }

    public onCircleLisenter circleLisenter;

    public void setCircleLisenter(onCircleLisenter onCircleLisenter) {
        this.circleLisenter = onCircleLisenter;
    }
}
