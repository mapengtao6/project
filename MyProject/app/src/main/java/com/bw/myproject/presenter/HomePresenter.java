package com.bw.myproject.presenter;

import com.bw.myproject.bean.HomeBean;
import com.bw.myproject.bean.SearchBean;
import com.bw.myproject.fragment.HomeFragment;
import com.bw.myproject.model.HomeModel;
import com.bw.myproject.view.HomeView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Time:2019.03.20--19:20
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class HomePresenter<T> {

    private Reference<T> tReference;
    private final HomeModel homeModel;
    private final HomeView homeView;

    public void addachView(T t) {

        tReference = new WeakReference<T>(t);
    }

    public void deatchView() {

        if (tReference != null) {
            tReference.clear();
            tReference = null;
        }
    }

    //    实例化
    public HomePresenter(HomeView view) {
        homeModel = new HomeModel();

       homeView = view ;
    }

    public void home() {

        homeModel.home();

        homeModel.setHomeLisenter(new HomeModel.onHomeLisenter() {
            @Override
            public void onRusult(HomeBean homeBean) {
                homeView.getDataView(homeBean);
            }
        });
    }
}
