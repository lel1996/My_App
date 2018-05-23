package com.example.my_app.net;

import com.example.my_app.bean.News;
import com.example.my_app.bean.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 李二林 on 2018/5/16.
 */

public interface HttpService {
    @GET("news.php")
    Call<HttpResult<List<News>>> getNews();

    @GET("video.php")
    Call<HttpResult<List<Video>>> getVideo();
}
