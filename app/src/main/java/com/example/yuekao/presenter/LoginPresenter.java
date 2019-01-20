package com.example.yuekao.presenter;

import android.util.Log;

import com.example.yuekao.MainActivity;
import com.example.yuekao.ZhuActivity;
import com.example.yuekao.api.Api;
import com.example.yuekao.fragment.OneFragment;
import com.example.yuekao.fragment.SiFragment;
import com.example.yuekao.fragment.TwoFragment;
import com.example.yuekao.model.ILoginModel;
import com.example.yuekao.model.LoginModel;

import java.util.Map;


public class LoginPresenter implements ILoginPresenter {
    private MainActivity mainActivity;
    private LoginModel loginModel;
    ZhuActivity zhuActivity;
    SiFragment siFragment;
    OneFragment oneFragment;
    TwoFragment twoFragment;

    public LoginPresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        loginModel = new LoginModel();
    }
    public LoginPresenter(ZhuActivity zhuActivity) {
        this.zhuActivity = zhuActivity;
        loginModel = new LoginModel();
    }
    public LoginPresenter(SiFragment siFragment) {
        this.siFragment = siFragment;
        loginModel = new LoginModel();
    }
    public LoginPresenter(OneFragment oneFragment) {
        this.oneFragment = oneFragment;
        loginModel = new LoginModel();
    }
    public LoginPresenter(TwoFragment twoFragment) {
        this.twoFragment = twoFragment;
        loginModel = new LoginModel();
    }

    @Override
    public void getModelData(String name, String pwd) {
        loginModel.getData("http://www.zhaoapi.cn/user/login", name, pwd, new ILoginModel.GetLoginCallBack() {
            @Override
            public void succ(String data) {
              mainActivity.getLoginData(data);
            }
        });
    }

    @Override
    public void getZhuData(String name, String pwd) {
        loginModel.getZhuData("http://www.zhaoapi.cn/user/reg", name, pwd, new ILoginModel.GetZhuCallBack() {
            @Override
            public void succ(String data) {
             zhuActivity.getZhuData(data);

            }
        });
    }

    @Override
    public void getGouData(String url,Map map) {
        loginModel.getGouData(url, map, new ILoginModel.GetGouCallBack() {
            @Override
            public void succ(Object data) {
            siFragment.getGouData(data);
            }
        });
    }

    @Override
    public void getShouData() {
     loginModel.getShowData("http://120.27.23.105/home/getHome", new ILoginModel.GetShowCallBack() {
         @Override
         public void succ(Object data) {
        oneFragment.getShouData(data);
             Log.i( "succshou: ",data.toString());
         }
     });
    }

    @Override
    public void getBanData() {
        loginModel.getBanData("http://120.27.23.105/home/getHome", new ILoginModel.GetBanCallBack() {
            @Override
            public void succ(Object data) {
                oneFragment.getImgData(data);
            }
        });
    }

    @Override
    public void getLeftData() {
        loginModel.getLeftData("http://www.zhaoapi.cn/product/getCatagory", new ILoginModel.GetLeftCallBack() {
            @Override
            public void succ(Object data) {
                twoFragment.getLeftData(data);
            }
        });
    }

    @Override
    public void getRightData(String cid) {
        loginModel.getRightData("http://www.zhaoapi.cn/product/getProductCatagory" + "?cid=" + cid, new ILoginModel.GetRightCallBack() {
            @Override
            public void succ(Object data) {
                twoFragment.getRightData(data);
            }
        });
    }
}
