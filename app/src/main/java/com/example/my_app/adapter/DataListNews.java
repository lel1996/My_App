package com.example.my_app.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.my_app.R;
import com.example.my_app.bean.News;

import java.util.List;

/**
 * Created by 李二林 on 2018/5/17.
 */

public class DataListNews extends BaseQuickAdapter<News,BaseViewHolder> {
    public DataListNews(@LayoutRes int layoutResId, @Nullable List<News> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, News item) {
    helper.setText(R.id.title,item.getTitle());
        helper.setText(R.id.content,item.getContent());
        Glide.with(mContext).load(item.getImageUrl()).into((ImageView) helper.getView(R.id.image));

    }
}
