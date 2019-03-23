package com.bw.myproject.presenter;

import com.bw.myproject.DetailsActivity;
import com.bw.myproject.model.DetailModel;

/**
 * Time:2019.03.22--21:17
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class DetailPresenter {

    private final DetailModel detailModel;

    public DetailPresenter(DetailsActivity detailsActivity) {

        detailModel = new DetailModel();
    }

    public void datail(String commodityId) {

        detailModel.detail(commodityId);
    }
}
