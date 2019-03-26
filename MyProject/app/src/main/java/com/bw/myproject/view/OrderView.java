package com.bw.myproject.view;

import com.bw.myproject.bean.OneOrderBean;
import com.bw.myproject.bean.TwoOrdeBean;

/**
 * Time:2019.03.26--11:36
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public interface OrderView {

    void getViewData(OneOrderBean oneOrderBean);

    void getViewDatas(TwoOrdeBean twoOrdeBean);

}
