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

class SanShowAdapter extends RecyclerView.Adapter{
    private Context context;
    private HomeBean.DataBean.TuijianBean tuijian;
    private MySanViewHodelr mySanViewHodelr;

    public SanShowAdapter(Context context, HomeBean.DataBean.TuijianBean tuijian) {
        this.context=context;
        this.tuijian=tuijian;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.layout_list3, null);
        mySanViewHodelr = new SanShowAdapter.MySanViewHodelr(view);
        return mySanViewHodelr;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        mySanViewHodelr.name.setText(tuijian.getList().get(i).getTitle());
        mySanViewHodelr.price.setText(tuijian.getList().get(i).getPrice());
        Glide.with(context).load(tuijian.getList().get(i).getImages()).into(mySanViewHodelr.img);
    }

    @Override
    public int getItemCount() {
        return tuijian.getList().size();
    }

    public class MySanViewHodelr extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView price;
        public MySanViewHodelr(View view) {
            super(view);
            img = itemView.findViewById(R.id.image3);
            price = itemView.findViewById(R.id.price3);
            name =  itemView.findViewById(R.id.title3);
        }
    }
}
