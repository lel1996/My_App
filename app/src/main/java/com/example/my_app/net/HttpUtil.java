package com.example.my_app.net;

import com.example.my_app.bean.News;
import com.example.my_app.bean.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 李二林 on 2018/5/16.
 */

public class HttpUtil {
public static void getNew(Callback<HttpResult<List<News>>> callback){
    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("http://10.0.2.2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
HttpService httpService=retrofit.create(HttpService.class);
    Call<HttpResult<List<News>>> call=httpService.getNews();
    call.enqueue(callback);
}

    public static void getVideo( Callback<HttpResult<List<Video>>> callback){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HttpService httpService=retrofit.create(HttpService.class);
        Call<HttpResult<List<Video>>> call=httpService.getVideo();
        call.enqueue(callback);
    }
}
