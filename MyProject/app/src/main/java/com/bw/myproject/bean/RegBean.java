package com.bw.myproject.bean;

/**
 * Time:2019.03.23--15:50
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class RegBean {


    /**
     * message : 注册成功
     * status : 0000
     */

    private String message;
    private String status;

    @Override
    public String toString() {
        return "RegBean{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

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
}
