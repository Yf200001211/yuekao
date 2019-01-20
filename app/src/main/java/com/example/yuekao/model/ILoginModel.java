package com.example.yuekao.model;

import java.util.Map;

public interface ILoginModel {
    void getData(String url,String name,String pwd,GetLoginCallBack getLoginCallBack);
    public interface GetLoginCallBack{
        void succ(String data);
    }
    void getZhuData(String url,String name,String pwd,GetZhuCallBack getZhuCallBack);
    public interface GetZhuCallBack{
        void succ(String data);
    }
    void getGouData(String url, Map map, GetGouCallBack getGouCallBack);
    public interface GetGouCallBack{
        void succ(Object data);
    }
    void getShowData(String url, GetShowCallBack getShowCallBack);
    public interface GetShowCallBack{
        void succ(Object data);
    }
    void getBanData(String url, GetBanCallBack getBanCallBack);
    public interface GetBanCallBack{
        void succ(Object data);
    }
    void getLeftData(String url, GetLeftCallBack getLeftCallBack);
    public interface GetLeftCallBack{
        void succ(Object data);
    }
    void getRightData(String url, GetRightCallBack getRightCallBack);
    public interface GetRightCallBack{
        void succ(Object data);
    }
}
