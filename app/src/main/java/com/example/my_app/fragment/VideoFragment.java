package com.example.my_app.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.my_app.R;
import com.example.my_app.activty.VideoActivity;
import com.example.my_app.adapter.DataListNews;
import com.example.my_app.adapter.DataListVideo;
import com.example.my_app.bean.Video;
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
public class VideoFragment extends Fragment implements
        BaseQuickAdapter.OnItemClickListener {

private View views;
    private List<Video>videos;
    private DataListVideo datalistVideo;
    private RecyclerView recycleview;
    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        views= inflater.inflate(R.layout.fragment_video, container, false);
        initView();
        init();
        return views;
    }

    private void init() {
        videos=new ArrayList<>();
        HttpUtil.getVideo(new Callback<HttpResult<List<Video>>>() {
            @Override
            public void onResponse(Call<HttpResult<List<Video>>> call, Response<HttpResult<List
                                <Video>>> response) {
                datalistVideo.addData(response.body().getData());
            }

            @Override
            public void onFailure(Call<HttpResult<List<Video>>> call, Throwable t) {

            }
        });
        recycleview.setLayoutManager(new LinearLayoutManager(getContext()));
        datalistVideo=new DataListVideo(R.layout.item_video,videos);
        recycleview.setAdapter(datalistVideo);
       datalistVideo.setOnItemClickListener(this);
    }

    private void initView() {
        recycleview= (RecyclerView) views.findViewById(R.id.recycleviwe);
    }




    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

        Video video= (Video) adapter.getItem(position);
        Intent intent=new Intent(getActivity(), VideoActivity.class);
        intent.putExtra("name",video.getName());
        intent.putExtra("url",video.getVideoUrl());
        startActivity(intent);

    }
}
