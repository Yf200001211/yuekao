package com.example.yuekao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuekao.bean.HomeBean;
import com.example.yuekao.presenter.LoginPresenter;
import com.example.yuekao.view.ILoginView;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {
    private EditText ed_login,ed_pwd;
    private CheckBox checkBox;
    private TextView zhuce;
    private Button btn_login,btn_san;
    private String name,pwd;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_login=findViewById(R.id.ed_login);
        ed_pwd=findViewById(R.id.ed_pwd);
        checkBox=findViewById(R.id.jizhu);
        zhuce=findViewById(R.id.zhuce);
        zhuce.setOnClickListener(this);
        btn_login=findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        btn_san=findViewById(R.id.btn_san);
        loginPresenter = new LoginPresenter(this);
        SharedPreferences config = getSharedPreferences("config", MODE_PRIVATE);
        String name1 = config.getString("name", "");
        String pwd1 = config.getString("pwd", "");
        boolean flag = config.getBoolean("flag", false);
        checkBox.setChecked(flag);
        if(flag){
            ed_login.setText(name1);
            ed_pwd.setText(pwd1);
        }

    }

    @Override
    public void getLoginData(final String data) {
        Gson gson = new Gson();
        final HomeBean homeBean = gson.fromJson(data, HomeBean.class);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,homeBean.getMsg(),Toast.LENGTH_SHORT).show();
                if(homeBean.getMsg().equals("登录成功")){
                    SharedPreferences config = getSharedPreferences("config", MODE_PRIVATE);
                    SharedPreferences.Editor edit = config.edit();
                    if(checkBox.isChecked()){
                        edit.putString("name",name);
                        edit.putString("pwd",pwd);
                        edit.putBoolean("flag",true);
                    }else{
                        edit.putBoolean("flag",false);
                    }
                    edit.commit();
                    startActivity(new Intent(MainActivity.this,ShowActivity.class));
                }


            }
        });

    }

    @Override
    public void getZhuData(String data) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                name = ed_login.getText().toString();
                pwd=ed_pwd.getText().toString();
                if (name!=null&&pwd!=null){
                    loginPresenter.getModelData(name,pwd);
                }
                break;
            case R.id.zhuce:
                startActivity(new Intent(MainActivity.this,ZhuActivity.class));
                break;
        }

    }
}
