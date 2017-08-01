package com.fjw.myapp.activity;


import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.SearchView;

import android.view.Gravity;
import android.view.View;

import android.view.WindowManager;
import android.widget.ImageView;

import android.widget.LinearLayout;
import android.widget.TextView;

import com.fjw.myapp.Constant;
import com.fjw.myapp.R;
import com.fjw.myapp.network.RequestServices;

import com.fjw.myapp.util.ToastUtil;
import com.fjw.myapp.view.FlowLayout;

import java.lang.reflect.Field;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SearchPicActivity extends BaseActivity implements View.OnClickListener {
    private SearchView searchView;
    private RecyclerView recyclerView;
    private FlowLayout flowLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_pic);
        initState();
        initView();
    }

    private void initView () {


        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        flowLayout= (FlowLayout) findViewById(R.id.flowLayout);
        searchView= (SearchView) findViewById(R.id.sv_search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                ToastUtil.showShort(SearchPicActivity.this,"搜索内容："+query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        setSearchView();

        hot_search();

    }

    private void hot_search() {
        /**
         * 热门搜索标签接口

         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.URL_BASE)
                .build();
        RequestServices service = retrofit.create(RequestServices.class);
        Call<ResponseBody> call = service.hotSearchPicRequest();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccess()){

                    String result = response.body().toString();
                  String[] mDatas = new String[]{"梵高",
                            "达芬奇",
                            "纽约现代艺术博物馆"
                          };


                    for(int i=0;i<mDatas.length;i++){

                        final TextView view = new TextView(SearchPicActivity.this);
                        view.setText(mDatas[i]);
                         view.setTextSize(14);



                        flowLayout.addView(view);
                    }


                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }

    @Override
    public void onClick(View v) {

    }
    private void initState() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    public void setSearchView() {
        searchView.setIconifiedByDefault(false);

        SearchView.SearchAutoComplete mSearchSrcTextView = (SearchView.SearchAutoComplete) findViewById(R.id.search_src_text);
        mSearchSrcTextView.setTextSize(16);
        ImageView mCollapsedIcon = (ImageView) findViewById(R.id.search_mag_icon);//输入框内Icon
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(60,60);
        layoutParams.gravity= Gravity.CENTER;

        mCollapsedIcon.setLayoutParams(layoutParams);
        mCollapsedIcon.setPadding(5,5,5,5);
        mCollapsedIcon.setScaleType(ImageView.ScaleType.FIT_XY);

        Class<?> c=searchView.getClass();
        try {
            Field f=c.getDeclaredField("mSearchPlate");//通过反射，获得类对象的一个属性对象
            f.setAccessible(true);//设置此私有属性是可访问的
            View v=(View) f.get(searchView);//获得属性的值
            v.setBackgroundResource(R.drawable.search);//设置此view的背景


        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
