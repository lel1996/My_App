package com.example.my_app.bean;

/**
 * Created by 李二林 on 2018/5/17.
 */

public class Video {
    private int id;
    private String name;
    private String videoUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                '}';
    }
}
