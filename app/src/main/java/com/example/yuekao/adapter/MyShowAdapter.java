package com.example.yuekao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yuekao.R;
import com.example.yuekao.bean.HomeBean;

public class MyShowAdapter extends RecyclerView.Adapter {
    private Context context;
    private HomeBean homeBean;
    private final int ONE = 0;
    private final int TWO = 1;
    private final int SAN = 2;
    private MyItem1ViewHolder myItem1ViewHolder;
    private MyItem2ViewHolder myItem2ViewHolder;
    private MyItem3ViewHolder myItem3ViewHolder;
    private OneShowAdapter oneShowAdapter;
    private TwoShowAdapter twoShowAdapter;
    private SanShowAdapter sanShowAdapter;

    public MyShowAdapter(Context context, HomeBean homeBean) {
        this.context = context;
        this.homeBean = homeBean;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mview;
        if(i==ONE)
        {
            mview=View.inflate(viewGroup.getContext(),R.layout.shouye_1,null);
            return new MyItem1ViewHolder(mview);
        }else if(i == TWO)
        {
            return new MyItem2ViewHolder(LayoutInflater.from(context).inflate(R.layout.shouye_2,viewGroup,false));
        }
        else {
            return new MyItem3ViewHolder(LayoutInflater.from(context).inflate(R.layout.shouye_3,viewGroup,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MyItem1ViewHolder){
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context,5);
            gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
            ((MyItem1ViewHolder) viewHolder).rv1.setLayoutManager(gridLayoutManager);
            oneShowAdapter = new OneShowAdapter(context,homeBean.getData().getFenlei());
            ((MyItem1ViewHolder) viewHolder).rv1.setAdapter(oneShowAdapter);
        }
        if (viewHolder instanceof MyItem2ViewHolder){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
            ((MyItem2ViewHolder) viewHolder).rv2.setLayoutManager(linearLayoutManager);
            twoShowAdapter= new TwoShowAdapter(context,homeBean.getData().getMiaosha());
            ((MyItem2ViewHolder) viewHolder).rv2.setAdapter(twoShowAdapter);

        }
        if (viewHolder instanceof MyItem3ViewHolder){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
            ((MyItem3ViewHolder) viewHolder).rv3.setLayoutManager(linearLayoutManager);
            sanShowAdapter= new SanShowAdapter(context,homeBean.getData().getTuijian());
            ((MyItem3ViewHolder) viewHolder).rv3.setAdapter(sanShowAdapter);


        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                return ONE;
            case 1:
                return TWO;
        }
        return SAN;
    }

    public class MyItem1ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rv1;
        public MyItem1ViewHolder(View view) {
            super(view);
            rv1 = itemView.findViewById(R.id.rv1);
        }
    }

    public class MyItem2ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rv2;
        public MyItem2ViewHolder(View view) {
            super(view);
            rv2 = itemView.findViewById(R.id.rv2);
        }
    }

    public class MyItem3ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rv3;
        public MyItem3ViewHolder(View view) {
            super(view);
            rv3 = itemView.findViewById(R.id.rv3);
        }
    }
}
