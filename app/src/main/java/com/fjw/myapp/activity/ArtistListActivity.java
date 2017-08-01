package com.fjw.myapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.fjw.myapp.R;

/**
 * 艺术家列表
 */
public class ArtistListActivity extends BaseActivity {

    private ImageView iv_back,iv_search;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_list);

              initView();

    }

    private void initView() {


    }
}
