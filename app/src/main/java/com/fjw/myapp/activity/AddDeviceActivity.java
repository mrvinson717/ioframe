package com.fjw.myapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fjw.myapp.Constant;
import com.fjw.myapp.R;
import com.fjw.myapp.network.RequestServices;
import com.fjw.myapp.util.ToastUtil;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AddDeviceActivity extends BaseActivity implements View.OnClickListener {

    private EditText et_ID;
    private Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device);
        initView();
    }

    private void initView() {
            et_ID= (EditText) findViewById(R.id.et_ID);
        btn_add= (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:

                /**
                 * 添加设备ID接口
                 */
                String addID=et_ID.getText().toString();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constant.URL_BASE)
                        .build();
                RequestServices service = retrofit.create(RequestServices.class);
                Call<ResponseBody> call = service.addDeviceRequest();
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccess()){

                            String result = response.body().toString();
                            finish();


                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });



                break;
        }
    }
}
