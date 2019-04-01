package com.bw.myproject.bean;

import java.util.List;

/**
 * Time:2019.03.30--16:10
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class ShopAddressBean {


    /**
     * result : [{"address":"北京 海淀区 八维\n\n\n","createTime":1553980142000,"id":2197,"phone":"18301461582","realName":"表叔","userId":304,"whetherDefault":1,"zipCode":"101010"}]
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
         * address : 北京 海淀区 八维
         * <p>
         * <p>
         * <p>
         * createTime : 1553980142000
         * id : 2197
         * phone : 18301461582
         * realName : 表叔
         * userId : 304
         * whetherDefault : 1
         * zipCode : 101010
         */

        private String address;
        private long createTime;
        private String id;
        private String phone;
        private String realName;
        private String userId;
        private String whetherDefault;
        private String zipCode;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "address='" + address + '\'' +
                    ", createTime=" + createTime +
                    ", id='" + id + '\'' +
                    ", phone='" + phone + '\'' +
                    ", realName='" + realName + '\'' +
                    ", userId='" + userId + '\'' +
                    ", whetherDefault='" + whetherDefault + '\'' +
                    ", zipCode='" + zipCode + '\'' +
                    '}';
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getWhetherDefault() {
            return whetherDefault;
        }

        public void setWhetherDefault(String whetherDefault) {
            this.whetherDefault = whetherDefault;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }
    }
}
