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
import com.example.yuekao.bean.JsonBean;

public class MyRightAdapter extends RecyclerView.Adapter<MyRightAdapter.MyRightViewHolder> {
    private Context context;
    private JsonBean jsonBean;
    private MyRightViewHolder myRightViewHolder;

    public MyRightAdapter(Context context, JsonBean jsonBean) {
        this.context = context;
        this.jsonBean = jsonBean;
    }

    @NonNull
    @Override
    public MyRightViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.layout_list4, null);
        myRightViewHolder = new MyRightAdapter.MyRightViewHolder(view);
        return myRightViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRightViewHolder myRightViewHolder, int i) {
        myRightViewHolder.name.setText(jsonBean.getData().get(i).getList().get(i).getName());
        Glide.with(context).load(jsonBean.getData().get(i).getList().get(i).getIcon()).into(myRightViewHolder.img);
    }

    @Override
    public int getItemCount() {
        return jsonBean.getData().size();
    }

    public class MyRightViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        public MyRightViewHolder(View view) {
            super(view);
            img = itemView.findViewById(R.id.image4);
            name =  itemView.findViewById(R.id.title4);
        }
    }
}
