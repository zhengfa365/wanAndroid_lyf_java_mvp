package com.example.wanandroid_lyf_java_mvp.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wanandroid_lyf_java_mvp.R;
import com.example.wanandroid_lyf_java_mvp.ui.view.BottomBar;
import com.example.wanandroid_lyf_java_mvp.ui.view.BottomBarTab;

import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportFragment;

public class MainFragment  extends SupportFragment {
    private SupportFragment[] mFragments=new SupportFragment[3];
    private BottomBar mBottomBar;

    public static ISupportFragment newInstance() {
        MainFragment fragment=new MainFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable  Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        SupportFragment firstFragment = findChildFragment(HomeFragment.class);
//        if (firstFragment == null) {
            mFragments[0] = HomeFragment.newInstance();
            mFragments[1] = QAFragment.newInstance();
            mFragments[2] = HomeFragment.newInstance();
//
            loadMultipleRootFragment(R.id.fl_tab_content, 0,
                    mFragments[0],
                    mFragments[1],
                    mFragments[2]);
//        } else {
//            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题
//
//            // 这里我们需要拿到mFragments的引用
//            mFragments[0] = firstFragment;
//            mFragments[1] = findChildFragment(QAFragment.class);
//            mFragments[2] = findChildFragment(HomeFragment.class);
//        }
    }

    private void initView(View view) {
        mBottomBar = (BottomBar) view.findViewById(R.id.bottomBar);
        mBottomBar
                .addItem(new BottomBarTab(_mActivity, R.drawable.ic_launcher_foreground, "msg"))
                .addItem(new BottomBarTab(_mActivity, R.drawable.ic_launcher_foreground, "discover"))
                .addItem(new BottomBarTab(_mActivity, R.drawable.ic_launcher_foreground, "more"));

        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                Log.i("lyf","position:"+position+"prePosition"+prePosition);
                showHideFragment(mFragments[position], mFragments[prePosition]);
                BottomBarTab tab = mBottomBar.getItem(0);

                if (position == 0) {
                    tab.setUnreadCount(0);
                } else {
                    tab.setUnreadCount(tab.getUnreadCount() + 1);
                }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });

    }
}
