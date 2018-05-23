package com.example.my_app.activty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.my_app.R;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class VideoActivity extends AppCompatActivity {
    private JZVideoPlayerStandard jzVideoPlayerStandard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        jzVideoPlayerStandard= (JZVideoPlayerStandard) findViewById(R.id.jiaozi);

        Intent intent=getIntent();
        jzVideoPlayerStandard.setUp(intent.getStringExtra("name"),jzVideoPlayerStandard.SCREEN_WINDOW_NORMAL,intent.getStringExtra("url"));


    }
    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }
}
