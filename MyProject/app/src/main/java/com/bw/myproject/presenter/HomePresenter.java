package com.bw.myproject.presenter;

import com.bw.myproject.bean.HomeBean;
import com.bw.myproject.bean.SearchBean;
import com.bw.myproject.fragment.HomeFragment;
import com.bw.myproject.model.HomeModel;
import com.bw.myproject.view.HomeView;

/**
 * Time:2019.03.20--19:20
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class HomePresenter {

    private final HomeModel homeModel;
    private final HomeView homeView;

    //    实例化
    public HomePresenter(HomeView view) {
        homeModel = new HomeModel();

        homeView = view;
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

    public void search(String keyword, int page, int count) {
        homeModel.search(keyword,page,count);
        homeModel.setHomeSelLisener(new HomeModel.onHomeSelLisener() {
            @Override
            public void onResults(SearchBean searchBean) {
                homeView.getDataViews(searchBean);
            }
        });

    }
}
