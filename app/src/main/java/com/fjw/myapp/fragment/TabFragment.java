package com.fjw.myapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.fjw.myapp.R;
import com.fjw.myapp.adapter.MainListAdapter;
import com.fjw.myapp.model.MainListModel;
import com.fjw.myapp.util.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;


// JUMP 
public class TabFragment extends Fragment {
    RecyclerView mRecyclerView;
    private Context context;
    private int mPage;
    public static final String MERCHANT_DETAILS_PAGE = "MERCHANT_DETAILS_PAGE";



    private MainListAdapter mAdapter;
    private ArrayList<MainListModel> mDatas;

    public static TabFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(MERCHANT_DETAILS_PAGE, page);
        TabFragment tripFragment = new TabFragment();
        tripFragment.setArguments(args);
        return tripFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(MERCHANT_DETAILS_PAGE);
        context = getActivity().getApplicationContext();
        setData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_view, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mRecyclerView);
        switch (mPage){
            case 0:
                initAdapter(mDatas);
                break;
            case 1:
                initAdapter(mDatas);
                break;

        }
        return view;
    }

    private void setData(){
        mDatas = new ArrayList<MainListModel>();
        mDatas.add(new MainListModel(0,"推荐",0));
        mDatas.add(new MainListModel(1,"精选",1));
        mDatas.add(new MainListModel(1,"精选",1));
        mDatas.add(new MainListModel(1,"精选",1));
        mDatas.add(new MainListModel(1,"精选",1));
        mDatas.add(new MainListModel(1,"精选",1));

    }
    /**
     * 设置RecyclerView属性
     */
    private void initAdapter(List<MainListModel> data) {
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        GridLayoutManager mgr = new GridLayoutManager(context, 3);
        mRecyclerView.setLayoutManager(mgr);
        mAdapter = new MainListAdapter(getActivity(),data);

        mRecyclerView.setAdapter(mAdapter);//设置adapter
        //设置item点击事件

    }

}
