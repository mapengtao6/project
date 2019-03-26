package com.bw.myproject.presenter;

import com.bw.myproject.bean.DetailBean;
import com.bw.myproject.model.DetailModel;
import com.bw.myproject.view.DetailView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Time:2019.03.22--21:17
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class DetailPresenter<T> {

    private Reference<T> tReference;
    private final DetailModel detailModel;
    private final DetailView detailView;

    public void addachView(T t) {

        tReference = new WeakReference<T>(t);
    }

    public void deatchView() {

        if (tReference != null) {
            tReference.clear();
            tReference = null;
        }
    }

    public DetailPresenter(DetailView view) {

        detailModel = new DetailModel();

        detailView = view;
    }

    public void datail(String commodityId) {

        detailModel.detail(commodityId);
        detailModel.setDetailLisenter(new DetailModel.onDetailLisenter() {
            @Override
            public void onDetail(DetailBean detailBean) {
                detailView.Detail(detailBean);
            }
        });
    }
}
