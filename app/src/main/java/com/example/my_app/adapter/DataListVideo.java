package com.example.my_app.adapter;

import android.graphics.Bitmap;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.my_app.R;
import com.example.my_app.bean.Video;

import java.util.List;

import wseemann.media.FFmpegMediaMetadataRetriever;

/**
 * Created by 李二林 on 2018/5/17.
 */

public class DataListVideo extends BaseQuickAdapter<Video,BaseViewHolder> {
    public DataListVideo(@LayoutRes int layoutResId, @Nullable List<Video> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Video item) {
        helper.setText(R.id.kongcheng,item.getName());
    helper.setImageBitmap(R.id.suolvtu,getBitmap(item.getVideoUrl()));
    }
    public Bitmap getBitmap(String videourl) {
     /* Log.i(TAG, "getBitmap: 00000000000000"+videourl);*/
        FFmpegMediaMetadataRetriever mmr = new FFmpegMediaMetadataRetriever();
        mmr.setDataSource(videourl);
        mmr.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_ALBUM);
        mmr.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_ARTIST);
        Bitmap b = mmr.getFrameAtTime(2000000, FFmpegMediaMetadataRetriever.OPTION_CLOSEST); //
        // frame at 2 seconds
        byte[] artwork = mmr.getEmbeddedPicture();

        mmr.release();
        return b;
    }
}
