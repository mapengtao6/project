package com.bw.myproject.bean;

import java.util.List;

/**
 * Time:2019.03.21--15:22
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class SearchBean {


    /**
     * message : 查询成功
     * result : [{"commodityId":43,"commodityName":"舒适百搭浅口一字带休闲鞋高跟鞋女鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/ggx/5/1.jpg","price":156,"saleNum":0},{"commodityId":42,"commodityName":"【清仓】浅口尖头中空交叉带单鞋高跟鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/ggx/4/1.jpg","price":99,"saleNum":0},{"commodityId":44,"commodityName":"新品女鞋秋冬水钻粗跟深口单鞋新款夏季网红同款高跟鞋仙女的鞋超火的鞋子婚鞋韩版百搭乖乖鞋温柔鞋尖头晚晚鞋一脚蹬","masterPic":"http://172.17.8.100/images/small/commodity/nx/ggx/6/1.jpg","price":146,"saleNum":0},{"commodityId":39,"commodityName":"热销爆款人气女鞋单鞋时尚金属装饰女高跟鞋尖头浅口中空单鞋通勤百搭粗跟高跟鞋女单鞋女鞋高跟方跟套脚单鞋办公室约会气质百搭","masterPic":"http://172.17.8.100/images/small/commodity/nx/ggx/1/1.jpg","price":158,"saleNum":0}]
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 43
         * commodityName : 舒适百搭浅口一字带休闲鞋高跟鞋女鞋
         * masterPic : http://172.17.8.100/images/small/commodity/nx/ggx/5/1.jpg
         * price : 156
         * saleNum : 0
         */

        private String commodityId;
        private String commodityName;
        private String masterPic;
        private String price;
        private String saleNum;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "commodityId='" + commodityId + '\'' +
                    ", commodityName='" + commodityName + '\'' +
                    ", masterPic='" + masterPic + '\'' +
                    ", price='" + price + '\'' +
                    ", saleNum='" + saleNum + '\'' +
                    '}';
        }

        public String getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(String commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public String getMasterPic() {
            return masterPic;
        }

        public void setMasterPic(String masterPic) {
            this.masterPic = masterPic;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(String saleNum) {
            this.saleNum = saleNum;
        }
    }
}
