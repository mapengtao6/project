package com.bw.myproject.api;

/**
 * Time:2019.03.20--19:07
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class Api {

    //    域名
//    http://172.17.8.100/small/commodity/v1/commodityList
    public static final String Base_Url = "http://172.17.8.100/";


    //    主页
    public static final String Home_Url = "small/commodity/v1/commodityList";

    //    搜索
    public static final String Search_Url = "small/commodity/v1/findCommodityByKeyword";

    //    详情
    public static final String Detals_Url = "small/commodity/v1/findCommodityDetailsById";

    //    注册
    public static final String Regist_Url = "small/user/v1/register";

    //    登录
    public static final String Login_Url = "small/user/v1/login";

    //    分类一级
    //    http://172.17.8.100/small/commodity/v1/findFirstCategory
    public static final String Order_Url = "small/commodity/v1/findFirstCategory";

    //    分类二级
//    http://172.17.8.100/small/commodity/v1/findSecondCategory?firstCategoryId=1001003
    public static final String OrderTwo_Url = "small/commodity/v1/findSecondCategory";

    //    分类二级查询
//    http://172.17.8.100/small/commodity/v1/findCommodityByCategory?page=1&count=5&categoryId=1001002001;
    public static final String OrderSel_Url = "small/commodity/v1/findCommodityByCategory?page=1&count=5";

    //    查询购物车
//    http://172.17.8.100/small/order/verify/v1/findShoppingCart
    public static final String Shop_Sel = "small/order/verify/v1/findShoppingCart";

    //    同步购物车
//    http://172.17.8.100/small/order/verify/v1/syncShoppingCart
    public static final String SynShop = "small/order/verify/v1/syncShoppingCart";

    //    圈子
//    http://172.17.8.100/small/circle/v1/findCircleList
    public static final String Circle_Url = "small/circle/v1/findCircleList";

    //    收货地址列表
//    http://172.17.8.100/small/user/verify/v1/receiveAddressList
    public static final String ShopAddress = "small/user/verify/v1/receiveAddressList";
}
