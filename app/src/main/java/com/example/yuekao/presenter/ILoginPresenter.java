package com.example.yuekao.presenter;

import java.util.Map;

public interface ILoginPresenter {
    void getModelData(String name,String pwd);
    void getZhuData(String name,String pwd);
    void getGouData(String url,Map map);
    void getShouData();
    void getBanData();
    void getLeftData();
    void getRightData(String cid);
}
