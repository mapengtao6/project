package com.bw.myproject.model;

import android.util.Log;

import com.bw.myproject.api.ApiService;
import com.bw.myproject.bean.LoginBean;
import com.bw.myproject.utils.RetrofitUtils;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Time:2019.03.23--17:07
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class LoginModel {
    public void login(Map<String, String> param) {

        ApiService apiService = RetrofitUtils.getInstance().setCreate(ApiService.class);

        Flowable<LoginBean> flowable = apiService.getLogin(param);

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<LoginBean>() {
                    @Override
                    public void onNext(LoginBean loginBean) {

//                        Log.i("xxxx", loginBean.toString());

                        if (loginLisenter!= null){
                            loginLisenter.onLogin(loginBean);
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

    public interface onLoginLisenter {

        void onLogin(LoginBean loginBean);
    }

    public onLoginLisenter loginLisenter;

    public void setLoginLisenter(onLoginLisenter onLoginLisenter) {
        this.loginLisenter = onLoginLisenter;
    }
}
