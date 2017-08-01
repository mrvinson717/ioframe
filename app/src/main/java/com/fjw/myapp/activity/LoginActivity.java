package com.fjw.myapp.activity;



import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;

import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.fjw.myapp.Constant;
import com.fjw.myapp.R;

import com.fjw.myapp.model.LoginModel;
import com.fjw.myapp.network.RequestServices;
import com.fjw.myapp.util.ToastUtil;

import com.fjw.myapp.util.ZZUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivity extends BaseActivity implements OnClickListener{

private EditText et_username,et_password;
    private Button btn_login,btn_wx_login,btn_wb_login;
    private TextView btn_go_register;
    private String username;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initState();
        initView();

    }
    private void initState() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
    private void initView() {

        et_username= (EditText) findViewById(R.id.et_username);
        et_password= (EditText) findViewById(R.id.et_password);
        btn_login= (Button) findViewById(R.id.btn_login);

       btn_go_register= (TextView) findViewById(R.id.btn_go_register);
       // btn_wb_login= (Button) findViewById(R.id.btn_wb_login);
       // btn_wx_login= (Button) findViewById(R.id.btn_wx_login);
       // btn_wx_login.setOnClickListener(this);
       // btn_wb_login.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        btn_go_register.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
           case R.id.btn_login:
               username = et_username.getText().toString();
               password = et_password.getText().toString();

            if (username.equals("") || username == null) {
                  ToastUtil.showShort(getApplicationContext(), "请输入手机号码");
                   return;
               }

               if (password.equals("")|| password == null) {
                   ToastUtil.showShort(getApplicationContext(), "请输入密码");
                   return;
               }

               if (!ZZUtil.isMobile(username)) {

                   ToastUtil.showShort(getApplicationContext(), "请填写正确手机号码");
                   return;
               }

               if (!ZZUtil.isPassword(password)) {
                   ToastUtil.showShort(getApplicationContext(), "请填写正确的密码");
                   return;
               }
               startActivity(new Intent(LoginActivity.this,MainActivity.class));
               finish();
              /* Gson gson = new GsonBuilder()
                       .create();
               Retrofit retrofit = new Retrofit.Builder()
                       .baseUrl(Constant.URL_BASE)
                       .addConverterFactory(GsonConverterFactory.create(gson))
                       .build();
               RequestServices service = retrofit.create(RequestServices.class);
               Call<LoginModel> call = service.loginRequest();
               call.enqueue(new Callback<LoginModel>() {
                   @Override
                   public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                           if(response.isSuccess()){

                                   String result = response.body().getLogin();
                                   ToastUtil.showShort(LoginActivity.this,result);

                                   startActivity(new Intent(LoginActivity.this,MainActivity.class));

                           }


                   }

                   @Override
                   public void onFailure(Call<LoginModel> call, Throwable t) {

                   }
               });*/
            break;

            case R.id.btn_go_register:

              startActivity(new Intent(LoginActivity.this,RegisterActivity.class));

                break;

           /* case R.id.btn_wx_login:


                break;


            case R.id.btn_wb_login:

                break;*/
        }
    }



}

