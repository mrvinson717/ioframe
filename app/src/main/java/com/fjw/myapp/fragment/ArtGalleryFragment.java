package com.fjw.myapp.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fjw.myapp.R;
import com.fjw.myapp.adapter.ArtGalleryListAdapter;
import com.fjw.myapp.util.ToastUtil;

import java.util.ArrayList;


/**
 * Created by Administrator on 2017/7/24.
 */

public class ArtGalleryFragment extends BaseFragment {



    private ArrayList<Integer> mDatas;

    private View view;
    private RecyclerView recyclerView;
    private ArtGalleryListAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.fragment_art_gallery, container,false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(view);
    }

    private void initView(View v) {

        mDatas = new ArrayList<Integer>();
        mDatas.add(0,R.mipmap.ic_launcher);
        mDatas.add(1,R.mipmap.ic_launcher);


        /*mSwipeLayout = (SwipeRefreshLayout) v.findViewById(R.id.srl);*/

        recyclerView = (RecyclerView)v.findViewById(R.id.recyclerView);



        LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(linearLayoutManager);

        mAdapter=new ArtGalleryListAdapter(getActivity(),mDatas);
        mAdapter.setOnItemClickLitener(new ArtGalleryListAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {

                ToastUtil.showShort(getActivity(),"点击"+position);

            }
        });
        recyclerView.setAdapter(mAdapter);

        /*recyclerView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    if(recyclerView.getChildCount()>0){
                        recyclerView.getChildAt(0).requestFocus();

                    }
                }
            }
        });*/
      //  mSwipeLayout.setOnRefreshListener(this);


    }


   /* @Override
    public void onRefresh() {
        mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE, 2000);



    }*/
}
