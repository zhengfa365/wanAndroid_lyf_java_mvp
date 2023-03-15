package com.example.lyfwanandroid.module.main.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lib.core.adapter.TabFragmentPagerAdapter;
import com.example.lyfwanandroid.R;
import com.example.lyfwanandroid.module.main.model.TabBean;

public class HomeTabItemAdapter implements TabFragmentPagerAdapter.Page.TabAdapter<TabBean> {
    @Override
    public void bindData(View view, TabBean data, boolean isSelect) {
        ImageView iv_icon = view.findViewById(R.id.iv_tab_icon);
        TextView tv_name = view.findViewById(R.id.tv_tab_name);
        iv_icon.setImageResource(data.getTabIcon());
        tv_name.setText(data.getTabName());
        if (isSelect) {
            iv_icon.setColorFilter(view.getResources().getColor(R.color.light_blue_400));
            tv_name.setTextColor(view.getResources().getColor(R.color.light_blue_400));
        }else{
            iv_icon.setColorFilter(R.color.black);
            tv_name.setTextColor(view.getResources().getColor(R.color.black));
        }
    }
}
