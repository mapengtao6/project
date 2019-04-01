package com.bw.myproject.presenter;

import com.bw.myproject.bean.CircleBean;
import com.bw.myproject.fragment.CircleFragment;
import com.bw.myproject.model.CircleModel;
import com.bw.myproject.view.CircleView;

/**
 * Time:2019.03.30--14:53
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class CirclePresenter {

    private final CircleModel circleModel;
    private final CircleView circleView;

    public CirclePresenter(CircleView view) {

        circleModel = new CircleModel();

        circleView = view;
    }

    public void circle(int page, int count) {

        circleModel.circle(page, count);
        circleModel.setCircleLisenter(new CircleModel.onCircleLisenter() {
            @Override
            public void Circle(CircleBean circleBean) {
                circleView.getCiecle(circleBean);
            }
        });
    }
}
