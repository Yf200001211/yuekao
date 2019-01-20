package com.example.yuekao;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.yuekao.fragment.OneFragment;
import com.example.yuekao.fragment.SanFragment;
import com.example.yuekao.fragment.SiFragment;
import com.example.yuekao.fragment.TwoFragment;
import com.example.yuekao.fragment.WuFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class ShowActivity extends AppCompatActivity {

    private BottomTabBar fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        fragment = findViewById(R.id.fragment);
        fragment.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(16)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("首页",R.drawable.fangs,OneFragment.class)
                .addTabItem("分类",R.drawable.ufos,TwoFragment.class)
                .addTabItem("购物车",R.drawable.ufos,SiFragment.class)
                .addTabItem("订单",R.drawable.fangs,SanFragment.class)
                .addTabItem("我的",R.drawable.my,WuFragment.class)
                .isShowDivider(false);

    }
}
