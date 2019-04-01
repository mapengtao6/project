package com.bw.myproject.presenter;

import com.bw.myproject.activity.ShopAddressActivity;
import com.bw.myproject.bean.ShopAddressBean;
import com.bw.myproject.model.ShopAddressModel;
import com.bw.myproject.view.ShopAddressView;

/**
 * Time:2019.03.30--16:21
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class ShopAddressPresenter {

    private final ShopAddressModel shopAddressModel;
    private final ShopAddressView shopAddressView;

    public ShopAddressPresenter(ShopAddressView view) {

        shopAddressModel = new ShopAddressModel();

        shopAddressView = view;
    }

    public void shopaddress(String userId, String sessionId) {

        shopAddressModel.shopaddress(userId, sessionId);

        shopAddressModel.setShopAddressLisenter(new ShopAddressModel.onShopAddressLisenter() {
            @Override
            public void ShopAddress(ShopAddressBean shopAddressBean) {
                shopAddressView.getShopAddress(shopAddressBean);
            }
        });
    }
}
