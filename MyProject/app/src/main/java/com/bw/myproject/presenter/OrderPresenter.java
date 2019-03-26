package com.bw.myproject.presenter;

import com.bw.myproject.activity.FenleiActivity;
import com.bw.myproject.bean.OneOrderBean;
import com.bw.myproject.bean.TwoOrdeBean;
import com.bw.myproject.model.OrderModel;
import com.bw.myproject.view.OrderView;

/**
 * Time:2019.03.26--11:05
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class OrderPresenter {

    private final OrderModel orderModel;
    private final OrderView orderView;

    public OrderPresenter(OrderView view) {

        orderModel = new OrderModel();

        orderView = view;
    }

    //    一级
    public void orderone() {

        orderModel.orderone();
        orderModel.setOneOrderLisenter(new OrderModel.onOneOrderLisenter() {
            @Override
            public void oneOrder(OneOrderBean oneOrderBean) {
                orderView.getViewData(oneOrderBean);
            }
        });
    }

    //    二级
    public void ordertwo(String firstCategoryId) {

        orderModel.ordertwo(firstCategoryId);

        orderModel.setTwoOederLisenter(new OrderModel.onTwoOederLisenter() {
            @Override
            public void twoOrder(TwoOrdeBean twoOrdeBean) {
                orderView.getViewDatas(twoOrdeBean);
            }
        });
    }
}
