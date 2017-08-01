package com.fjw.myapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fjw.myapp.R;

public class SettingActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout ll1,ll2,ll3,ll4,ll5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initView();
    }

    private void initView() {

        ll1= (LinearLayout) findViewById(R.id.ll1);
        ll2= (LinearLayout) findViewById(R.id.ll2);
        ll3= (LinearLayout) findViewById(R.id.ll3);
        ll4= (LinearLayout) findViewById(R.id.ll4);
        ll5= (LinearLayout) findViewById(R.id.ll5);
        ll1.setOnClickListener(this);
        ll2.setOnClickListener(this);
        ll3.setOnClickListener(this);
        ll4.setOnClickListener(this);
        ll5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
         switch (v.getId()){

             case R.id.ll1:
                 startActivity(new Intent(SettingActivity.this,FeedbackActivity.class));
                 break;
             case R.id.ll2:
                 startActivity(new Intent(SettingActivity.this,AboutWeActivity.class));
                 break;
             case R.id.ll3:
                 break;
             case R.id.ll4:
                 startActivity(new Intent(SettingActivity.this,MyFrameActivity.class));
                 break;
             case R.id.ll5:
                 break;

         }
    }
}
