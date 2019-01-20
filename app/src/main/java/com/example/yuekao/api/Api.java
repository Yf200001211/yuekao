package com.example.yuekao.api;

public class Api {
    public static final String BASE_URL="http://172.17.8.100";
    //首页商品信息列表
    public static String SHOPLIST=BASE_URL+"/small/commodity/v1/commodityList";
    public static String XBANNER=BASE_URL+"/small/commodity/v1/bannerShow";
    //登录接口
    public static String LOGIN=BASE_URL+"/small/user/v1/login";
    public static String Zhu=BASE_URL+"/small/user/v1/register";
    public static String HAHA= "http://api.expoon.com/AppNews/getNewsList/type/1/p?page=1";
    public static String XIANG= "http://172.17.8.100/small/commodity/v1/findCommodityDetailsById";
    public static String QUAN= " http://172.17.8.100/small/circle/v1/findCircleList";
    //购物车
    public static final String GOUWUCHE = "http://www.zhaoapi.cn/product/getCarts";
    public static final String LOGINZHAO ="http://120.27.23.105/user/login";
    public static final String ZHUCE ="http://120.27.23.105/user/reg";

    public static String left="http://www.zhaoapi.cn/product/getCatagory";
    public static String right="http://www.zhaoapi.cn/product/getProductCatagory";


}
