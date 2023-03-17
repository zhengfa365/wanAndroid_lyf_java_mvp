package com.example.lyfwanandroid.module.main.adapter;

import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lyfwanandroid.R;
import com.example.lyfwanandroid.module.main.model.ArticleBean;

public class ArticleAdapter extends BaseQuickAdapter<ArticleBean, BaseViewHolder> {
    public ArticleAdapter(int layoutResId) {
        super(R.layout.rv_item_article);
    }


    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, ArticleBean articleBean) {
        TextView tv_title=baseViewHolder.itemView.findViewById(R.id.tv_title);
        TextView tv_desc=baseViewHolder.itemView.findViewById(R.id.tv_desc);
        tv_title.setText(articleBean.getTitle());
        tv_desc.setText(articleBean.getDesc());
    }
}
