package com.fjw.myapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fjw.myapp.R;
import com.fjw.myapp.activity.SettingActivity;
import com.fjw.myapp.adapter.CommonTabPagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by 范佳伟 on 2017/7/24.
 */

public class MyFragment extends BaseFragment implements CommonTabPagerAdapter.TabPagerListener {




    private LinearLayout ll2;

    private View view;

    private ViewPager viewpager;
    private TabLayout tabLayout;
    private TextView txt_set;

    private CommonTabPagerAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.fragment_my, container,false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(view);
    }

    private void initView(View v) {

        txt_set= (TextView)v.findViewById(R.id.text_setting);
        ll2= (LinearLayout) v.findViewById(R.id.ll2);
         viewpager= (ViewPager) v.findViewById(R.id.viewpager);
        tabLayout= (TabLayout) v.findViewById(R.id.tabLayout);
        txt_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),SettingActivity.class));
            }
        });

        adapter = new CommonTabPagerAdapter(getFragmentManager()
                , 2, Arrays.asList("我收藏的", "历史推送"), getActivity());
        adapter.setListener(this);
        viewpager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewpager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

    }





    @Override
    public Fragment getFragment(int position) {
        return TabFragment.newInstance(position);
    }
}
