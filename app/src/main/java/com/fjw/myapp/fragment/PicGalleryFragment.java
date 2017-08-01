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
import com.fjw.myapp.adapter.TopicArtistListAdapter;
import com.fjw.myapp.adapter.TopicGalleryListAdapter;
import com.fjw.myapp.adapter.TopicListAdapter;
import com.fjw.myapp.fragment.BaseFragment;
import com.fjw.myapp.util.ToastUtil;

import java.util.ArrayList;


/**
 * Created by Administrator on 2017/7/24.
 */

public class PicGalleryFragment extends BaseFragment {



    private ArrayList<Integer> mDatas;

    private View view;
    private RecyclerView recyclerView1,recyclerView2,recyclerView3;
    private TopicListAdapter mAdapter;
    private TopicArtistListAdapter mArtistAdapter;
    private TopicGalleryListAdapter mGalleryAdapter;
    private ImageView img_search;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.fragment_pic_gallery, container,false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(view);
    }

    private void initView(View v) {

        mDatas = new ArrayList<Integer>();
        mDatas.add(R.mipmap.ic_launcher);
        mDatas.add(R.mipmap.ic_launcher);
        mDatas.add(R.mipmap.ic_launcher);
        mDatas.add(R.mipmap.ic_launcher);
        mDatas.add(R.mipmap.ic_launcher);
        mDatas.add(R.mipmap.ic_launcher);
        recyclerView1 = (RecyclerView)v.findViewById(R.id.id_recyclerview_horizontal);
        recyclerView2 = (RecyclerView)v.findViewById(R.id.id_recyclerview_horizontal2);
        recyclerView3 = (RecyclerView)v.findViewById(R.id.id_recyclerview_horizontal3);

        img_search= (ImageView) v.findViewById(R.id.img_search);
        img_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SearchPicActivity.class));
            }
        });

        LinearLayoutManager linearLayoutManager1 =  new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean canScrollHorizontally() {
                return true;
            }
        };

        recyclerView1.setLayoutManager(linearLayoutManager1);

        mAdapter=new TopicListAdapter(getActivity(),mDatas);
        mAdapter.setOnItemClickLitener(new TopicListAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {

                ToastUtil.showShort(getActivity(),"点击"+position);

            }
        });
        recyclerView1.setAdapter(mAdapter);


        LinearLayoutManager linearLayoutManager2 =  new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean canScrollHorizontally() {
                return true;
            }
        };

        recyclerView2.setLayoutManager(linearLayoutManager2);

        mArtistAdapter=new TopicArtistListAdapter(getActivity(),mDatas);
        mArtistAdapter.setOnItemClickLitener(new TopicArtistListAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {

                ToastUtil.showShort(getActivity(),"点击"+position);

            }
        });
        recyclerView2.setAdapter(mArtistAdapter);



        LinearLayoutManager linearLayoutManager3 =  new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean canScrollHorizontally() {
                return true;
            }
        };

        recyclerView3.setLayoutManager(linearLayoutManager3);

        mGalleryAdapter=new TopicGalleryListAdapter(getActivity(),mDatas);
        mGalleryAdapter.setOnItemClickLitener(new TopicGalleryListAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {

                ToastUtil.showShort(getActivity(),"点击"+position);

            }
        });
        recyclerView3.setAdapter(mGalleryAdapter);


    }



}
