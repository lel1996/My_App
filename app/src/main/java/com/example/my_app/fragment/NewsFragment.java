package com.example.my_app.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.my_app.R;
import com.example.my_app.adapter.DataListNews;
import com.example.my_app.bean.News;
import com.example.my_app.net.HttpResult;
import com.example.my_app.net.HttpUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
private View mview;
    private RecyclerView recyclerView;
    private List<News> newses;
    private DataListNews dataListNews;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mview= inflater.inflate(R.layout.fragment_news, container, false);
        initView();
        init();

        return mview;
    }

    private void initView() {
        recyclerView= (RecyclerView) mview.findViewById(R.id.recycle);
    }

    private void init() {
        newses=new ArrayList<>();
        HttpUtil.getNew(new Callback<HttpResult<List<News>>>() {
            @Override
            public void onResponse(Call<HttpResult<List<News>>> call, Response<HttpResult<List
                                <News>>> response) {
                dataListNews.addData(response.body().getData());

            }

            @Override
            public void onFailure(Call<HttpResult<List<News>>> call, Throwable t) {

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataListNews=new DataListNews(R.layout.item_news,newses);
        recyclerView.setAdapter(dataListNews);
    }

}
