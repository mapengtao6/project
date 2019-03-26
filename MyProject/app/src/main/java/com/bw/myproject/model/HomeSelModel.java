package com.bw.myproject.model;

import com.bw.myproject.api.Api;
import com.bw.myproject.api.ApiService;
import com.bw.myproject.bean.SearchBean;
import com.bw.myproject.utils.RetrofitUtils;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Time:2019.03.22--14:30
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class HomeSelModel {
    public void search(String keyword, int page, int count) {

        ApiService apiService = RetrofitUtils.getInstance().setCreate(ApiService.class);

        Flowable<SearchBean> flowable = apiService.getSerach(keyword, page, count);

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<SearchBean>() {
                    @Override
                    public void onNext(SearchBean searchBean) {

                      /*  List<SearchBean.ResultBean> result = searchBean.getResult();

                        Log.i("xxxx",result.toString());*/

                        if (homeSelLisener != null) {
                            homeSelLisener.onResults(searchBean);
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

    public interface onHomeSelLisener {
        void onResults(SearchBean searchBean);
    }

    public onHomeSelLisener homeSelLisener;

    public void setHomeSelLisener(onHomeSelLisener onHomeSelLisener) {
        this.homeSelLisener = onHomeSelLisener;
    }
}
