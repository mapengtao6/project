package com.bw.myproject.presenter;

import com.bw.myproject.bean.SearchBean;
import com.bw.myproject.model.HomeSelModel;
import com.bw.myproject.view.HomeSelView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Time:2019.03.22--14:25
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class HomeSelPresenter<T> {

    private Reference<T> tReference;
    private final HomeSelModel homeSelModel;
    private final HomeSelView homeSelView;

    public void addachView(T t) {

        tReference = new WeakReference<T>(t);
    }

    public void deatchView() {

        if (tReference != null) {
            tReference.clear();
            tReference = null;
        }
    }

    public HomeSelPresenter(HomeSelView view) {
        homeSelModel = new HomeSelModel();

        homeSelView = view;
    }

    public void search(String keyword, int page, int count) {

        homeSelModel.search(keyword, page, count);
        homeSelModel.setHomeSelLisener(new HomeSelModel.onHomeSelLisener() {
            @Override
            public void onResults(SearchBean searchBean) {
                homeSelView.getDataViews(searchBean);
            }
        });
    }
}
