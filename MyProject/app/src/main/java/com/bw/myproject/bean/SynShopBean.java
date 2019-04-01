package com.bw.myproject.bean;

/**
 * Time:2019.03.29--13:41
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:同步购物车
 */
public class SynShopBean {

    private int commodityId;
    private int count;

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public SynShopBean(int commodityId, int count) {

        this.commodityId = commodityId;
        this.count = count;
    }
}
