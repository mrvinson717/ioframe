package com.fjw.myapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fjw.myapp.R;
import com.fjw.myapp.activity.SearchPicActivity;
import com.fjw.myapp.adapter.GalleryAdapter;
import com.fjw.myapp.adapter.MainListAdapter;
import com.fjw.myapp.model.MainListModel;
import com.fjw.myapp.view.MyRecyclerView;

import java.util.ArrayList;


/**
 * Created by 范佳伟 on 2017/7/24.
 */

public class MainFragment extends BaseFragment {


    private MyRecyclerView mRecyclerView;
    private ArrayList<MainListModel> mDatas;
    private ArrayList<Integer> mDatas1;
    private GalleryAdapter mAdapter;
    private View view;
    private RecyclerView recyclerView;
    private MainListAdapter mMainAdapter;
    private ImageView img_search;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.fragment_main, container,false);


        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(view);

    }

    private void initView(View v) {

        mDatas = new ArrayList<MainListModel>();
        mDatas.add(new MainListModel(0,"推荐",0));
        mDatas.add(new MainListModel(1,"精选",1));
        getStoryIcon();



        mRecyclerView = (MyRecyclerView)v.findViewById(R.id.id_recyclerview_horizontal);
        recyclerView = (RecyclerView)v.findViewById(R.id.recyclerView);
        img_search= (ImageView) v.findViewById(R.id.img_search);
        /**
         * 搜索
         */
        img_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SearchPicActivity.class));
            }
        });

        LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean canScrollHorizontally() {
                return true;
            }
        };
        mRecyclerView.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManager2 =  new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(linearLayoutManager2);
        mAdapter = new GalleryAdapter(getActivity(), mDatas1);

        mRecyclerView.setAdapter(mAdapter);
        mMainAdapter=new MainListAdapter(getActivity(),mDatas);

        recyclerView.setAdapter(mMainAdapter);




    }

    private void getStoryIcon() {

        /**
         * 故事接口
         */

        mDatas1 = new ArrayList<Integer>();

        mDatas1.add(R.mipmap.story_icon);
        mDatas1.add(R.mipmap.story_icon);
        mDatas1.add(R.mipmap.story_icon);
        mDatas1.add(R.mipmap.story_icon);
        mDatas1.add(R.mipmap.story_icon);
        mDatas1.add(R.mipmap.story_icon);
        mDatas1.add(R.mipmap.story_icon);
        mDatas1.add(R.mipmap.story_icon);
        mDatas1.add(R.mipmap.story_icon);
        mDatas1.add(R.mipmap.story_icon);


    }


}
