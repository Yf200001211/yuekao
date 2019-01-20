package com.example.yuekao.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.yuekao.R;
import com.example.yuekao.adapter.MyShopAdapter;
import com.example.yuekao.bean.CarBean;

import java.util.List;


public class CustomAddView extends RelativeLayout implements View.OnClickListener {
    Context mContext;
    private EditText edit_price;
    private int num;
    private MyShopAdapter.MyShopViewHolder myShopAdapter;
    private List<CarBean.DataBean.ListBean> beanList;
    private int position;

    public CustomAddView(Context context) {
        super(context);
        init(context);
    }

    public CustomAddView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomAddView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context) {
        this.mContext = context;
        View view = View.inflate(context, R.layout.shop_carprice, null);
        ImageView jia =  view.findViewById(R.id.jia);
        ImageView jian = view.findViewById(R.id.jian);
        edit_price = view.findViewById(R.id.edit_price);
        jia.setOnClickListener(this);
        jian.setOnClickListener(this);
        addView(view);

        edit_price.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                num = Integer.parseInt(s.toString());
                //TODO:改变数量
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jia:
                num++;
                edit_price.setText(num+"");
                beanList.get(position).setNum(num);
                mCallBackListener.callBack();
                break;
            case R.id.jian:
                if (num > 1) {
                    num--;
                } else {
                    Toast.makeText(mContext, "商品数量不能小于1", Toast.LENGTH_LONG).show();
                }
                edit_price.setText(num+"");
                beanList.get(position).setNum(num);
                mCallBackListener.callBack();
                break;
            default:
                break;
        }
    }
    public void setData(MyShopAdapter.MyShopViewHolder myShopAdapter, List<CarBean.DataBean.ListBean> beanList, int i){
        this.myShopAdapter = myShopAdapter;
        this.beanList = beanList;
        position=i;
        num=beanList.get(i).getNum();
        edit_price.setText(num+"");
    }
    private CallBackListener mCallBackListener;

    public void setOnCallBack(CallBackListener listener) {
        this.mCallBackListener = listener;
    }

    public interface CallBackListener {
        void callBack();
    }

}
