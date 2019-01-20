package com.example.yuekao.model;

import android.util.Log;

import com.example.yuekao.bean.CarBean;
import com.example.yuekao.bean.HomeBean;
import com.example.yuekao.bean.JsonBean;
import com.example.yuekao.bean.LeftBean;
import com.example.yuekao.okhttp.HttpUtils;
import com.example.yuekao.okhttp.OkHttp3;

import java.util.Map;

public class LoginModel implements ILoginModel {
    @Override
    public void getData(String url, String name, String pwd, final GetLoginCallBack getLoginCallBack) {
        OkHttp3.okHttpPost(url, name, pwd, new OkHttp3.GetBackPost() {
            @Override
            public void getTrue(String succ) {
             getLoginCallBack.succ(succ);
                Log.i( "onSuccessstrj: ",succ);


            }
        });
    }

    @Override
    public void getZhuData(String url, String name, String pwd, final GetZhuCallBack getZhuCallBack) {
        OkHttp3.okHttpPost(url, name, pwd, new OkHttp3.GetBackPost() {
            @Override
            public void getTrue(String succ) {
                getZhuCallBack.succ(succ);
            }
        });
    }

    @Override
    public void getGouData(String url, Map map, final GetGouCallBack getGouCallBack) {
        HttpUtils.getInstance().doPost(url, CarBean.class, map, new HttpUtils.NetCallBack() {
            @Override
            public void onSuccess(Object oj) {
                getGouCallBack.succ(oj);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    @Override
    public void getShowData(String url, final GetShowCallBack getShowCallBack) {
       HttpUtils.getInstance().doGet(url, HomeBean.class, new HttpUtils.NetCallBack() {
           @Override
           public void onSuccess(Object oj) {
               getShowCallBack.succ(oj);

           }

           @Override
           public void onFailure(Exception e) {

           }
       });

    }

    @Override
    public void getBanData(String url, final GetBanCallBack getBanCallBack) {
HttpUtils.getInstance().doGet(url, HomeBean.class, new HttpUtils.NetCallBack() {
    @Override
    public void onSuccess(Object oj) {
        getBanCallBack.succ(oj);
    }

    @Override
    public void onFailure(Exception e) {

    }
});
    }

    @Override
    public void getLeftData(String url, final GetLeftCallBack getLeftCallBack) {
        HttpUtils.getInstance().doGet(url, LeftBean.class, new HttpUtils.NetCallBack() {
            @Override
            public void onSuccess(Object oj) {
                getLeftCallBack.succ(oj);
                Log.i( "succsleft: ",oj.toString());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    @Override
    public void getRightData(String url, final GetRightCallBack getRightCallBack) {
        HttpUtils.getInstance().doGet(url, JsonBean.class,new HttpUtils.NetCallBack() {
            @Override
            public void onSuccess(Object oj) {
           getRightCallBack.succ(oj);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
