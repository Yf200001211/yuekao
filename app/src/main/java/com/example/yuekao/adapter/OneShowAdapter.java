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

import java.util.List;

class OneShowAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<HomeBean.DataBean.FenleiBean> fenlei;
    private MyOneViewHodelr myOneViewHodelr;

    public OneShowAdapter(Context context, List<HomeBean.DataBean.FenleiBean> fenlei) {
        this.context = context;
        this.fenlei = fenlei;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.layout_list, null);
        myOneViewHodelr = new OneShowAdapter.MyOneViewHodelr(view);
        return myOneViewHodelr;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        myOneViewHodelr.name.setText(fenlei.get(i).getName());
        Glide.with(context).load(fenlei.get(i).getIcon()).into(myOneViewHodelr.img);
    }

    @Override
    public int getItemCount() {
        return fenlei.size();
    }

    public class MyOneViewHodelr extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView price;
        public MyOneViewHodelr(View view) {
            super(view);
            img = itemView.findViewById(R.id.image);
            price = itemView.findViewById(R.id.price);
            name =  itemView.findViewById(R.id.title);
        }
    }
}
