package com.example.yuekao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yuekao.R;
import com.example.yuekao.bean.HomeBean;

class TwoShowAdapter extends RecyclerView.Adapter {
    private Context context;
    private HomeBean.DataBean.MiaoshaBean miaosha;
    private MyTwoViewHodelr myTwoViewHodelr;

    public TwoShowAdapter(Context context, HomeBean.DataBean.MiaoshaBean miaosha) {
        this.context=context;
        this.miaosha=miaosha;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.layout_list2, null);
        myTwoViewHodelr = new TwoShowAdapter.MyTwoViewHodelr(view);
        return myTwoViewHodelr;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        myTwoViewHodelr.name.setText(miaosha.getList().get(i).getTitle());
        myTwoViewHodelr.price.setText(miaosha.getList().get(i).getPrice());
        Glide.with(context).load(miaosha.getList().get(i).getImages()).into(myTwoViewHodelr.img);
    }

    @Override
    public int getItemCount() {
        return miaosha.getList().size();
    }

    public class MyTwoViewHodelr extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView price;
        public MyTwoViewHodelr(View view) {
            super(view);
            img = itemView.findViewById(R.id.image2);
            price = itemView.findViewById(R.id.price2);
            name =  itemView.findViewById(R.id.title2);
        }
    }
}
