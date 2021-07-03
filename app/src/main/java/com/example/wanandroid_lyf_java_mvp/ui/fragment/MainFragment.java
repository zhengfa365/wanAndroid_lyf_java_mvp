package com.example.wanandroid_lyf_java_mvp.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.wanandroid_lyf_java_mvp.R;
import com.example.wanandroid_lyf_java_mvp.basic.base.BaseFragment;
import com.example.wanandroid_lyf_java_mvp.basic.mvp.MvpFragment;
import com.example.wanandroid_lyf_java_mvp.basic.mvp.MvpPresenter;
import com.example.wanandroid_lyf_java_mvp.ui.view.BottomBar;
import com.example.wanandroid_lyf_java_mvp.ui.view.BottomBarTab;


public class MainFragment  extends BaseFragment {
    private MvpFragment[] mFragments=new MvpFragment[3];
    private BottomBar mBottomBar;
    private ViewPager vp_tab_content;


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_main;
    }

    @Override
    protected MvpPresenter initPresenter() {
        return null;
    }


    @Override
    protected void loadData() {
        mFragments[0] = HomeFragment.newInstance();
        mFragments[1] = QAFragment.newInstance();
        mFragments[2] = HomeFragment.newInstance();
        vp_tab_content.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager(),1) {

            @Override
            public Fragment getItem(int position) {
                return mFragments[position];
            }

            @Override
            public int getCount() {
                return mFragments.length;
            }
        });
    }

    @Override
    protected void initView() {
        mBottomBar = mRootView.findViewById(R.id.bottomBar);
        vp_tab_content=mRootView.findViewById(R.id.vp_tab_content);
        mBottomBar
                .addItem(new BottomBarTab(getContext(), R.drawable.ic_launcher_foreground, "msg"))
                .addItem(new BottomBarTab(getContext(), R.drawable.ic_launcher_foreground, "discover"))
                .addItem(new BottomBarTab(getContext(), R.drawable.ic_launcher_foreground, "more"));

        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                BottomBarTab tab = mBottomBar.getItem(0);

                if (position == 0) {
                    tab.setUnreadCount(0);
                } else {
                    int redCount=tab.getUnreadCount();
                    tab.setUnreadCount(tab.getUnreadCount() + 1);
                }
                vp_tab_content.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
        vp_tab_content.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBottomBar.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }
}
