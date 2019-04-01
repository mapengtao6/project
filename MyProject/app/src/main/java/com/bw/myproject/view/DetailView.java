package com.bw.myproject.view;

import com.bw.myproject.bean.DetailBean;
import com.bw.myproject.bean.ShopSelBean;

/**
 * Time:2019.03.24--14:49
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public interface DetailView {

//    详情
    void Detail(DetailBean detailBean);

//    购物车
    void ShopSel(ShopSelBean shopSelBean);
}
