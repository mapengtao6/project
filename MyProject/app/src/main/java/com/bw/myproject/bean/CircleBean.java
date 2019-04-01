package com.bw.myproject.bean;

import java.util.List;

/**
 * Time:2019.03.29--22:00
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class CircleBean {


    /**
     * result : [{"commodityId":1,"content":"挺好的","createTime":1553886068000,"greatNum":28,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":796,"image":"","nickName":"BU_95665","userId":480,"whetherGreat":2},{"commodityId":1,"content":"给大家推荐一个好商品","createTime":1553885087000,"greatNum":7,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":795,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-29/8739220190329134447.jpg","nickName":"Pg_68Q55","userId":337,"whetherGreat":2},{"commodityId":1,"content":"给大家推荐一个好商品","createTime":1553878233000,"greatNum":3,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":794,"image":"","nickName":"az_hYDvr","userId":345,"whetherGreat":2},{"commodityId":1,"content":"挺好的","createTime":1553875642000,"greatNum":41,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":793,"image":"","nickName":"BU_95665","userId":480,"whetherGreat":2},{"commodityId":1,"content":"emmmmmm","createTime":1553822579000,"greatNum":60,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-28/20190328194514.jpg","id":792,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-28/0329820190328202259.jpg","nickName":"冬天的风","userId":8,"whetherGreat":2},{"commodityId":1,"content":"emmmmmmmmm","createTime":1553736301000,"greatNum":69,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-28/20190328194514.jpg","id":791,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-27/5781020190327202501.jpg","nickName":"冬天的风","userId":8,"whetherGreat":2},{"commodityId":1,"content":"元气满满","createTime":1553266525000,"greatNum":97,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-26/20190326142936.png","id":790,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-22/6731420190322095525.png","nickName":"2A_dE4I6","userId":752,"whetherGreat":2},{"commodityId":1,"content":"wkq","createTime":1553218505000,"greatNum":2799,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":789,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-21/6128320190321203505.png","nickName":"HA_DM5T9","userId":11,"whetherGreat":2},{"commodityId":1,"content":"元气满满","createTime":1553216151000,"greatNum":215,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-26/20190326142936.png","id":788,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-21/2380920190321195551.png","nickName":"2A_dE4I6","userId":752,"whetherGreat":2},{"commodityId":1,"content":"????","createTime":1552607214000,"greatNum":4,"headPic":"http://172.17.8.100/images/small/head_pic/2019-03-29/20190329144408.jpg","id":787,"image":"http://172.17.8.100/images/small/circle_pic/2019-03-14/2346920190314184654.jpg","nickName":"hehe","userId":1636,"whetherGreat":2}]
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
         * commodityId : 1
         * content : 挺好的
         * createTime : 1553886068000
         * greatNum : 28
         * headPic : http://172.17.8.100/images/small/default/user.jpg
         * id : 796
         * image :
         * nickName : BU_95665
         * userId : 480
         * whetherGreat : 2
         */

        private String commodityId;
        private String content;
        private long createTime;
        private String greatNum;
        private String headPic;
        private String id;
        private String image;
        private String nickName;
        private String userId;
        private String whetherGreat;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "commodityId='" + commodityId + '\'' +
                    ", content='" + content + '\'' +
                    ", createTime=" + createTime +
                    ", greatNum='" + greatNum + '\'' +
                    ", headPic='" + headPic + '\'' +
                    ", id='" + id + '\'' +
                    ", image='" + image + '\'' +
                    ", nickName='" + nickName + '\'' +
                    ", userId='" + userId + '\'' +
                    ", whetherGreat='" + whetherGreat + '\'' +
                    '}';
        }

        public String getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(String commodityId) {
            this.commodityId = commodityId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(String greatNum) {
            this.greatNum = greatNum;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getWhetherGreat() {
            return whetherGreat;
        }

        public void setWhetherGreat(String whetherGreat) {
            this.whetherGreat = whetherGreat;
        }
    }
}
