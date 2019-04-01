package com.bw.myproject.presenter;

import com.bw.myproject.bean.ShopSelBean;
import com.bw.myproject.fragment.ShoppCardFragment;
import com.bw.myproject.model.ShopSelModel;
import com.bw.myproject.view.ShopSelView;

/**
 * Time:2019.03.28--15:31
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class ShopSelPresenter {

    private final ShopSelModel shopSelModel;
    private final ShopSelView shopSelView;

    public ShopSelPresenter(ShopSelView view) {
        shopSelModel = new ShopSelModel();

        shopSelView = view;
    }

    public void shopsel(String userId, String sessionId) {

        shopSelModel.shopsel(userId, sessionId);

        shopSelModel.setShopSelLisenter(new ShopSelModel.onShopSelLisenter() {
            @Override
            public void onShopSel(ShopSelBean shopSelBean) {
                shopSelView.getViewData(shopSelBean);
            }
        });
    }
}
