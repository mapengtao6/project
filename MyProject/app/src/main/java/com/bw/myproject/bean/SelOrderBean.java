package com.bw.myproject.bean;

import java.util.List;

/**
 * Time:2019.03.26--14:31
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class SelOrderBean {


    /**
     * result : [{"commodityId":91,"commodityName":"冬季新品女款长款派克棉服","masterPic":"http://172.17.8.100/images/small/commodity/nz/wt/6/1.jpg","price":509,"saleNum":0},{"commodityId":88,"commodityName":"冬新品 梵希蔓毛呢外套女短款长袖2018冬季新款宽松英伦格子翻领斜门襟大衣女","masterPic":"http://172.17.8.100/images/small/commodity/nz/wt/3/1.jpg","price":358,"saleNum":0},{"commodityId":90,"commodityName":"女款气质女神斗篷披肩蝙蝠衫毛呢外套","masterPic":"http://172.17.8.100/images/small/commodity/nz/wt/5/1.jpg","price":396,"saleNum":0},{"commodityId":87,"commodityName":"秋季新款韩版女装短外套秋装春秋冬学院风休闲简约宽松拼接长袖短外套","masterPic":"http://172.17.8.100/images/small/commodity/nz/wt/2/1.jpg","price":358,"saleNum":0},{"commodityId":92,"commodityName":"冬季新款女款轻薄羽绒服女短款外套女纯色简约百搭保暖女上衣新品女装外套","masterPic":"http://172.17.8.100/images/small/commodity/nz/wt/7/1.jpg","price":229,"saleNum":0}]
     * message : 查询成功
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
         * commodityId : 91
         * commodityName : 冬季新品女款长款派克棉服
         * masterPic : http://172.17.8.100/images/small/commodity/nz/wt/6/1.jpg
         * price : 509
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
