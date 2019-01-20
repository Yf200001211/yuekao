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
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.yuekao.R;
import com.example.yuekao.adapter.MyCarAdapter;
import com.example.yuekao.api.Api;
import com.example.yuekao.bean.CarBean;
import com.example.yuekao.presenter.LoginPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SiFragment extends Fragment implements View.OnClickListener {
    private LoginPresenter loginPresenter;
    private RecyclerView carrey;
    private Map<Object,Object> map;
    private MyCarAdapter myCarAdapter;
    private List<CarBean.DataBean> mList = new ArrayList<>();
    private CheckBox qx;
    private TextView count,total;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.si_layout, container, false);
        carrey = view.findViewById(R.id.carrey);
        qx = view.findViewById(R.id.qx);
        qx.setOnClickListener(this);
        count = view.findViewById(R.id.count);
        total=view.findViewById(R.id.total);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        carrey.setLayoutManager(linearLayoutManager);
        getData();
        return view;
    }

    private void getData() {
        loginPresenter = new LoginPresenter(this);
        map = new HashMap<>();
        map.put("uid","71");
        loginPresenter.getGouData(Api.GOUWUCHE,map);
    }
    public void getGouData(Object oj){
        if (oj instanceof CarBean){
            CarBean carBean= (CarBean) oj;
            mList = carBean.getData();
            myCarAdapter = new MyCarAdapter(getActivity());
            carrey.setAdapter(myCarAdapter);
            if (mList != null) {
                mList.remove(0);
                myCarAdapter.setList(mList);
            }
            myCarAdapter.setListener(new MyCarAdapter.ShopCallBackListener() {
                @Override
                public void callBack(List<CarBean.DataBean> list) {
                    double totalPrice = 0;
                    int num = 0;
                    int totalNum = 0;
                    for (int a = 0; a < list.size(); a++) {
                        List<CarBean.DataBean.ListBean> listAll = list.get(a).getList();
                        for (int i = 0; i < listAll.size(); i++) {
                            totalNum = totalNum + listAll.get(i).getNum();
                            if (listAll.get(i).isCheck()) {
                                totalPrice = totalPrice + (listAll.get(i).getPrice() * listAll.get(i).getNum());
                                num = num + listAll.get(i).getNum();
                            }
                        }
                    }

                    if (num < totalNum) {
                        qx.setChecked(false);
                    } else {
                        qx.setChecked(true);
                    }

                    total.setText("合计：" + totalPrice);
                    count.setText("去结算(" + num + ")");
                }

            });


        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.qx:
                checkSeller(qx.isChecked());
                myCarAdapter.notifyDataSetChanged();
                break;
            default:

        }
    }

    private void checkSeller(boolean bool) {
        double totalPrice = 0;
        int num = 0;
        for (int a = 0; a < mList.size(); a++) {
            CarBean.DataBean dataBean = mList.get(a);
            dataBean.setCheck(bool);
            List<CarBean.DataBean.ListBean> listAll = mList.get(a).getList();
            for (int i = 0; i < listAll.size(); i++) {
                listAll.get(i).setCheck(bool);
                totalPrice = totalPrice + (listAll.get(i).getPrice() * listAll.get(i).getNum());
                num = num + listAll.get(i).getNum();
            }
        }

        if (bool) {
            total.setText("合计：" + totalPrice);
            count.setText("去结算(" + num + ")");
        } else {
            total.setText("合计：0.00");
            count.setText("去结算(0)");
        }
    }
}
