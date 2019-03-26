package com.bw.myproject.model;

import android.util.Log;

import com.bw.myproject.api.ApiService;
import com.bw.myproject.bean.OneOrderBean;
import com.bw.myproject.bean.TwoOrdeBean;
import com.bw.myproject.utils.RetrofitUtils;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Time:2019.03.26--11:05
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class OrderModel {

    //    一级
    public void orderone() {

        ApiService apiService = RetrofitUtils.getInstance().setCreate(ApiService.class);

        Flowable<OneOrderBean> flowable = apiService.getOneOrder();

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<OneOrderBean>() {
                    @Override
                    public void onNext(OneOrderBean oneOrderBean) {

//                        List<OneOrderBean.ResultBean> result = oneOrderBean.getResult();

//                        Log.i("uuu", result.toString());

                        if (oneOrderLisenter != null) {

                            oneOrderLisenter.oneOrder(oneOrderBean);
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

    //    二级
    public void ordertwo(String firstCategoryId) {

        ApiService apiService = RetrofitUtils.getInstance().setCreate(ApiService.class);

        Flowable<TwoOrdeBean> flowable = apiService.getTwoOrder(firstCategoryId);

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<TwoOrdeBean>() {
                    @Override
                    public void onNext(TwoOrdeBean twoOrdeBean) {

//                        Log.i("llll", twoOrdeBean.getResult().size() + "");

                        if (twoOederLisenter != null) {
                            twoOederLisenter.twoOrder(twoOrdeBean);
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


    //    一级接口回调
    public interface onOneOrderLisenter {
        void oneOrder(OneOrderBean oneOrderBean);
    }

    public onOneOrderLisenter oneOrderLisenter;

    public void setOneOrderLisenter(onOneOrderLisenter onOneOrderLisenter) {
        this.oneOrderLisenter = onOneOrderLisenter;
    }

    //    二级接口回调
    public interface onTwoOederLisenter {
        void twoOrder(TwoOrdeBean twoOrdeBean);
    }

    public onTwoOederLisenter twoOederLisenter;

    public void setTwoOederLisenter(onTwoOederLisenter onTwoOederLisenter) {
        this.twoOederLisenter = onTwoOederLisenter;
    }
}
