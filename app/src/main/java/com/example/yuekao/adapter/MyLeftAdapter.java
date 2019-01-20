package com.example.yuekao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.yuekao.R;
import com.example.yuekao.bean.LeftBean;

import java.util.List;

public class MyLeftAdapter extends RecyclerView.Adapter<MyLeftAdapter.LeftViewHolder> {
    LeftBean left;
    Context con;
    private LayoutInflater mInflater;
    private List<LeftBean.DataBean> list;
    private View inflate;

    private LeftOnclickListenner leftOnclickListenner;
    public void setLeftOnclickListenner(LeftOnclickListenner listener){
        leftOnclickListenner=listener;
    }

    public MyLeftAdapter(Context context, LeftBean leftBean) {
        this.mInflater = LayoutInflater.from(context);
        this.con = context;
        this.left = leftBean;
    }

    //创建子view视图
    @NonNull
    @Override
    public MyLeftAdapter.LeftViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflate = mInflater.inflate(R.layout.layout_left, viewGroup, false);
        MyLeftAdapter.LeftViewHolder myLeftViewHolder = new MyLeftAdapter.LeftViewHolder(inflate);
        return myLeftViewHolder;
    }

    //绑定数据
    @Override
    public void onBindViewHolder(@NonNull final MyLeftAdapter.LeftViewHolder myLeftViewHolder, final int i) {
        list = left.getData();
        myLeftViewHolder.name.setText(list.get(i).getName());
        myLeftViewHolder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftOnclickListenner.onLeftItemClick(i,list);
            }
        });
 }


    @Override
    public int getItemCount() {
        return left.getData().size();
    }


    public interface LeftOnclickListenner {
        void onLeftItemClick(int i, List<LeftBean.DataBean> dataBeanList);
    }

    class LeftViewHolder extends RecyclerView.ViewHolder {

        TextView  name;

        public LeftViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.title);



        }
    }
}
