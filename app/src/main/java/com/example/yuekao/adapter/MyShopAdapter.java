package com.example.yuekao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yuekao.R;
import com.example.yuekao.bean.CarBean;
import com.example.yuekao.view.CustomAddView;

import java.util.List;

public class MyShopAdapter extends RecyclerView.Adapter<MyShopAdapter.MyShopViewHolder> {
    private Context context;
    private List<CarBean.DataBean.ListBean> beanList;

    public MyShopAdapter(Context context, List<CarBean.DataBean.ListBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @NonNull
    @Override
    public MyShopViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.shop_layout, null);
        MyShopViewHolder myShopViewHolder = new MyShopViewHolder(view);
        return myShopViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyShopViewHolder myShopViewHolder, final int i) {
        myShopViewHolder.name.setText(beanList.get(i).getTitle());
        myShopViewHolder.price.setText(beanList.get(i).getPrice()+"");
        Glide.with(context).load((beanList.get(i).getImages()).split("\\|")[0].replace("https", "http")).into(myShopViewHolder.img);
        myShopViewHolder.addview.setData(myShopViewHolder,beanList,i);
        //获取自己的状态
        myShopViewHolder.shop_check.setChecked(beanList.get(i).isCheck());
        myShopViewHolder.shop_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //点击事件后改变自己的状态
               beanList.get(i).setCheck(isChecked);
               if (mShopCallBackListener!=null){
                   mShopCallBackListener.callBack();
               }
            }
        });
        myShopViewHolder.addview.setData(myShopViewHolder,beanList,i);
        myShopViewHolder.addview.setOnCallBack(new CustomAddView.CallBackListener() {
            @Override
            public void callBack() {
                if (mShopCallBackListener!=null){
                    mShopCallBackListener.callBack();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class MyShopViewHolder extends RecyclerView.ViewHolder {
        CustomAddView addview;
        CheckBox shop_check;
        ImageView img;
        TextView name;
        TextView price;
        public MyShopViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageshop);
            price = itemView.findViewById(R.id.priceshop);
            name =  itemView.findViewById(R.id.titleshop);
            shop_check = itemView.findViewById(R.id.shop_check);
            addview = itemView.findViewById(R.id.addview);
        }
    }
    //商品的选中与否
    public void shangPinXuanFou(boolean isSelectAll) {
        for (CarBean.DataBean.ListBean listBean : beanList) {
            listBean.setCheck(isSelectAll);
        }
        notifyDataSetChanged();
    }
    //自定义接口
    private ShopCallBackListener mShopCallBackListener;

    public void setListener(ShopCallBackListener listener) {
        this.mShopCallBackListener = listener;
    }

    public interface ShopCallBackListener {
        void callBack();
    }

}
