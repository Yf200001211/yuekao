package com.example.yuekao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.yuekao.R;
import com.example.yuekao.bean.CarBean;

import java.util.ArrayList;
import java.util.List;

public class MyCarAdapter extends RecyclerView.Adapter<MyCarAdapter.MyCarViewHolder> {
    private Context context;
    private List<CarBean.DataBean> mlist = new ArrayList<>();

    public MyCarAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyCarViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.car_layout_sj, null);
        MyCarViewHolder myCarViewHolder = new MyCarViewHolder(view);
        return myCarViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyCarViewHolder myCarViewHolder, final int i) {
     myCarViewHolder.shangj.setText(mlist.get(i).getSellerName());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
       myCarViewHolder.shop_cey.setLayoutManager(linearLayoutManager);
        final List<CarBean.DataBean.ListBean> beanList = mlist.get(i).getList();
        final MyShopAdapter myShopAdapter = new MyShopAdapter(context, beanList);
        myCarViewHolder.shop_cey.setAdapter(myShopAdapter);
        //获取商家自己的状态
        myCarViewHolder.sj_check.setChecked(beanList.get(i).isCheck());
        myShopAdapter.setListener(new MyShopAdapter.ShopCallBackListener() {
            @Override
            public void callBack() {
                if (mShopCallBackListener!=null){
                    mShopCallBackListener.callBack(mlist);
                }
                List<CarBean.DataBean.ListBean> listbean = beanList;
                boolean isAllChecked =true;
                for (CarBean.DataBean.ListBean bean : listbean){
               if (!bean.isCheck()){
                   isAllChecked=false;
                   break;
               }
                }
                myCarViewHolder.sj_check.setChecked(isAllChecked);
                mlist.get(i).setCheck(isAllChecked);
            }
        });
        //商家的复选框点击事件
        myCarViewHolder.sj_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beanList.get(i).setCheck(myCarViewHolder.sj_check.isChecked());
                myShopAdapter.shangPinXuanFou(myCarViewHolder.sj_check.isChecked());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }



    public class MyCarViewHolder extends RecyclerView.ViewHolder {
        private TextView shangj;
        private CheckBox sj_check;
        private RecyclerView shop_cey;

        public MyCarViewHolder(@NonNull View itemView) {
            super(itemView);
            sj_check = itemView.findViewById(R.id.check);
            shangj = itemView.findViewById(R.id.shangj);
            shop_cey = itemView.findViewById(R.id.shop_cey);
        }
    }
    public void setList(List<CarBean.DataBean> list) {
        this.mlist = list;
        notifyDataSetChanged();
    }
    //自定义接口
    private ShopCallBackListener mShopCallBackListener;

    public void setListener(ShopCallBackListener listener) {
        this.mShopCallBackListener = listener;
    }

    public interface ShopCallBackListener {
        void callBack(List<CarBean.DataBean> list);
    }
}
