package com.fjw.myapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fjw.myapp.Constant;
import com.fjw.myapp.R;
import com.fjw.myapp.network.RequestServices;
import com.fjw.myapp.util.ToastUtil;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private EditText et_nickname,et_username, et_password, et_code;
    private Button btn_go_login, btn_register, btn_code;
    private String code,username,password,nickname;
    private TextView text_go_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
    }

    private void initView() {

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        et_code = (EditText) findViewById(R.id.et_code);
        et_nickname= (EditText) findViewById(R.id.et_nickname);
        text_go_login = (TextView) findViewById(R.id.text_go_login);
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_code = (Button) findViewById(R.id.btn_send_code);
        btn_register.setOnClickListener(this);
        text_go_login.setOnClickListener(this);
        btn_code.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_go_login:

                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
                break;
            case R.id.btn_register:
                /**
                 * 注册
                 */
                username = et_username.getText().toString();
                password = et_password.getText().toString();
                code=et_code.getText().toString();
               /* if (username.equals("") || username == null) {
                    ToastUtil.showShort(getApplicationContext(), "手机号不能为空");
                    return;
                }

                if (password.equals("")|| password == null) {
                    ToastUtil.showShort(getApplicationContext(), "密码不能为空");
                    return;
                }

                if (username.length() != 11) {

                    ToastUtil.showShort(getApplicationContext(), "请填写正确手机号码");
                    return;
                }

                if (password.length() < 6) {
                    ToastUtil.showShort(getApplicationContext(), "请填写正确的密码");
                    return;
                }
                if (code.equals("")|| code == null) {
                    ToastUtil.showShort(getApplicationContext(), "验证码不能为空");
                    return;
                }*/

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constant.URL_BASE)
                        .build();
                RequestServices service = retrofit.create(RequestServices.class);
                Call<ResponseBody> call = service.registerRequest();
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccess()){

                            String result = response.body().toString();
                            ToastUtil.showShort(RegisterActivity.this,result);


                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });

                break;
           case R.id.btn_send_code:

                btn_code.setEnabled(false);
                timer.start();


                break;


        }

    }


    CountDownTimer timer = new CountDownTimer(60000, 1000) {

        @Override
        public void onTick(long millisUntilFinished) {
            btn_code.setText(millisUntilFinished/1000 + "秒");
        }

        @Override
        public void onFinish() {
            btn_code.setEnabled(true);
            btn_code.setText("发送验证码");
        }
    };




}
