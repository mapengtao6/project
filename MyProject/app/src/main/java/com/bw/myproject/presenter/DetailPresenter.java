package com.bw.myproject.presenter;

import com.bw.myproject.bean.DetailBean;
import com.bw.myproject.bean.ShopSelBean;
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

    ////////////////查询购物车
    public void shopcarsel(String userId, String sessionId) {

        detailModel.shopcarsel(userId, sessionId);
        detailModel.setShopCarLisenter(new DetailModel.onShopCarLisenter() {
            @Override
            public void onShopSel(ShopSelBean shopSelBean) {
                detailView.ShopSel(shopSelBean);
            }
        });
    }

//    同步购物车
    public void synShop(String userId, String sessionId, String s) {
        detailModel.synShop(userId,sessionId,s);
    }
}
