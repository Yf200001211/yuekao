package com.example.yuekao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yuekao.view.FlawLayout;

import java.util.ArrayList;
import java.util.List;

public class SouActivity extends AppCompatActivity {
        private FlawLayout flowLayout;

        private List<String> list=new ArrayList<>();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sou);
            flowLayout = findViewById(R.id.flow);
            for (int i = 0; i <10; i++) {
                list.add("Android");
                list.add("Java");
                list.add("IOS");
                list.add("python");
            }

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(10, 5, 10, 5);
            if (flowLayout != null) {
                flowLayout.removeAllViews();
            }
            for (int i = 0; i < list.size(); i++) {
                TextView tv = new TextView(this);
                tv.setPadding(28, 10, 28, 10);
                tv.setText(list.get(i));
                tv.setMaxEms(10);
                tv.setSingleLine();
             //   tv.setBackgroundResource(R.drawable.selector_playsearch);
                tv.setLayoutParams(layoutParams);
                flowLayout.addView(tv, layoutParams);
            }

        }

}
