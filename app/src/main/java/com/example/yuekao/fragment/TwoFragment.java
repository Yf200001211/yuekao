package com.example.yuekao.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yuekao.R;
import com.example.yuekao.adapter.MyLeftAdapter;
import com.example.yuekao.adapter.MyRightAdapter;
import com.example.yuekao.bean.JsonBean;
import com.example.yuekao.bean.LeftBean;
import com.example.yuekao.presenter.LoginPresenter;

import java.util.List;

public class TwoFragment extends Fragment {
    private RecyclerView right,left;
    private LoginPresenter loginPresenter;
    private MyLeftAdapter myLeftAdapter;
    private MyRightAdapter myRightAdapter;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.two_layout, container, false);
        left = view.findViewById(R.id.left_cey);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        left.setLayoutManager(linearLayoutManager);
        right = view.findViewById(R.id.right_cey);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity());
        linearLayoutManager2.setOrientation(OrientationHelper.VERTICAL);
        right.setLayoutManager(linearLayoutManager2);
        loginPresenter = new LoginPresenter(this);
        loginPresenter.getLeftData();
        loginPresenter.getRightData("1");
        return view;
    }
    public  void getLeftData(Object oj){
        LeftBean leftBean= (LeftBean) oj;
//        Log.i("getLeftData: ",oj.toString());
        myLeftAdapter = new MyLeftAdapter(getActivity(), leftBean);
        myLeftAdapter.setLeftOnclickListenner(new MyLeftAdapter.LeftOnclickListenner() {
            @Override
            public void onLeftItemClick(int i, List<LeftBean.DataBean> dataBeanList) {
                loginPresenter.getRightData(dataBeanList.get(i).getCid());
                myRightAdapter.notifyDataSetChanged();
            }
        });
        left.setAdapter(myLeftAdapter);
    }
    public  void getRightData(Object oj){
        JsonBean jsonBean= (JsonBean) oj;
        Log.i("getRightData: ",oj.toString());
        myRightAdapter = new MyRightAdapter(getActivity(), jsonBean);
        right.setAdapter(myRightAdapter);
    }
}
