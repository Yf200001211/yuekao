package com.example.yuekao.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.yuekao.R;
import com.example.yuekao.adapter.MyShowAdapter;
import com.example.yuekao.api.Api;
import com.example.yuekao.bean.HomeBean;
import com.example.yuekao.presenter.LoginPresenter;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

public class OneFragment extends Fragment {
    private RecyclerView shoucey;
    private LoginPresenter loginPresenter;
    private XBanner xbanner;
    private MyShowAdapter myShowAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one_layout, container, false);
        shoucey = view.findViewById(R.id.shoucey);
        xbanner = view.findViewById(R.id.xbanner);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        shoucey.setLayoutManager(linearLayoutManager);
        shoucey.setAdapter(myShowAdapter);
        loginPresenter = new LoginPresenter(this);
        loginPresenter.getShouData();
        loginPresenter.getBanData();
        return view;
    }
    public void getShouData(Object oj){
        HomeBean homeBean= (HomeBean) oj;
        myShowAdapter = new MyShowAdapter(getActivity(), homeBean);
        shoucey.setAdapter(myShowAdapter);
    }
    public void getImgData(Object oj){
        final List<String> list = new ArrayList<>();
        HomeBean homeBean = (HomeBean) oj;
        List<HomeBean.DataBean.BannerBean> banner = homeBean.getData().getBanner();
        for (int i = 0; i < banner.size(); i++) {
            list.add(banner.get(i).getIcon());
        }
        xbanner.setData(list, null);
        xbanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(getActivity()).load(list.get(position)).into((ImageView) view);
            }
        });
        xbanner.setPageTransformer(Transformer.Default);
        xbanner.setPageChangeDuration(1000);
    }
}
